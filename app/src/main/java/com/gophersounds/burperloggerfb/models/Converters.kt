package com.gophersounds.burperloggerfb.models

import android.arch.persistence.room.TypeConverter
import java.util.*

//import java.util.Date
class Converters {

    @TypeConverter
    fun fromLongToDate(value: Long?): Date? {
        return if(value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToLong(date: Date): Long? {
        return date?.time
    }

}