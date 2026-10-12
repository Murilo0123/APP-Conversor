package com.example.conversordemoedaparaviagem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Luggage
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(12.dp))
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Adicionar viagem"
                )
                Text("Adicionar gasto")
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
                IconButton(onClick = {onAbrirViagem()}) {
                    Icon(
                        imageVector = Icons.Filled.Luggage,
                        contentDescription = "Conversor"
                    )
                }

                IconButton(onClick = {onConversor()}) {
                    Icon(
                        imageVector = Icons.Filled.Calculate,
                        contentDescription = "Conversor"
                    )
                }
            }
        }
    }
}
