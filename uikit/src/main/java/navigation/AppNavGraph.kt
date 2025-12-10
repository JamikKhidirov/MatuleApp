package navigation

import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally

import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import navigation.navgraphsnavigation.authNavGraph
import navigation.navgraphsnavigation.homeNavGraph


@Composable
fun AppNavGraph(
    isLogInUser: Boolean,
    navController: NavHostController
){
    var startDestination = when(isLogInUser){
        true -> HomeDestination.getHomeRoom()
        else -> AuthDestination.getStartRoute()
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            slideInHorizontally(
                tween(400),
                initialOffsetX =  {
                    it + 10
                }
            ) + fadeIn(
                animationSpec = tween(
                    400
                )
            )
        },
        exitTransition = {
            slideOutHorizontally(
                tween(400),
                targetOffsetX = {
                    100
                }
            )
        },
    ){
        authNavGraph(navController)
        homeNavGraph(navHostController = navController)
    }
}