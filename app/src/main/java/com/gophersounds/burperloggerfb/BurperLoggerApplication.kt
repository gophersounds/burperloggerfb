package com.gophersounds.burperloggerfb

import android.app.Application
import android.arch.persistence.room.Room
import com.gophersounds.burperloggerfb.models.AppDatabase

class BurperLoggerApplication: Application() {
    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate(){
        super.onCreate()
        BurperLoggerApplication.database = Room.databaseBuilder(this, AppDatabase::class.java, "burperlogger-master-db").build()
    }
}
