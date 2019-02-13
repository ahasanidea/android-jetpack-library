package com.ahasanidea.mylibrary.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahasanidea.mylibrary.data.BookRepository

class BookListViewModelFactory(
    private val repository: BookRepository
):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =BookListViewModel(repository) as T
}