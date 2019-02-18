package com.ahasanidea.mylibrary.utils

import android.content.Context
import com.ahasanidea.mylibrary.data.BookRepository
import com.ahasanidea.mylibrary.data.LibraryBookRepository
import com.ahasanidea.mylibrary.data.LibraryDatabase
import com.ahasanidea.mylibrary.viewmodels.BookDetailViewModelFactory
import com.ahasanidea.mylibrary.viewmodels.BookListViewModelFactory
import com.ahasanidea.mylibrary.viewmodels.LibraryBookListViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {
    private fun getBookRepository(context: Context) =
        BookRepository.getInstance(LibraryDatabase.getInstance(context).bookDao())

    private fun getLibraryBookRepository(context: Context) =
        LibraryBookRepository.getInstance(LibraryDatabase.getInstance(context).libraryBookDao())

    fun provideBookListViewModelFactory(context: Context): BookListViewModelFactory {
        val repository = getBookRepository(context)
        return BookListViewModelFactory(repository)
    }

    fun provideLibraryBookListViewModelFactory(
        context: Context
    ): LibraryBookListViewModelFactory {
        val repository = getLibraryBookRepository(context)
        return LibraryBookListViewModelFactory(repository)
    }

    fun provideBookDetailViewModelFactory(
        context: Context,
        bookId: Int
    ): BookDetailViewModelFactory {
        return BookDetailViewModelFactory(
            getBookRepository(context),
            getLibraryBookRepository(context),
            bookId
        )
    }
}