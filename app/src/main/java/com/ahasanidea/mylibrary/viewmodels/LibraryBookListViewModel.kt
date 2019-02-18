package com.ahasanidea.mylibrary.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ahasanidea.mylibrary.data.BookAndLibraryBooks
import com.ahasanidea.mylibrary.data.LibraryBookRepository

class LibraryBookListViewModel internal constructor(
    libraryBookRepository: LibraryBookRepository
):ViewModel(){
    val libraryBooks=libraryBookRepository.getLibraryBooks()
    val bookAndLibraryBooks: LiveData<List<BookAndLibraryBooks>> =
        Transformations.map(libraryBookRepository.getBookAndLibraryBooks()) { books ->
            books.filter { it.libraryBooks.isNotEmpty() }
        }
}