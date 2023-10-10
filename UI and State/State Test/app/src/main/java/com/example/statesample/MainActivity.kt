package com.example.statesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statesample.ui.theme.StateSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  HelloScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
//statehoisting
@Composable
fun HelloScreen(){
    var name by remember {
        mutableStateOf("")
    }

    HelloContent(name = name, onNameChange = { name = it } )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloContent(name:String, onNameChange:(String) -> Unit){


    Column (modifier = Modifier.padding(16.dp)) {


        if(name.isNotEmpty()) {
            Text(
                text = "Hello $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.headlineMedium

            )
        }

        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HelloContentPreview() {
    StateSampleTheme {
       HelloScreen()
    }
}