package com.ahasanidea.mylibrary.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface LibraryBookDao {
    @Query("SELECT * FROM library_books")
    fun getLibraryBooks():LiveData<List<LibraryBook>>

    @Query("SELECT * FROM library_books WHERE id=:libraryBookId")
    fun getLibraryBook(libraryBookId:Long):LiveData<LibraryBook>
    @Query("SELECT * FROM library_books WHERE book_id=:bookId")
    fun getLibraryBookForBook(bookId:Int):LiveData<LibraryBook>



}