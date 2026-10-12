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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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

class ConversorUniversalViewModel : ViewModel() {
    var valorUniversal by mutableStateOf("")
        private set

    fun onValorChange(novo: String) {
        valorUniversal = novo
    }
}
@Composable
fun ConversorUniversal(modifier: Modifier = Modifier, onTelaInicial: () -> Unit, onConversorUniversal: () -> Unit, viewModel: ConversorUniversalViewModel = viewModel()){
    var valorUniversal = viewModel.valorUniversal
    val dolar = 4.99

    val valorFinal = valorUniversal.replace(",",".").toDoubleOrNull()
    val resultado = valorFinal?.times(dolar)

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = AzulProfundo)
                .padding(16.dp). padding(top = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Conversor Universal".uppercase(),
                color = Color.White,
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
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
            //adicionar lista de moedas cadastradas
            Text("Moeda:")
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(1) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colorScheme.primaryContainer,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.primary,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(
                                horizontal = 10.dp,
                                vertical = 4.dp
                            )
                    ) {
                        Text(
                            "USD",
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            Text("Valor:")
            TextField(
                value = valorUniversal,
                onValueChange = { viewModel.onValorChange(it) },
                placeholder = { Text("Digite o valor") },
                shape = RoundedCornerShape(12.dp)
            )
            Text("Cotação: R$ $dolar".replace(".",","), fontSize = 12.sp)
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
                IconButton(onClick = {onTelaInicial()}) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home",
                        tint = Color.White
                    )
                }

                IconButton(onClick = {onConversorUniversal()}){
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