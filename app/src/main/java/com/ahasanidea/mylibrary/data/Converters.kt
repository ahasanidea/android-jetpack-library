package com.ahasanidea.mylibrary.data

import androidx.room.TypeConverter
import java.util.*

/**
 * Type converters to allow Room to reference complex data types.
 */

class Converters {
    @TypeConverter
    fun calenderToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar = Calendar.getInstance().apply { timeInMillis = value }
}