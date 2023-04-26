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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

/**
 * coco man
 * 2023/4/26
 **/


@Composable
fun FristPage(list: ArrayList<String>) {
    var content = remember { mutableStateOf("") }
    var content2 = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        InputView("amount:", content)
        InputView("time:", content2)
        Text(text = "submit",
            Modifier
                .wrapContentWidth()
                .height(20.dp)
                .background(Color.Blue)
                .clickable {
                    content?.value?.let { num1 ->
                        content2?.value?.let { num2 ->
                            val result = num1.toInt() * num2.toInt()
                            list.add("result:${result}")
                            MainActivity.navigation.changeCurrentPage(PageName.SECONDPAGE)
                        }
                    }
                })
    }

}

@Composable
fun InputView(prev: String, content: MutableState<String>) {

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Text(text = "${prev}${content.value}",
            Modifier
                .wrapContentWidth()
                .height(20.dp)
                .background(Color.White)
                .clickable {

                })
        TextField(
            value = content.value,
            textStyle = TextStyle(color = Color.Black),
            onValueChange = { it ->
                if (it.matches(Regex("[0-9]*\\.?[0-9]*"))) {
                    content.value = it
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White),
            label = { "Enter a number" }
        )

    }
}
