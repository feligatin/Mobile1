package com.example.mobile1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun PersonaScreen() {

    //currutines
    
    var timeLeft by remember{
        mutableIntStateOf(10)
    }
    var temporizador by remember { mutableStateOf(10) }
    var temporizadorActivo by remember { mutableStateOf(true) }
    val context = LocalContext.current

    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    val personas = remember { mutableStateListOf<Persona>() }
    LaunchedEffect(key1 = temporizador) {
        if (temporizador > 0) {
            delay(1000)
            temporizador--
        }
    }
    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        Button(
            onClick = {
                if (nombre.isNotBlank() && edad.toIntOrNull() != null) {
                    personas.add(Persona(nombre = nombre, edad = edad.toInt()))
                    nombre = ""
                    edad = ""
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text("Agregar")
        }
        Button(
            onClick = { temporizadorActivo = !temporizadorActivo },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(if (temporizadorActivo) "Pausar" else "Reanudar")
        }
        Button(
            onClick = {
                temporizadorActivo = 10
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Reiniciar Temporizador")
        }
        Text("Tiempo restante: $temporizador")

        personas.forEach { persona ->
            Text(text = "Nombre: ${persona.nombre}, Edad: ${persona.edad}")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    PersonaScreen()
}