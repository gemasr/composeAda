package com.gemasr.composeada.presentation.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gemasr.composeada.core.util.Resource
import com.gemasr.composeada.domain.PokemonRepository
import com.gemasr.composeada.domain.model.PokemonThrowable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    companion object {
        const val INITIAL_OFFSET = 0
    }

    private var currentPageSize = 10

    var state by mutableStateOf(PokemonListState())
        private set

    init {
        getPokemons()
    }

    fun getPokemons() {
        state = state.copy(isLoading = true)
        viewModelScope.launch {
            when (val result = repository.getPokemons(currentPageSize, INITIAL_OFFSET)) {
                is Resource.Success -> {
                    state = state.copy(
                        pokemons = result.data ?: emptyList(),
                        isLoading = false,
                        error = null
                    )
                    currentPageSize += 5
                }
                is Resource.Error -> {
                    state = state.copy(
                        pokemons = result.data ?: emptyList(),
                        isLoading = false,
                        error = result.error as PokemonThrowable
                    )
                }
            }
        }
    }
}