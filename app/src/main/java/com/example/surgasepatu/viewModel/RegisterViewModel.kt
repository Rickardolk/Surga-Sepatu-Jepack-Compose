package com.example.surgasepatu.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val authRef = FirebaseAuth.getInstance()
    private val dbRef = FirebaseDatabase.getInstance().getReference("users")

    fun register(
        username: String,
        email: String,
        password: String,
        context: Context,
        navController: NavController
    ) {
        viewModelScope.launch {
            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                authRef.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task->
                        if (task.isSuccessful) {
                            val userId = authRef.currentUser?.uid
                            val user = mapOf(
                                "username" to username,
                                "email" to email
                            )
                            userId?.let {
                                dbRef.child(it).setValue(user)
                                    .addOnSuccessListener {
                                        navController.navigate("login")
                                        Toast.makeText(
                                            context,
                                            "Register berhasil",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                            }
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