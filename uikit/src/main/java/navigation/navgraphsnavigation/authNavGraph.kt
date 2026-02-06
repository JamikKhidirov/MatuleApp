package navigation.navgraphsnavigation

import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.uikit.screens.createuser.CreateUserPassword
import com.example.uikit.screens.createuser.CreateUserScreen
import com.example.uikit.screens.login.LogInScreenScreen
import com.example.uikit.screens.pincode.PinScreen
import navigation.destinations.AuthDestination
import navigation.destinations.HomeDestination
import com.example.uikit.screens.createuser.viewModel.CreateUserViewModel


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
){

    navigation<AuthDestination.AuthRoot>(startDestination = AuthDestination.LoginScreen){

        composable<AuthDestination.LoginScreen> {backStackEntry ->

            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(AuthDestination.AuthRoot)
            }
            val viewModel: CreateUserViewModel = hiltViewModel(parentEntry)

            LogInScreenScreen(
                navController = navController,
            )
        }
        composable<AuthDestination.CreateUserScreen>{backStackEntry ->

            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(AuthDestination.AuthRoot)
            }

            val viewModel: CreateUserViewModel = hiltViewModel(parentEntry)

            CreateUserScreen(
                navController = navController,
                viewModel = viewModel
            )
        }


        composable<AuthDestination.CreateUserPasswordScreen> {backStackEntry ->

            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(AuthDestination.AuthRoot)
            }
            val viewModel: CreateUserViewModel = hiltViewModel(parentEntry)

            CreateUserPassword(
                navController,
                viewModel = viewModel
            )
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