package com.ahasanidea.mylibrary.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ahasanidea.mylibrary.data.Book
import com.ahasanidea.mylibrary.data.BookRepository

class BookListViewModel internal constructor(
    private val bookRepository: BookRepository
) : ViewModel() {
    private val year=MutableLiveData<Int>()

    private val bookList=MediatorLiveData<List<Book>>()

    init {
        year.value= NO_YEAR

        val liveBookList=Transformations.switchMap(year){
            if (it== NO_YEAR){
                bookRepository.getBooks()
            }
            else
            {
                bookRepository.getBooksByYear(it)
            }

        }
        bookList.addSource(liveBookList,bookList::setValue)
    }

    fun getBooks()=bookList

    fun setYear(num:Int){
        year.value=num
    }
    fun clearYear(){
        year.value= NO_YEAR
    }
    fun isFiltered()=year.value!= NO_YEAR

    companion object {
        private const val NO_YEAR=0
    }

}