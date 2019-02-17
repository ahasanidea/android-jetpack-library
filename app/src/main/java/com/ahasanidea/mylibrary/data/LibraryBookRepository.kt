package com.ahasanidea.mylibrary.data

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class LibraryBookRepository private constructor(
    private val libraryBookDao:LibraryBookDao
){
    suspend fun createLibraryBook(bookId:Int){
    withContext(IO){
        val libraryBook=LibraryBook(bookId)
        libraryBookDao.insertLibraryBook(libraryBook)
    }
    }
    suspend fun removeLibraryBook(libraryBook: LibraryBook){
        withContext(IO){
            libraryBookDao.deleteLibraryBook(libraryBook)
        }
    }
    fun getLibraryBookForBook(bookId: Int) =
        libraryBookDao.getLibraryBookForBook(bookId)

    fun getLibraryBooks() = libraryBookDao.getLibraryBooks()

    fun getBookAndLibraryBooks() = libraryBookDao.getBookAndLibraryBooks()

    companion object {
        //For Singleton instantiation
        @Volatile private var instance:LibraryBookRepository?=null

        fun getInstance(libraryBookDao: LibraryBookDao)= instance?: synchronized(this){
            instance?:LibraryBookRepository(libraryBookDao).also{ instance=it}
        }

    }

}