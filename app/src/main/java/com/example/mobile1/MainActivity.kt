package com.example.mobile1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile1.ui.theme.Mobile1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .background(Color.Magenta)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray.copy(alpha = 0.5f))
        ) {
            Text(
                text = "Bienvenido $name!",
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Hola, $name!",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(8.dp)
            )
            Text(
                text = "Otro texto",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .background(Color.Green)
                    .padding(8.dp)
            )
        }

        Text(
            text = "Adiós, $name!",
            color = Color.White,
            fontSize = 40.sp,
            modifier = Modifier
                .background(Color.Red) // Fondo rojo para este texto, haciéndolo destacar
                .padding(16.dp) // Mayor padding para más espacio alrededor del texto
        )

        Text(
            text = "Más texto",
            color = Color.White,
            fontSize = 40.sp,
            modifier = Modifier
                .background(Color.Cyan)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Mobile1Theme {
        Greeting("Feli")
    }
}