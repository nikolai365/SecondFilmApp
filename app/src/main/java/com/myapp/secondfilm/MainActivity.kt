package com.myapp.secondfilm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.myapp.secondfilm.ui.theme.SecondFilmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SecondFilmTheme {
                AppNavigation()
            }
        }
    }
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToDetail = { navController.navigate("detail") }
            )
        }
        composable("detail") {
            DetailScreen()
        }
    }
}


@Composable
fun HomeScreen(
    onNavigateToDetail: () -> Unit,
    viewModel: MainViewModel = viewModel()
) {
    val text by viewModel.text.collectAsState()
    Column {
        Text(text = text)
        Button(onClick = { viewModel.updateText("Updated in Home!") }) {
            Text("Update Text")
        }
        Button(onClick = onNavigateToDetail) {
            Text("Go to Detail")
        }
    }
}


@Composable
fun DetailScreen(
    viewModel: MainViewModel = viewModel()
) {
    val text by viewModel.text.collectAsState()
    Column {
        Text(text = "Detail Screen")
        Text(text = "Current text: $text")
    }
}
