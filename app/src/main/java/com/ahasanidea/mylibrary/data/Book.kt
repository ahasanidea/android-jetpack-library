package com.ahasanidea.mylibrary.data

class Book(
    val bookId:Int,
    val name:String,
    val author:String,
    val year:Int
    ) {
    override fun toString(): String =name
}