package com.example.composablefunctions

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composablefunctions.ui.theme.ComposableFunctionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableFunctionsTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(Message("Android","When the sun goes down!"))
                }
            }
        }
    }
}

//To make a function composable, add the @Composable annotation
data class Message(val name: String, val body: String)

@Composable
fun Greeting(msg:Message, modifier: Modifier = Modifier) {


    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )


//    Add a horizontal space
        Spacer(modifier = Modifier.padding(24.dp))
//    You can use Row to arrange items horizontally and Box to stack elements.
        Column {
            Text(
                text = msg.name,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

//        First, wrap the message body text around a Surface composable. Doing so allows customizing the message body's shape and elevation. Padding is also added to the message for a better layout.
            Spacer(modifier = Modifier.width(8.dp))
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}




//The @Preview annotation lets you preview your composable functions within Android Studio without having to build and install the app to an Android device or emulator
@Preview(name = "Light Mode")
//adding dark mode
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode")
@Composable
fun GreetingPreview() {
    ComposableFunctionsTheme {
        Surface {
            Greeting(Message("Android","When the sun goes down!"))
        }

    }
}