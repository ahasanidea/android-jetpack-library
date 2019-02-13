package com.ahasanidea.mylibrary.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The data access object for the Book class.
 * */
@Dao
interface BookDao {
    @Query("SELECT * FROM books ORDER BY name")
    fun getBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE year = :year ORDER BY name")
    fun getBooksByYear(year: Int): LiveData<List<Book>>

    @Query("SELECT * FROM books WHERE id = :bookId")
    fun getBook(bookId: Int): LiveData<Book>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(books: List<Book>)
}