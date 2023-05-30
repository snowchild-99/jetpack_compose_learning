package com.snowchild.jetpackcomposelearning

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.util.Random

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val color = remember{
                mutableStateOf(Color.Cyan)
            }
            Column (modifier = Modifier
                .fillMaxSize()){
                ColorBox(Modifier.weight(0.5f).fillMaxSize()){
                    color.value = it
                }
                Box(modifier = Modifier
                    .weight(0.5f)
                    .fillMaxSize(1f)
                    .background(color = color.value))
            }

        }
    }


        @Composable
        fun ColorBox(modifier: Modifier = Modifier,
        updateColor : (Color) -> Unit) {
            Box(modifier = modifier
                .background(Color.Red)
                .clickable {
                    updateColor(Color(
                        kotlin.random.Random.nextInt(),
                    )
                    )
                }

            )
        }
    }
