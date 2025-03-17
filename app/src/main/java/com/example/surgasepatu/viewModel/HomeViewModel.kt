package com.example.surgasepatu.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class HomeViewModel : ViewModel() {
    private val authRef = FirebaseAuth.getInstance()
    private val dbRef = FirebaseDatabase.getInstance().getReference("users")

    private val _username = mutableStateOf("Loading...")
    val username: State<String> = _username

    init {
        fetchUsername()
    }

    private fun fetchUsername() {
        val userId = authRef.currentUser?.uid
        userId?.let {
            dbRef.child(it).child("username").get()
                .addOnSuccessListener { snapshot->
                    _username.value = snapshot.value as? String ?: "User"
                }
        }
    }
}