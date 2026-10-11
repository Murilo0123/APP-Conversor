package com.example.conversordemoedaparaviagem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Luggage
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.conversordemoedaparaviagem.ui.theme.ConversorDeMoedaParaViagemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConversorDeMoedaParaViagemTheme {
                AppNavigation()
            }
        }
    }
}

class ConversorViewModel : ViewModel() {
    var valor by mutableStateOf("")
        private set

    fun onValorChange(novo: String) {
        valor = novo
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "local"
    ) {
        composable("local") {
            Local(
                onAbrirViagem = { navController.irPara("viagem") }
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
    }
}
fun NavController.irPara(rota: String) = navigate(rota) {
    popUpTo("local") {saveState = true}
    launchSingleTop = true
    restoreState = true
}

@Composable
fun Local(modifier: Modifier = Modifier, onAbrirViagem: () -> Unit) {
    Column(
        Modifier.fillMaxSize()
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .padding(16.dp). padding(top = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Conversor de Viagem".uppercase())
        }
        Spacer(Modifier.height(32.dp))

        Column(
            Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Text("Viagens:", fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = Color.White
                    )
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "USD".uppercase(),
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Estados Unidos".uppercase(),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    IconButton(
                        onClick = { onAbrirViagem()}
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Voltar"
                        )
                    }
                }
            }
        }
    }

}


@Composable
fun Viagem(modifier: Modifier = Modifier, onTelaInicial: () -> Unit, onConversor: () -> Unit, onAbrirViagem: () -> Unit) {
    val gastos = listOf(
        "Almoço" to "R$ 85,00",
        "Transporte" to "R$ 32,00",
        "Hotel" to "R$ 250,00",
        "Passeio" to "R$ 120,00",
        "Jantar" to "R$ 65,00"
    )

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(16.dp, 32.dp, 16.dp, 0.dp)
        ) {
            Text(
                text = "Gastos da Viagem".uppercase(),
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center
            )

            IconButton(
                onClick = { onTelaInicial() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Voltar"
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Total gasto em Real:")
            Text(
                "R$ 552,00",
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(gastos) { gasto ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = gasto.first,
                            fontWeight = FontWeight.Bold
                        )

                        Text(text = gasto.second)
                    }
                }
            }
        }

        Box(
            Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .padding(16.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = {onAbrirViagem()}) {
                    Icon(
                        imageVector = Icons.Filled.Luggage,
                        contentDescription = "Conversor"
                    )
                    Text("Viagem")
                }

                Button(onClick = {onConversor()}) {
                    Icon(
                        imageVector = Icons.Filled.Calculate,
                        contentDescription = "Conversor"
                    )
                    Text("Conversor")
                }
            }
        }
    }
}

@Composable
fun Conversor(modifier: Modifier = Modifier, onAbrirViagem: () -> Unit, onTelaInicial: () -> Unit, onConversor: () -> Unit, viewModel: ConversorViewModel = viewModel()){
    var valor = viewModel.valor
    val dolar = 4.99

    val valorFinal = valor.replace(",",".").toDoubleOrNull()
    val resultado = valorFinal?.times(dolar)

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(16.dp, 32.dp, 16.dp, 0.dp)
        ) {
            Text(
                text = "Conversor".uppercase(),
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center
            )

            IconButton(
                onClick = { onTelaInicial() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Voltar"
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(bottom = 404.dp)
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Valor:")
            TextField(
                value = valor,
                onValueChange = { viewModel.onValorChange(it) },
                placeholder = { Text("Digite o valor em dólar") },
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text("Valor convertido:")
            Text(
                text = resultado?.let {
                "Valor em reais: R$ ${String.format(format = "%.2f", it)}"
            } ?: "R$ 0,00", fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
        }

        Box(
            Modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .padding(16.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = {onAbrirViagem()}) {
                    Icon(
                        imageVector = Icons.Filled.Luggage,
                        contentDescription = "Conversor"
                    )
                    Text("Viagem")
                }

                Button(onClick = {onConversor()}) {
                    Icon(
                        imageVector = Icons.Filled.Calculate,
                        contentDescription = "Conversor"
                    )
                    Text("Conversor")
                }
            }
        }
    }
}