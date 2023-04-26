package com.test.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.test.compose.ui.theme.bgColor

/**
 * coco man
 * 2023/4/26
 **/


@Composable
fun FristPage(list: ArrayList<String>) {
    var content = remember { mutableStateOf<String?>(null) }
    var content2 = remember { mutableStateOf<String?>(null) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
    ) {
        InputView("amount:", content)
        InputView("time:", content2)
        BoxWithConstraints(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            Box(
                Modifier
                    .background(Color.Green, shape = RoundedCornerShape(10.dp))
                    .align(Alignment.Center)
            ) {
                Text(text = "submit",
                    Modifier
                        .padding(10.dp).wrapContentSize()
                        .align(Alignment.Center)
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

    }

}

@Composable
fun InputView(prev: String, content: MutableState<String?>) {

    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Text(text = "${prev}${content?.value?:""}",
            Modifier
                .wrapContentWidth()
                .height(20.dp)
                .clickable {

                })
        Box(Modifier.padding(10.dp)) {
            TextField(
                value = content?.value?:"",
                textStyle = TextStyle(color = Color.Black),
                onValueChange = { it ->
                    if (it.matches(Regex("[0-9]*\\.?[0-9]*"))) {
                        content?.value = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .wrapContentHeight()
                    .padding(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    focusedIndicatorColor = MaterialTheme.colors.primary,
                    unfocusedIndicatorColor = MaterialTheme.colors.onSurface
                ),
                label = { "Enter a number" }
            )
        }


    }
}
