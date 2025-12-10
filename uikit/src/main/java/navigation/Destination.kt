package navigation

import kotlinx.serialization.Serializable




@Serializable
sealed interface Destination



@Serializable
sealed interface AuthDestination: Destination {

    //Путь Auth графа
    @Serializable
    data object AuthRoot: AuthDestination


    //Путь LoginScreen экрана
    @Serializable
    data object LoginScreen: AuthDestination


    //Путь CreateAccount экрана
    @Serializable
    data object CreateUserScreen: AuthDestination

    //Путь CreatePassword экрана
    @Serializable
    data object CreateUserPasswordScreen: AuthDestination


    //Путь CreatePinCode экрана
    @Serializable
    data object CreateUserPincodeScreen: AuthDestination



    companion object {
        //Метод указывать на путь графа для NavHosta
        fun getStartRoute() = AuthRoot
    }

}


@Serializable
sealed interface HomeDestination: Destination {

    //Путь Home графа
    @Serializable
    data object HomeRoot: HomeDestination


    @Serializable
    data object HomeScreen: HomeDestination


    //Экран корзины
    @Serializable
    data object BascketScreen: HomeDestination


    companion object {
        //Метод указывать на путь графа для NavHosta
        fun getHomeRoom() = HomeRoot
    }
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
