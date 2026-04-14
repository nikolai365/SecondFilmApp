package com.myapp.secondfilm.screens

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.myapp.secondfilm.MainViewModel
import com.myapp.secondfilm.data.models.Movies

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {

    val allMovies = viewModel.allMovies.observeAsState(listOf()).value

    allMovies.forEach { Log.d("checkData", "${it.id} ${it.name}") }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(allMovies.take(10)) {
                item ->
                MovieItem(item)
            }
        }
    }
}

@Composable
fun MovieItem(item: Movies) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "${item.id}")
        Text(item.name)
    }
}