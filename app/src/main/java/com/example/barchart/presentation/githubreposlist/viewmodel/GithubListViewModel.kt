package com.example.barchart.presentation.githubreposlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barchart.domain.githubreposlist.repository.GithubListRepository
import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


//hilt
@HiltViewModel
class GithubListViewModel @Inject constructor(
    val githubListRepository: GithubListRepository
) : ViewModel() {

    //hot flow
    internal var uiState: MutableStateFlow<List<GithubListUIModel>> = MutableStateFlow(emptyList())

    fun fetchReposList() =
        viewModelScope.launch {
            githubListRepository.fetchReposList().collectLatest { println("final result in view model: ${it}") }
        }
}

data class HomeUiState(val data: List<GithubListUIModel>)
