package com.example.myarsitektur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.myarsitektur.ui.theme.MyArsitekturTheme
import com.example.myarsitektur.view.uicontroller.SiswaApp
import com.example.myarsitektur.viewmodel.SiswaViewModel

class MainActivity : ComponentActivity() {

    private val siswaViewModel: SiswaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArsitekturTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen(siswaViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    viewModel: SiswaViewModel
) {
    val navController = rememberNavController()

    SiswaApp(
        navController = navController,
        viewModel = viewModel
    )
}