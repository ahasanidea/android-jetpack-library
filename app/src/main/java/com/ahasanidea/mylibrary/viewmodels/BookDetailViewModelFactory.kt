package com.ahasanidea.mylibrary.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahasanidea.mylibrary.data.BookRepository

class BookDetailViewModelFactory(
    private val bookRepository: BookRepository,
    private val bookId:Int
): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookDetailViewModel(bookRepository,bookId) as T
    }
}