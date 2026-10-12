package com.example.conversordemoedaparaviagem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = AzulOceanoClaro,
    onPrimary = Color(0xFF003544),
    primaryContainer = AzulProfundo,
    onPrimaryContainer = AzulNevoa,
    secondary = AmbarSuave,
    onSecondary = Color(0xFF3D2600),
    secondaryContainer = AmbarEscuro,
    onSecondaryContainer = AmbarClaro,
    tertiary = VerdeSuave,
    onTertiary = Color(0xFF00391F),
    background = FundoEscuro,
    onBackground = TextoClaro,
    surface = SuperficieEscura,
    onSurface = TextoClaro,
    surfaceVariant = SuperficieEscuraVariante,
    onSurfaceVariant = TextoClaroSecundario,
    surfaceContainerHighest = SuperficieEscuraVariante,
    outline = ContornoEscuro,
    outlineVariant = ContornoEscuro,
    error = ErroClaro,
    onError = Color(0xFF4A0A0A)
)

private val LightColorScheme = lightColorScheme(
    primary = AzulOceano,
    onPrimary = Color.White,
    primaryContainer = AzulNevoa,
    onPrimaryContainer = AzulProfundo,
    secondary = AmbarMoeda,
    onSecondary = Color(0xFF3D2600),
    secondaryContainer = AmbarClaro,
    onSecondaryContainer = AmbarEscuro,
    tertiary = VerdeCambio,
    onTertiary = Color.White,
    background = Fundo,
    onBackground = TextoPrincipal,
    surface = Superficie,
    onSurface = TextoPrincipal,
    surfaceVariant = AzulNevoa,
    onSurfaceVariant = TextoSecundario,
    surfaceContainerHighest = AzulNevoa,
    outline = Contorno,
    outlineVariant = Contorno,
    error = Erro,
    onError = Color.White
)

@Composable
fun ConversorDeMoedaParaViagemTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}