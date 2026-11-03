package com.example.diancai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.diancai.ui.AppViewModel
import com.example.diancai.ui.CartScreen
import com.example.diancai.ui.MenuScreen
import com.example.diancai.ui.OrderSuccessScreen
import com.example.diancai.ui.theme.DianCaiTheme

/** 三个页面，用简单状态切换，避免引入导航库 */
private enum class Screen { Menu, Cart, Success }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DianCaiTheme {
                DianCaiApp()
            }
        }
    }
}

@Composable
private fun DianCaiApp() {
    val viewModel: AppViewModel = viewModel()
    var screen by remember { mutableStateOf(Screen.Menu) }

    when (screen) {
        Screen.Menu -> MenuScreen(
            viewModel = viewModel,
            onOpenCart = { screen = Screen.Cart },
        )

        Screen.Cart -> CartScreen(
            viewModel = viewModel,
            onBack = { screen = Screen.Menu },
            onSubmit = {
                viewModel.submitOrder()
                screen = Screen.Success
            },
        )

        Screen.Success -> OrderSuccessScreen(
            viewModel = viewModel,
            onBackToMenu = { screen = Screen.Menu },
        )
    }
}
