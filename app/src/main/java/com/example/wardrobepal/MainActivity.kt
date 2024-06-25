package com.example.wardrobepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wardrobepal.ui.theme.WardrobePalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WardrobePalTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainActivityContent()
                }
            }
        }
    }
}

@Composable
fun MainActivityContent() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Greeting(name = "Praveen")
        RedButton(
            onClick = { /* Do something when button is clicked */ },
            backgroundColor = MaterialTheme.colors.error,
            contentColor = MaterialTheme.colors.onError,
            buttonText = "Click me"
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun RedButton(
    onClick: () -> Unit,
    backgroundColor: Color,
    contentColor: Color,
    buttonText: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor
    ) {
        Text(text = buttonText)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WardrobePalTheme {
        Greeting("Praveen")
    }
}

@Preview(showBackground = true)
@Composable
fun RedButtonPreview() {
    WardrobePalTheme {
        RedButton(
            onClick = { /* Dummy click action */ },
            backgroundColor = MaterialTheme.colors.error,
            contentColor = MaterialTheme.colors.onError,
            buttonText = "Click me"
        )
    }
}
