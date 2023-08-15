package com.example.whatapp.domain.use_case

import com.example.whatapp.domain.repository.AuthRepository
import com.example.whatapp.presentation.MainActivity
import com.google.firebase.auth.PhoneAuthCredential
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    fun phoneNumberSignIn(phoneNumber: String, activity: MainActivity) =
        authRepository.phoneNumberSignIn(phoneNumber = phoneNumber, activity = activity)

    fun isUserAuthenticated() = authRepository.isUserAuthenticated()

    fun getUserId() = authRepository.getUserId()

    suspend fun signInWithAuthCredential(phoneAuthCredential: PhoneAuthCredential) =
        authRepository.signInWithAuthCredential(phoneAuthCredential = phoneAuthCredential)
}