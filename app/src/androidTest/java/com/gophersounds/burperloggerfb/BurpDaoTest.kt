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
        val burpName = "Burp"
        //val _id = 0
        val starRating = 4.5
        val HOF = 0
        val fileName = "fileName"
        val burpDate = System.currentTimeMillis()

        val burp = Burp(burpName, 0, starRating, HOF, fileName, burpDate)
        burpDao.insertAll(burp)

        val postInsertRetrievedBurps = burpDao.getAll()
        val sizeDifference = postInsertRetrievedBurps.size - preInsertRetrievedBurps.size
        Assert.assertEquals(1, sizeDifference)
        val retrievedBurp = postInsertRetrievedBurps.last()
        Assert.assertEquals(retrievedBurp.burpName, burpName)
       // Assert.assertEquals(retrievedBurp.id, _id)
        Assert.assertEquals(retrievedBurp.starRating, starRating)
        Assert.assertEquals(retrievedBurp.HOF, HOF)
        Assert.assertEquals(retrievedBurp.fileName, fileName)
        Assert.assertEquals(retrievedBurp.burpDate,  burpDate)
        //Log.i("Test", retrievedBurp.id.toString())
        //Assert.assertEquals(burpName, _id, starRating)
        Log.i("Test", retrievedBurp.burpDate.toString())
    }

    @After
    fun tearDown(){
        database.close()
    }

}