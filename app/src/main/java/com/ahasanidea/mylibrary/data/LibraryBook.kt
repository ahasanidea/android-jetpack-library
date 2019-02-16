package com.ahasanidea.mylibrary.data

import androidx.room.*
import java.util.*

/**
 * [LibraryBook] represents when a user adds a [Book] into their library
 */
@Entity(
    tableName = "library_books",
    foreignKeys = [ForeignKey(entity = Book::class,parentColumns = ["id"],childColumns = ["book_id"])],
    indices = [Index("book_id")]
    )
class LibraryBook(
    @ColumnInfo(name = "book_id") val bookId:Int,
    /**
     * Indicates when the [Book] was added into library
     */
    val registerDate:Calendar= Calendar.getInstance(),
    val lastReadingDate:Calendar= Calendar.getInstance()
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var libraryBookId:Long=0
}