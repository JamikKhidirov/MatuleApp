package navigation.navgraphsnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.uikit.screens.CreateUserPassword
import com.example.uikit.screens.CreateUserScreen
import com.example.uikit.screens.LogInScreenScreen
import com.example.uikit.screens.PinScreen
import navigation.Destination



fun NavGraphBuilder. authNavGraph(
    navController: NavHostController,
){

    navigation<Destination.AuthGraph>(startDestination = Destination.LogInScreen){
        composable<Destination.LogInScreen> {
            LogInScreenScreen(
                navController = navController
            )
        }
        composable<Destination.CreateUserScreen>{
            CreateUserScreen(
                navController = navController,
            )
        }


        composable<Destination.CreateUserPassword> {
            CreateUserPassword(navController)
        }

        composable<Destination.CreatePincodeScreen> {
            PinScreen(navController)
        }


    }

}