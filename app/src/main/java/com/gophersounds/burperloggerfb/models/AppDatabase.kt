package com.gophersounds.burperloggerfb.models

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

@Database(entities = [(Burp::class)], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase(){
    abstract fun burpDao():BurpDao
}