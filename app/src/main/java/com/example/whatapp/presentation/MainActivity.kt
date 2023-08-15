package com.example.whatapp.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import com.example.whatapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: AuthViewModel by viewModels()
    var otpValue = MutableStateFlow<String>("")
    private lateinit var phoneNumber: String
    lateinit var userName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (checkAuthenticationStatus()) {

        } else {
            binding.userAuthenticationLayout.visibility = View.VISIBLE
            binding.appLogo.visibility = View.VISIBLE
            binding.userNumberLayout.visibility = View.VISIBLE
            binding.textInputLayout1.visibility = View.VISIBLE
            binding.etNumber.visibility = View.VISIBLE
            binding.btProceed.visibility = View.VISIBLE
        }

        binding.btProceed.setOnClickListener {
            if (binding.etNumber.isVisible) {
                phoneNumber = binding.etNumber.text.toString()
                viewModel.signInWithPhoneNumber("+84 $phoneNumber", this)
            } else {
//                userName = binding.etName.text.toString()
//                viewModel.createUserProfile(userName, userNumber = phoneNumber)
            }
        }


    }

    private fun checkAuthenticationStatus(): Boolean {
        return false
    }

    fun showBottomSheet() {
        val otpFragment = OTPFragment()
        supportFragmentManager.beginTransaction().add(otpFragment, "bottomSheetFragment").commit()

    }
}