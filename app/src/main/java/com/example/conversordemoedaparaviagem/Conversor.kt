package com.example.conversordemoedaparaviagem

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Luggage
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.example.conversordemoedaparaviagem.ui.theme.AmbarMoeda
import com.example.conversordemoedaparaviagem.ui.theme.AzulProfundo

class ConversorViewModel : ViewModel() {
    var valor by mutableStateOf("")
        private set

    fun onValorChange(novo: String) {
        valor = novo
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
                .background(AzulProfundo)
                .padding(16.dp, 32.dp, 16.dp, 0.dp)
        ) {
            Text(
                text = "Conversor".uppercase(),
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = { onTelaInicial() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Voltar",
                    tint = Color.White
                )
            }
        }

        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(vertical = 100.dp, horizontal = 16.dp)
                .weight(1f)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(20.dp)
                )
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Valor:")
            TextField(
                value = valor,
                onValueChange = { viewModel.onValorChange(it) },
                placeholder = { Text("Digite o valor") },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
                )
            )
            Text(
                "Cotação: R$ $dolar".replace(".", ","),
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                            .padding(top = 8.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(6.dp)
                            )
                .padding(horizontal = 8.dp, vertical = 3.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text("Valor convertido:")
            Text(
                text = resultado?.let {
                    "R$ ${String.format(format = "%.2f", it)}"
                } ?: "R$ 0,00", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary
            )
        }

        Box(
            Modifier
                .fillMaxWidth()
                .background(color = AzulProfundo)
                .padding(16.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = {onAbrirViagem()}) {
                    Icon(
                        imageVector = Icons.Filled.Luggage,
                        contentDescription = "Conversor",
                        tint = Color.White
                    )
                }

                IconButton(onClick = {onConversor()}) {
                    Icon(
                        imageVector = Icons.Filled.Calculate,
                        contentDescription = "Conversor",
                        tint = AmbarMoeda
                    )
                }
            }
        }
    }
}