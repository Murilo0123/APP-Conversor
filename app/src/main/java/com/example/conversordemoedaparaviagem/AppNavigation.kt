package com.example.conversordemoedaparaviagem

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "local"
    ) {
        composable("local") {
            Local(
                onAbrirViagem = { navController.irPara("viagem") },
                onConversorUniversal = { navController.irPara("conversorUniversal") },
                onTelaInicial = { navController.popBackStack("local", inclusive = false) }
            )
        }

        composable("viagem") {
            Viagem(
                onTelaInicial = { navController.popBackStack("local", inclusive = false) },
                onConversor = { navController.irPara("conversor") },
                onAbrirViagem = { navController.irPara("viagem") }
            )
        }

        composable("conversor") {
            Conversor(
                onTelaInicial = { navController.popBackStack("local", inclusive = false) },
                onAbrirViagem = { navController.irPara("viagem") },
                onConversor = { navController.irPara("conversor") }
            )
        }

        composable("conversorUniversal") {
            ConversorUniversal(
                onTelaInicial = { navController.popBackStack("local", inclusive = false) },
                onConversorUniversal = { navController.irPara("conversorUniversal") }
            )
        }
    }
}
fun NavController.irPara(rota: String) = navigate(rota) {
    popUpTo("local") {saveState = true}
    launchSingleTop = true
    restoreState = true
}
