package com.example.uikit.screens.pincode.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.PinCodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PincodeScreenViewModel @Inject constructor(
    private val pincodeDataStore: PinCodeRepository
) : ViewModel() {


    private val _enteredPin = MutableStateFlow("")
    val enteredPin: StateFlow<String> = _enteredPin.asStateFlow()

    val savedPinCode: Flow<String?> = pincodeDataStore.codeFlow


    private val _isError = MutableStateFlow<Boolean>(false)
    val isError: StateFlow<Boolean> = _isError.asStateFlow()




    fun onNumberClick(
        d: String,
        pinLength: Int,
        isCreateMode: Boolean = false,
        onPinEntered: (String) -> Unit,
        onPinVerified: (Boolean) -> Unit  = {}//Колбек для проверки кода
    ) {
        if (_enteredPin.value.length >= pinLength) return
        if (enteredPin.value.length < pinLength) {
            _enteredPin.value += d
            _isError.value = false // Сбрасываем ошибку при новом вводе

            if (enteredPin.value.length == pinLength) {
                onPinEntered(enteredPin.value)
                viewModelScope.launch {

                    if (isCreateMode){
                        /* Тут мы в режиме первого входа пользователя в аккаунт
                        кэшируем код от пользоавтеля, пожзе мы будем доставать из кэша
                        * */
                        pincodeDataStore.clearDataDataStore()
                        pincodeDataStore.saveData(enteredPin.value)
                        onPinVerified(true)
                    }
                    else{
                        //Пользоваль уже зашел в аккаунт сверяем код из кеша и новым вводом
                        val saved = savedPinCode.firstOrNull()
                        val isCorrect = saved == enteredPin.value

                        if (isCorrect){
                            onPinVerified(true)
                        }
                        else{
                            //Пользователь неправльно ввел пороль
                            _isError.value = true
                            onPinVerified(false)
                        }
                    }
                }
            }
        }
    }


    fun onDelete() {
        if (enteredPin.value.isNotEmpty()){
            _enteredPin.value = _enteredPin.value.dropLast(1)
        }
    }

    fun clearPin() {
        _enteredPin.value = ""
        _isError.value = false
    }


}