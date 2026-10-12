package com.example.conversordemoedaparaviagem

import android.R
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Luggage
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.conversordemoedaparaviagem.ui.theme.AmbarMoeda
import com.example.conversordemoedaparaviagem.ui.theme.AzulProfundo

@Composable
fun Local(modifier: Modifier = Modifier, onAbrirViagem: () -> Unit, onConversorUniversal: () -> Unit, onTelaInicial: () -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .background(color = AzulProfundo)
                .padding(16.dp). padding(top = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Conversor de Viagem".uppercase(), fontWeight = FontWeight.Bold, color = Color.White)
        }
        Spacer(Modifier.height(32.dp))

        Column(
            Modifier
                .padding(start = 16.dp, end = 16.dp)
                .weight(1f)
        ) {
            Text("Viagens:", fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(12.dp)
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
                            color = MaterialTheme.colorScheme.primary
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
                Text("Adicionar viagem")
            }
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
                        tint = AmbarMoeda
                    )
                }

                IconButton(onClick = {onConversorUniversal()}){
                    Icon(
                        imageVector = Icons.Filled.Calculate,
                        contentDescription = "Conversor",
                        tint = Color.White
                    )
                }
            }
        }
    }

}