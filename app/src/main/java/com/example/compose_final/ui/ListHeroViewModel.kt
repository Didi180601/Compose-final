package com.example.compose_final.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.compose_final.data.ListRepository
import com.example.compose_final.model.ListHero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListHeroViewModel(
    private val repository: ListRepository
) : ViewModel() {
    private val _groupedListHero = MutableStateFlow(
        repository.getListHero()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
    val groupedListHero: StateFlow<Map<Char, List<ListHero>>> get() = _groupedListHero

    private val _query = mutableStateOf("")
    val query: State<String>
        get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedListHero.value = repository.searcListHero(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }

    private val _detailHero = MutableStateFlow<ListHero?>(null)
    val detailHero: StateFlow<ListHero?> get() = _detailHero
    fun searchById(idQuery: String) {
        _detailHero.value = repository.getHeroById(idQuery)
    }
}

class ViewModelFactory(
    private val repository: ListRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListHeroViewModel::class.java)) {
            return ListHeroViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown ViemModel Class:" + modelClass.name)
    }
}