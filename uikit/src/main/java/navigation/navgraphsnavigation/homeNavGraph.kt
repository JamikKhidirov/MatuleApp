package navigation.navgraphsnavigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.uikit.screens.home.HomeScreen
import com.example.uikit.screens.pincode.PinScreen
import navigation.destinations.HomeDestination


fun NavGraphBuilder.homeNavGraph(
    navHostController: NavHostController
){
    navigation<HomeDestination.HomeRoot>(startDestination = HomeDestination.UserPincodeScreen){

        composable<HomeDestination.UserPincodeScreen> { backsackEntry ->
            PinScreen(
                isCreateMode = false,
                firstTextScreen = "Вход",
                onPinEntered = { pincode ->
                    /*Тут приходит код от пользователя, если код правильный
                    * пропускаем пользователя на другой экран если нет то не пропускаем! */
                },
                onPinVerified = { isCorrect ->
                    if (isCorrect){
                        navHostController.navigate(HomeDestination.HomeScreen){
                            popUpTo(HomeDestination.UserPincodeScreen){
                                inclusive = true
                            }
                        }
                    }

                }
            )
        }


        composable<HomeDestination.HomeScreen>{
            HomeScreen(
                navController = navHostController
            )
        }

        composable<HomeDestination.BascketScreen>{

            //Экран BacketScreen для корзины
        }

    }
}

