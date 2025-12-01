package navigation

import kotlinx.serialization.Serializable


@Serializable
sealed interface Destination {

    // Маршрут без аргументов (Главный экран)
    @Serializable
    data object Home : Destination

    // Маршрут с аргументом (Экран деталей)
    // Item должен быть @Serializable data class или object
    @Serializable
    data class Details(val item: MySerializableData) : Destination

    // Базовый маршрут для вложенного графа (например, Аутентификация)
    @Serializable
    data object AuthGraph : Destination



    //Экраны
    @Serializable
    data object LogInScreen: Destination


    @Serializable
    data object HomeScreen: Destination

    @Serializable
    data object CreateUserScreen: Destination

    @Serializable
    data object CreateUserPassword: Destination

    @Serializable
    data object CreatePincodeScreen

}



/**
 * Пример вашего передаваемого объекта.
 * Он должен быть Serializable.
 */
@Serializable
data class MySerializableData(
    val id: Int,
    val name: String,
    val description: String
)
