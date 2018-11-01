package com.gophersounds.burperloggerfb.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/*@Entity(tableName = "list_categories")
data class ListCategory(@ColumnInfo(name="category_name") var categoryName: String,
                        @ColumnInfo(name="id") @PrimaryKey(autoGenerate = true) var id: Long = 0)*/
@Entity(tableName = "burps")
data class Burp( @ColumnInfo(name="burp_name") var burpName: String
                ,@ColumnInfo(name="id") @PrimaryKey(autoGenerate=true) var id: Int = 0


                 , @ColumnInfo(name="star_rating") var starRating: Double
                 , @ColumnInfo(name="hof") var HOF: Int
                 ,@ColumnInfo(name="file_name") var fileName: String
                 , @ColumnInfo(name="burp_date") var burpDate: Long
                 )

