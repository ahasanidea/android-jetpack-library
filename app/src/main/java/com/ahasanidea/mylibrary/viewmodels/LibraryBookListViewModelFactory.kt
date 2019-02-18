package com.ahasanidea.mylibrary.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahasanidea.mylibrary.data.LibraryBookRepository

/**
 * Factory for creating a [LibraryBookListViewModel] with a constractor that takes
 * [LibraryBookRepository]
 */
class LibraryBookListViewModelFactory(
    private val libraryBookRepository:LibraryBookRepository
):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
         LibraryBookListViewModel(libraryBookRepository) as T

}