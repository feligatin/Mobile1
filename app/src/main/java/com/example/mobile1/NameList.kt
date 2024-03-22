import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NameList() {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var name by remember { mutableStateOf("") }
    var names by remember { mutableStateOf(mutableListOf<String>()) }

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                if (name.isNotEmpty()) {
                    names = mutableListOf(name).apply { addAll(names) }
                    name = ""
                } else {
                    Toast.makeText(context, "Please enter a valid name", Toast.LENGTH_SHORT).show()
                }
                focusManager.clearFocus()
            }),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (name.isNotEmpty()) {
                    names = mutableListOf(name).apply { addAll(names) }
                    name = ""
                } else {
                    Toast.makeText(context, "Please enter a valid name", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            Text(text = "Add", modifier = Modifier.padding(start = 4.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedContent(
            targetState = names,
            transitionSpec = {
                fadeIn(animationSpec = tween(500)) with
                        fadeOut(animationSpec = tween(500)) using
                        SizeTransform(clip = false)
            }
        ) { targetNames ->
            Column {
                targetNames.forEach { currentName ->
                    Text(currentName)
                    Divider()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    NameList()
}
