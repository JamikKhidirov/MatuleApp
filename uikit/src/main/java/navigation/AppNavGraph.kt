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
                tween(800),
                initialOffsetX =  {
                    it
                }
            ) + fadeIn(
                animationSpec = tween(
                    800
                )
            )
        },
        exitTransition = {
            slideOutHorizontally(
                tween(800),
                targetOffsetX = {
                    -it
                }
            ) + fadeOut(
                animationSpec = tween(800)
            )
        },

        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth }, // начинается слева за экраном
                animationSpec = tween(800)
            ) + fadeIn(animationSpec = tween(800))
        },

        popExitTransition = {
            // Закрытие текущего экрана при возврате
            slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth }, // уходит вправо
                animationSpec = tween(800)
            ) + fadeOut(animationSpec = tween(800))
        }

    ){
        authNavGraph(navController)
        homeNavGraph(navHostController = navController)
    }
}