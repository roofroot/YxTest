package com.test.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

/**
 * coco man
 * 2023/4/26
 **/


@Composable
fun SecondPage(list:List<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        for(i in list){
            Text(text = i,
                Modifier
                    .wrapContentWidth()
                    .height(20.dp)
                    .background(Color.White)
                    .clickable {

                    })
        }
    }

}

