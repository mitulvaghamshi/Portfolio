package me.mitul.portfolio.android.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.mitul.portfolio.github.GitHubRepo
import me.mitul.portfolio.github.GitHubSdk

internal class RepoModel(private val sdk: GitHubSdk) : ViewModel() {
    private var _repos by mutableStateOf<List<GitHubRepo>>(value = listOf())
    private val _loading = MutableLiveData(true)

    val repos: List<GitHubRepo>
        get() = _repos

    val loading: MutableLiveData<Boolean>
        get() = _loading

    fun loadRepos(useCache: Boolean = true) {
        if (useCache && _repos.isNotEmpty()) return
        viewModelScope.launch {
            _loading.value = true
            _repos = sdk.getRepos(limit = 50, cached = useCache)
            _loading.value = false
        }
    }
}
