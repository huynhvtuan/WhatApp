package com.example.whatapp.presentation

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatapp.domain.use_case.AuthUseCase
import com.example.whatapp.util.Resource
import com.google.firebase.auth.PhoneAuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    fun signInWithPhoneNumber(
        phoneNumber: String,
        activity: MainActivity
    ) {
        viewModelScope.launch {
            authUseCase.phoneNumberSignIn(phoneNumber, activity).collect {
                when (it) {
                    is Resource.Loading -> {
                        Toast.makeText(activity.baseContext, "Loading", Toast.LENGTH_LONG).show()
                    }

                    is Resource.Error -> {
                        Toast.makeText(activity.baseContext, it.message, Toast.LENGTH_LONG).show()
                    }

                    is Resource.Success -> {
                        Toast.makeText(activity.baseContext, "Success", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

}