package com.ahasanidea.mylibrary.data

import androidx.room.Embedded
import androidx.room.Relation

/**
 * This class captures the relationship between a [Book] and a user's [LibraryBook], which is used
 * by room to fetch the related entities.
 */
class BookAndLibraryBooks {
   @Embedded lateinit var book: Book

    @Relation(parentColumn = "id",entityColumn = "book_id")
    var libraryBooks:List<LibraryBook>  = arrayListOf()

}