package com.ahasanidea.mylibrary.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ahasanidea.mylibrary.data.Book
import com.ahasanidea.mylibrary.data.BookRepository
import com.ahasanidea.mylibrary.data.LibraryBookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * This ViewModel used in [BookDetailFragment]
 */
class BookDetailViewModel(
    bookRepository: BookRepository,
    private val libraryBookRepository: LibraryBookRepository,
    private val bookId: Int
) : ViewModel() {

    val book: LiveData<Book>
    /**
     * This is the job for all coroutines started by this ViewModel.
     *
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = Job()
    /**
     * This is the scope for all coroutines launched by [BookDetailViewModel].
     *
     * Since we pass [viewModelJob], you can cancel all coroutines launched by [viewModelScope] by calling
     * viewModelJob.cancel().  This is called in [onCleared].
     */
    private val viewModelScope = CoroutineScope(Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        book = bookRepository.getBook(bookId)
    }

    fun addBookToLibrary() {
        viewModelScope.launch {
            libraryBookRepository.createLibraryBook(bookId)
        }
    }

}