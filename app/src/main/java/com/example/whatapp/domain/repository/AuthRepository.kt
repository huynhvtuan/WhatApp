package com.example.whatapp.domain.repository

import com.example.whatapp.presentation.MainActivity
import com.example.whatapp.util.Resource
import com.google.firebase.auth.PhoneAuthCredential
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun phoneNumberSignIn(phoneNumber: String, activity: MainActivity): Flow<Resource<Boolean>>

    fun isUserAuthenticated(): Boolean

    fun getUserId(): String

    suspend fun signInWithAuthCredential(phoneAuthCredential: PhoneAuthCredential): Resource<Boolean>


}