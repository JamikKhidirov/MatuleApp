package navigation

import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
        startDestination = Destination.AuthGraph,
        enterTransition = {
            slideInHorizontally(tween(300))
        },
        exitTransition = {
            slideOutHorizontally(tween(300))
        },
    ){
        authNavGraph(navController)
        homeNavGraph(navHostController = navController)
    }
}