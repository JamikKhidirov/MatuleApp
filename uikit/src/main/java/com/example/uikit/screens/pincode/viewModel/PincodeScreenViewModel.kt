package com.example.uikit.screens.pincode.viewModel

import androidx.compose.ui.draw.InnerShadowScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.PincodeDataStore
import com.example.domain.PinCodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PincodeScreenViewModel @Inject constructor(
    private val pincodeDataStore: PinCodeRepository
) : ViewModel() {


    private val _enteredPin = MutableStateFlow("")
    val enteredPin: StateFlow<String> = _enteredPin.asStateFlow()


    fun onNumberClick(
        d: String,
        pinLength: Int,
        onPinEntered: (String) -> Unit
    ) {
        if (enteredPin.value.length < pinLength) {
            _enteredPin.value += d
            if (enteredPin.value.length == pinLength) {
                onPinEntered(enteredPin.value)
                viewModelScope.launch {
                    pincodeDataStore.saveData(data = enteredPin.value)
                }
            }
        }
    }


    fun onDelete() {
        if (enteredPin.value.isNotEmpty()){
            _enteredPin.value = _enteredPin.value.dropLast(1)
        }
    }


}