package ie.stu.composewindowcaptureissue

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() {
    System.setProperty("skiko.renderApi", "OPENGL")
    postMain()
}

fun postMain() = application {
    val windowState = rememberWindowState(
        width = 800.dp,
        height = 600.dp,
        position = WindowPosition(0.dp, 0.dp)
    )

    Window(
        onCloseRequest = {
            exitApplication()
        },
        title = "Main Window",
        state = windowState
    ) {
        MaterialTheme {
            Text(text = "This is the main window")
        }
    }
    Overlay()
}

@Composable
fun Overlay() {
    var isVisible by remember { mutableStateOf(true) }
    val windowState = rememberWindowState(
        width = 1024.dp,
        height = 768.dp,
        position = WindowPosition(100.dp, 100.dp)
    )

    Window(
        title = "Secondary Window",
        onCloseRequest = { isVisible = false },
        state = windowState,
        undecorated = true,
        transparent = true,
        visible = isVisible,
        focusable = false,
    ) {
        WindowDraggableArea {
            MaterialTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF00FF00))
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize().focusable(false)
                    ) {
                        Text(text = "Here is some text")
                        Button(onClick = {}) {
                            Text(text = "Here is a button")
                        }
                    }
                }
            }
        }
    }
}