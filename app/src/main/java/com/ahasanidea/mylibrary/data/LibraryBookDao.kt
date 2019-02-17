package com.ahasanidea.mylibrary.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LibraryBookDao {
    @Query("SELECT * FROM library_books")
    fun getLibraryBooks(): LiveData<List<LibraryBook>>

    @Query("SELECT * FROM library_books WHERE id=:libraryBookId")
    fun getLibraryBook(libraryBookId: Long): LiveData<LibraryBook>

    @Query("SELECT * FROM library_books WHERE book_id=:bookId")
    fun getLibraryBookForBook(bookId: Int): LiveData<LibraryBook>

    /**
     * This query will tell Room to query both the [Book] and [LibraryBook] tables
     * and handle the object mapping
     */
    @Transaction
    @Query("SELECT * FROM books")
    fun getBookAndLibraryBooks(): LiveData<List<BookAndLibraryBooks>>

    @Insert
    fun insertLibraryBook(libraryBook: LibraryBook): Long

    @Delete
    fun deleteLibraryBook(libraryBook: LibraryBook)
}