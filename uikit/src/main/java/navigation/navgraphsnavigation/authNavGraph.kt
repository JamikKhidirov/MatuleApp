package navigation.navgraphsnavigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.uikit.screens.createuser.CreateUserPassword
import com.example.uikit.screens.createuser.CreateUserScreen
import com.example.uikit.screens.login.LogInScreenScreen
import com.example.uikit.screens.pincode.PinScreen
import navigation.AuthDestination
import navigation.HomeDestination


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
){

    navigation<AuthDestination.AuthRoot>(startDestination = AuthDestination.LoginScreen){
        composable<AuthDestination.LoginScreen> {
            LogInScreenScreen(
                navController = navController
            )
        }
        composable<AuthDestination.CreateUserScreen>{
            CreateUserScreen(
                navController = navController,
            )
        }


        composable<AuthDestination.CreateUserPasswordScreen> {
            CreateUserPassword(navController)
        }

        composable<AuthDestination.CreateUserPincodeScreen> {
            PinScreen(
                navController = navController,
                onPinEntered = { pincode ->
                    navController.navigate(HomeDestination.HomeScreen)

                    //Тут я должен сохранить наш pincode в память телефона
                }
            )
        }


    }

}