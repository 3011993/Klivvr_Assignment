package com.example.klivvrassignment.presentation


sealed class UiState<T> {
    class Success<T>(val data: T) : UiState<T>()
    data class Error<T>(val message: String? = "") : UiState<T>()
    class Loading<T> : UiState<T>()
}