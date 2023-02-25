package com.daud.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daud.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAppTheme {
                val count = remember { mutableStateOf(0) }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 60.dp, horizontal = 25.dp)
                            .height(200.dp),
                        shape = RoundedCornerShape(15.dp),
                        backgroundColor = Color.LightGray
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = count.value.toString(),
                                fontSize = 80.sp
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CreateButton(
                            imageVector = Icons.Rounded.Add,
                            buttonText = "Increase",
                            color = Color.Green
                        ) {
                            count.value++
                        }

                        Spacer(modifier = Modifier.padding(12.dp))

                        // minus
                        CreateButton(
                            imageVector = Icons.Rounded.Remove,
                            buttonText = "Decrease",
                            color = Color.Yellow
                        ) {
                            when {
                                count.value > 0 -> count.value--
                                else -> this@MainActivity.showWarning()
                            }
                        }
                    }

                    Spacer(modifier = Modifier.padding(12.dp))

                    CreateButton(
                        imageVector = Icons.Rounded.Refresh,
                        buttonText = "Reset",
                        color = Color.Cyan
                    ) {
                        when {
                            count.value > 0 -> count.value = 0
                            else -> this@MainActivity.showWarning()
                        }
                    }
                }
            }
        }
    }
}