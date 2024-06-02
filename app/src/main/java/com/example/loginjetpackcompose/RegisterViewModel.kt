package com.example.loginjetpackcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/*class RegisterViewModel(private val repository: UserRepository) : ViewModel() {
    fun register(user: User) {
        viewModelScope.launch {
            repository.insert(user)
        }
    }
}*/

class RegisterViewModel(private val repository: UserRepository) : ViewModel() {
    private val _registrationStatus = MutableStateFlow(false)
    val registrationStatus: StateFlow<Boolean> = _registrationStatus

    fun register(user: User) {
        viewModelScope.launch {
            repository.insert(user)
            _registrationStatus.value = true
        }
    }

    fun resetRegistrationStatus() {
        _registrationStatus.value = false
    }
}
