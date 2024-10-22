package com.example.barchart.presentation.githubreposlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barchart.data.githubreposlist.repository.GithubListRepositoryImpl
import com.example.barchart.presentation.githubreposlist.mapper.mapDomainToPresentationReposList
import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
import kotlinx.coroutines.launch


//hilt
class GithubListViewModel : ViewModel() {

    private var _reposList: MutableLiveData<List<GithubListUIModel>> = MutableLiveData()
    val reposList: LiveData<List<GithubListUIModel>> = _reposList

    fun fetchReposList() {
        viewModelScope.launch {
            val result = GithubListRepositoryImpl().fetchReposList()
            //mapping to ui model
            _reposList.value = mapDomainToPresentationReposList(result)

            //to log
            println("panda final result in view model: $reposList")
        }
    }
}
