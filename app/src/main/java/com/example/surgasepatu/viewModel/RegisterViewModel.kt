package com.example.surgasepatu.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val authRef = FirebaseAuth.getInstance()

    fun register(
        email: String,
        password: String,
        context: Context,
        navController: NavController
    ) {
        viewModelScope.launch {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                authRef.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task->
                        if (task.isSuccessful) {
                            navController.navigate("login")
                            Toast.makeText(
                                context,
                                "Register berhasil",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            context,
                            "Email sudah terdaftar",
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