package com.example.surgasepatu.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class ResetPasswordViewModel : ViewModel() {
    private val authRef = FirebaseAuth.getInstance()

    fun resetPassword (
        email: String,
        context: Context
    ) {
        viewModelScope.launch {
            if (email.isNotEmpty()) {
                authRef.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                context,
                                "Periksa email anda untuk reset password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            context,
                            "Email tidak terdaftar",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            } else {
                Toast.makeText(
                    context,
                    "Kolom tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}