package com.example.barchart.presentation.githubreposlist.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.barchart.presentation.githubreposlist.view.navigation.AppNavigator
import com.example.barchart.presentation.githubreposlist.viewmodel.GithubListViewModel
import com.example.barchart.presentation.widget.theme.BarChartTheme
import dagger.hilt.android.AndroidEntryPoint

//hilt
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: GithubListViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            BarChartTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    AppNavigator()
                }
            }
        }
    }
}



