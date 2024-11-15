package com.example.barchart.presentation.githubreposlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barchart.domain.githubreposlist.repository.GithubListRepository
import com.example.barchart.presentation.githubreposlist.mapper.mapDomainToPresentationReposList
import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GithubListViewModel @Inject constructor(
    val githubListRepository: GithubListRepository
) : ViewModel() {

    private var _reposList: MutableLiveData<List<GithubListUIModel>> = MutableLiveData()
    val reposList: LiveData<List<GithubListUIModel>> = _reposList

    fun fetchReposList() {
        viewModelScope.launch {
            val result = githubListRepository.fetchReposList()
            //mapping to ui model
            _reposList.value = mapDomainToPresentationReposList(result)

            //to log
            println("final result in view model: $reposList")
        }
    }
}
