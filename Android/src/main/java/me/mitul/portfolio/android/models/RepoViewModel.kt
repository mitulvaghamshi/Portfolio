package me.mitul.portfolio.android.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.mitul.portfolio.github.GitHubRepo
import me.mitul.portfolio.github.GitHubSdk

internal class RepoViewModel(val sdk: GitHubSdk) : ViewModel() {
    private var _repos by mutableStateOf<List<GitHubRepo>>(listOf())
    private val _loading = MutableLiveData(true)

    val repos get() = _repos

    val loading get() = _loading

    fun loadRepos(useCache: Boolean = true) {
        if (useCache && _repos.isNotEmpty()) return
        viewModelScope.launch { getRepos(useCache = useCache) }
    }

    private suspend fun getRepos(useCache: Boolean = true) {
        this._loading.value = true
        _repos = try {
            sdk.getRepos(limit = 50, cached = useCache)
        } catch (e: Exception) {
            throw Exception(e.localizedMessage)
        }
        this._loading.value = false
    }
}
