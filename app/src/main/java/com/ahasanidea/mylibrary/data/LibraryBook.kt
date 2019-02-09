package com.ahasanidea.mylibrary.data

import java.util.*

class LibraryBook(
    val bookId:Int,
    val registerDate:Calendar= Calendar.getInstance(),
    val lastReadingDate:Calendar= Calendar.getInstance()
) {
    var libraryBookId:Long=0
}