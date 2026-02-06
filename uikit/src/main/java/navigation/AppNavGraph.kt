package navigation



import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uikit.screens.splash.SplashScreen
import navigation.destinations.SplashScreenDestination
import navigation.navgraphsnavigation.authNavGraph
import navigation.navgraphsnavigation.homeNavGraph




@Composable
fun AppNavGraph(
    isLogInUser: Boolean,
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = SplashScreenDestination,
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

        // Сплеш без анимаций
        composable<SplashScreenDestination>(
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            SplashScreen(
                isLogInUser = isLogInUser,
                navController = navController
            )

        }
        authNavGraph(navController)
        homeNavGraph(navHostController = navController)
    }
}