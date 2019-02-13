package com.ahasanidea.mylibrary.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.ahasanidea.mylibrary.data.Book
import com.ahasanidea.mylibrary.data.LibraryDatabase
import com.ahasanidea.mylibrary.utils.BOOK_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import java.lang.Exception

class SeedDatabaseWorker(
    context: Context,
    workerParameters: WorkerParameters
):Worker(context,workerParameters) {
    private val TAG by lazy { SeedDatabaseWorker::class.java.simpleName }
    override fun doWork(): Result {
        return try {
            applicationContext.assets.open(BOOK_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->
                    val bookType = object : TypeToken<List<Book>>() {}.type
                    val bookList: List<Book> = Gson().fromJson(jsonReader, bookType)

                    val database = LibraryDatabase.getInstance(applicationContext)
                    database.bookDao().insertAll(bookList)
                    Result.success()
                }
            }

        }
        catch (ex:Exception){
            Log.e(TAG,"Error seeding database")
            Result.failure()
        }
    }
}