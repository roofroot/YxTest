package com.test.compose

import android.os.Bundle
import android.security.identity.NoAuthenticationKeyAvailableException
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.compose.ui.theme.ComposetestTheme

class MainActivity : ComponentActivity() {
    companion object {
        var navigation: Navigation = Navigation()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigation.changeCurrentPage(PageName.FIRSTPAGE)
        setContent {
            ComposetestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val data = ArrayList<String>()
                    when (navigation.currentPage.value) {
                        PageName.FIRSTPAGE -> {
                            FristPage(data)
                        }
                        PageName.SECONDPAGE -> {
                            SecondPage(list = data)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposetestTheme {
        Greeting("Android")
    }
}