package com.gophersounds.burperloggerfb.models

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [(Burp::class)], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun burpDao():BurpDao
}