package com.gophersounds.burperloggerfb.models

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface BurpDao{

    @Query("SELECT * FROM burps")
    fun getAll(): List<Burp>

    @Insert
    fun insertAll(vararg burp: Burp)
}