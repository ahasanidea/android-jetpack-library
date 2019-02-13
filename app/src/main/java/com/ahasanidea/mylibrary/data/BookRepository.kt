package com.ahasanidea.mylibrary.data

/**
 * Repository module for handling data operations.
 */
class BookRepository private constructor(private val bookDao: BookDao) {

    fun getBooks() = bookDao.getBooks()

    fun getBook(bookId: Int) = bookDao.getBook(bookId)

    fun getBooksByYear(year: Int) = bookDao.getBooksByYear(year)

    companion object {

        //For Singleton instantiation
        @Volatile
        private var instance: BookRepository? = null

        fun getInstance(bookDao: BookDao) =
            instance ?: synchronized(this) {
                instance ?: BookRepository(bookDao).also { instance = it }
            }

    }
}