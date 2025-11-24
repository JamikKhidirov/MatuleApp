package navigation.navgraphsnavigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.uikit.screens.HomeScreen
import navigation.Destination



fun NavGraphBuilder.homeNavGraph(
    navHostController: NavHostController
){

    navigation<Destination.Home>(startDestination = Destination.HomeScreen){
        composable<Destination.HomeScreen>{
            HomeScreen()
        }
    }
}

