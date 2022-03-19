package com.example.kotlin1dz1.presentation.ui.fragments.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1dz1.client.ServerClient
import com.example.kotlin1dz1.models.LanguageModel

class MovViewModel  : ViewModel() {
    val description = MutableLiveData<String>()

    fun getBooks(): List<LanguageModel> {
        return ServerClient().getBooks()
    }

    fun putDescription(text: String) {
        description.value = text
    }
}