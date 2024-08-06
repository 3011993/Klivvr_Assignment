package com.example.klivvrassignment.presentation

sealed class UiState<T> {
    class Success<T>(val data: T) : UiState<T>()
    class Loading<T> : UiState<T>()
}