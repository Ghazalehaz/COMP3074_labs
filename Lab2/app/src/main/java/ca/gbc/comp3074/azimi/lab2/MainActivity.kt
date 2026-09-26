package ca.gbc.comp3074.azimi.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.gbc.comp3074.azimi.lab2.ui.theme.Lab2Theme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Lab2Theme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    CounterApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun CounterApp(modifier: Modifier = Modifier) {

    // Counter starts at 0
    var counter by remember {
        mutableIntStateOf(0)
    }

    // Default step is 1
    var step by remember {
        mutableIntStateOf(1)
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD))
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // App Logo
        Image(
            painter = painterResource(
                id = R.drawable.logo
            ),
            contentDescription = "Application Logo",
            modifier = Modifier.size(180.dp)
        )


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        // Output Label
        Text(
            text = counter.toString(),
            fontSize = 40.sp
        )


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        // Subtract and Add Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.spacedBy(
                20.dp,
                Alignment.CenterHorizontally
            )
        ) {

            // Subtract Button
            Button(
                onClick = {
                    counter -= step
                },

                modifier = Modifier.size(
                    width = 120.dp,
                    height = 60.dp
                ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3F51B5)
                )
            ) {

                Text(
                    text = "-",
                    fontSize = 24.sp
                )
            }


            // Add Button
            Button(
                onClick = {
                    counter += step
                },

                modifier = Modifier.size(
                    width = 120.dp,
                    height = 60.dp
                ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3F51B5)
                )
            ) {

                Text(
                    text = "+",
                    fontSize = 24.sp
                )
            }
        }


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        // Reset and Step Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.spacedBy(
                20.dp,
                Alignment.CenterHorizontally
            )
        ) {

            // Reset Button
            Button(
                onClick = {
                    counter = 0
                    step = 1
                },

                modifier = Modifier.size(
                    width = 120.dp,
                    height = 60.dp
                ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE91E63)
                )
            ) {

                Text(
                    text = "Reset",
                    fontSize = 16.sp
                )
            }


            // Step Button
            Button(
                onClick = {
                    step = 2
                },

                modifier = Modifier.size(
                    width = 120.dp,
                    height = 60.dp
                ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                )
            ) {

                Text(
                    text = "Step",
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CounterPreview() {

    Lab2Theme {
        CounterApp()
    }
}