package com.ahasanidea.mylibrary.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahasanidea.mylibrary.data.Book
import com.ahasanidea.mylibrary.data.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job

/**
 * This ViewModel used in [BookDetailFragment]
 */
class BookDetailViewModel(
    bookRepository: BookRepository,
    private val bookId: Int
) : ViewModel() {

    val book:LiveData<Book>

    private val viewModelJob= Job()
    private val viewModelScope= CoroutineScope(Main+viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    init {
        book=bookRepository.getBook(bookId)
    }

}