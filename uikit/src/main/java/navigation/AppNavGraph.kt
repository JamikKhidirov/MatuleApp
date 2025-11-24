package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import navigation.navgraphsnavigation.authNavGraph
import navigation.navgraphsnavigation.homeNavGraph


@Composable
fun AppNavGraph(
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Destination.AuthGraph
    ){
        authNavGraph(navController)
        homeNavGraph(navHostController = navController)
    }
}