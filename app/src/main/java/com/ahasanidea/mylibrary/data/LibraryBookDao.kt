package com.ahasanidea.mylibrary.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface LibraryBookDao {
    @Query("SELECT * FROM library_books")
    fun getLibraryBooks():LiveData<List<LibraryBook>>
}