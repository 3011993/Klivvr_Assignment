package com.example.klivvrassignment.presentation

/**
 * A sealed class representing the different states of a UI operation, such as data loading or an action result.
 *
 * @param T The type of data associated with the UI state.
 */
sealed class UiState<T> {
    class Success<T>(val data: T) : UiState<T>()
    data class Error<T>(val message: String? = "") : UiState<T>()
    class Loading<T> : UiState<T>()
}