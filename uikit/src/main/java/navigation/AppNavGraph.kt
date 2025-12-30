package navigation



import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
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
                    it
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
                    -it
                }
            ) + fadeOut(
                animationSpec = tween(400)
            )
        },

        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth }, // начинается слева за экраном
                animationSpec = tween(400)
            ) + fadeIn(animationSpec = tween(400))
        },

        popExitTransition = {
            // Закрытие текущего экрана при возврате
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth }, // уходит вправо
                animationSpec = tween(400)
            ) + fadeOut(animationSpec = tween(400))
        }

    ){
        authNavGraph(navController)
        homeNavGraph(navHostController = navController)
    }
}