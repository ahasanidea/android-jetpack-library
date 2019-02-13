package com.ahasanidea.mylibrary.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "books")
data class Book(
    @PrimaryKey @ColumnInfo(name = "id") val bookId: Int,
    val name: String,
    val author: String,
    val text:String,
    val isbn: String,
    val year: Int,
    val imageUrl: String = ""
) {
    override fun toString(): String = name
}