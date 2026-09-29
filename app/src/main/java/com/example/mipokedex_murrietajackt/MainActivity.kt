package com.example.mipokedex_murrietajackt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyPokedexTheme {
                PokedexScreen()
            }
        }
    }
}

object PokedexColors {
    val AmarilloFondo = Color(0xFFECD235)  // #ecd235
    val Rojo = Color(0xFFCE221A)           // #ce221a
    val Texto = Color(0xFF48474D)          // #48474d
    val Blanco = Color.White
    val BordePanel = Color(0xFFD0D0D0)
}

// drawable infoPanel
object PokedexShapes {
    // bg_tipo.xml
    val TipoShape = RoundedCornerShape(50.dp)

    // bg_info_panel.xml
    val InfoPanelShape = RoundedCornerShape(
        topStart = 35.dp,
        topEnd = 35.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )
}

@Composable
fun PokedexScreen() {
    var isFavorite by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PokedexColors.AmarilloFondo)
    ) {
        // Pokeball de fondo (como en el XML)
        Image(
            painter = painterResource(id = R.drawable.pokeball_background),
            contentDescription = null,
            modifier = Modifier
                .size(221.dp, 228.dp)
                .align(Alignment.TopEnd)
                .padding(top = 150.dp, end = 16.dp)
                .rotate(30f),
            contentScale = ContentScale.Fit
        )

        IconButton(
            onClick = { isFavorite = !isFavorite },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 16.dp, end = 16.dp)
                .size(48.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.star_icon),
                contentDescription = stringResource(R.string.app_name),
                tint = if (isFavorite) Color.Yellow else Color.Gray,
                modifier = Modifier.size(32.dp)
            )
        }

        Column(modifier = Modifier.fillMaxSize()) {
            // Header: Nombre y número
            Column(modifier = Modifier.padding(start = 32.dp, top = 80.dp)) {
                Text(
                    text = stringResource(R.string.nombre_pokemon),
                    color = PokedexColors.Blanco,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = stringResource(R.string.num_pokemon),
                    color = PokedexColors.Texto,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 48.dp, top = 8.dp)
                )
            }

            // Imagen pikachu
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pikachu),
                    contentDescription = stringResource(R.string.nombre_pokemon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height((-15).dp))

            InfoPanel(modifier = Modifier.weight(0.6f))
        }
    }
}

@Composable
fun InfoPanel(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        shape = PokedexShapes.InfoPanelShape,
        color = Color.White,
        shadowElevation = 4.dp,
        border = androidx.compose.foundation.BorderStroke(1.dp, PokedexColors.BordePanel)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = stringResource(R.string.tipo),
                color = PokedexColors.Texto,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(
                        color = PokedexColors.AmarilloFondo,
                        shape = PokedexShapes.TipoShape
                    )
                    .padding(horizontal = 18.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Características
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Columna izquierda
                Column {
                    // Altura
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Altura",
                            color = PokedexColors.Rojo,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(
                            text = stringResource(R.string.altura),
                            color = PokedexColors.Texto,
                            fontSize = 20.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))


                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Peso",
                            color = PokedexColors.Rojo,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(24.dp))
                        Text(
                            text = stringResource(R.string.peso),
                            color = PokedexColors.Texto,
                            fontSize = 20.sp
                        )
                    }
                }

                //  Habilidad
                Column(horizontalAlignment = Alignment.Start) {
                    Text(
                        text = "Habilidad",
                        color = PokedexColors.Rojo,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = stringResource(R.string.habilidad),
                        color = PokedexColors.Texto,
                        fontSize = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Descripcion
            Text(
                text = stringResource(R.string.descripcion),
                color = PokedexColors.Texto,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Pokemon anterior y siguiente
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Pokemon anterior Arbok
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.arbok),
                        contentDescription = "Arbok",
                        modifier = Modifier.size(91.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.pokemon_anterior),
                        color = PokedexColors.Texto,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }

                // Pokemon siguiente Raichu
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.raichu),
                        contentDescription = "Raichu",
                        modifier = Modifier.size(91.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.pokemon_sig),
                        color = PokedexColors.Texto,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

// TEMA
@Composable
fun MyPokedexTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = PokedexColors.Rojo,
            background = PokedexColors.AmarilloFondo,
            surface = Color.White
        ),
        content = content
    )
}

// PREVIEW
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PokedexScreenPreview() {
    MyPokedexTheme {
        PokedexScreen()
    }
}