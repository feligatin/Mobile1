package com.example.mobile1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PersonaScreen() {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    val personas = remember { mutableStateListOf<Persona>() }

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
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        )
        Button(
            onClick = {
                if (nombre.isNotBlank() && edad.toIntOrNull() != null) {
                    personas.add(Persona(nombre = nombre, edad = edad.toInt()))
                    nombre = ""
                    edad = ""
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Agregar")
        }

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