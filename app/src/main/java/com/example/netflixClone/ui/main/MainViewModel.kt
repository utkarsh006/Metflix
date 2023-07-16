package com.example.netflixClone.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.netflixClone.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@OptIn(FlowPreview::class) // Using Flow Debounce
class MainViewModel @Inject constructor(
    movieRepository: MovieRepository
) : ViewModel() {

    private val dataDebounce = 200L
    private val _state = MutableStateFlow<MainState>(MainState.Loading)

    val categories = movieRepository.movies.debounce(dataDebounce)
    val header = movieRepository.headerMovie.debounce(dataDebounce)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val fetchRequest = movieRepository.fetchMovies()
            if (fetchRequest.isSuccessful) {
                _state.value = MainState.Success
            } else {
                _state.value = MainState.Error(Throwable(message = fetchRequest.message()))
            }
        }
    }
}

sealed interface MainState {

    object Loading : MainState

    object Success : MainState

    data class Error(val throwable: Throwable?) : MainState

}