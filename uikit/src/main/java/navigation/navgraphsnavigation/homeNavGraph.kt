package navigation.navgraphsnavigation


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.uikit.screens.home.HomeScreen
import navigation.HomeDestination


fun NavGraphBuilder.homeNavGraph(
    navHostController: NavHostController
){

    navigation<HomeDestination.HomeRoot>(startDestination = HomeDestination.HomeScreen){
        composable<HomeDestination.HomeScreen>{
            HomeScreen()
        }

        composable<HomeDestination.BascketScreen>{

            //Экран BacketScreen для корзины
        }

    }
}

