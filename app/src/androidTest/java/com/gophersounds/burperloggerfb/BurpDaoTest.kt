package com.gophersounds.burperloggerfb

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.gophersounds.burperloggerfb.models.AppDatabase
import com.gophersounds.burperloggerfb.models.Burp
import com.gophersounds.burperloggerfb.models.BurpDao
import junit.framework.Assert
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class BurpDaoTest{
    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var burpDao: BurpDao

    @Before
    fun setup(){
        val context: Context = InstrumentationRegistry.getTargetContext()
        try {
            database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                    .allowMainThreadQueries().build()
        } catch (e: Exception){
            Log.e("test", e.message)
        }
        burpDao = database.burpDao()
    }


    @Test
    fun testAddingAndRetriveingDate(){
        val preInsertRetrievedBurps = burpDao.getAll()

        val burp = Burp("Burp 1", 1)
        burpDao.insertAll(burp)

        val postInsertRetrievedBurps = burpDao.getAll()
        val sizeDifference = postInsertRetrievedBurps.size - preInsertRetrievedBurps.size
        Assert.assertEquals(1, sizeDifference)
        val retrievedBurp = postInsertRetrievedBurps.last()
        Assert.assertEquals("Burp 1", retrievedBurp.burpName)

    }

    @After
    fun tearDown(){
        database.close()
    }

}