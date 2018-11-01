package com.gophersounds.burperloggerfb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_record.view.*

class RecordActivity : AppCompatActivity() {

    var isRecording = false;
    val TAG = "RecordActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)

        // save
        val imgSave = findViewById(R.id.imgSave) as ImageView

        // delete
        val imgDelete = findViewById(R.id.imgDelete) as ImageView

        // microphone
        val imgMic = findViewById(R.id.imgMicrophone) as ImageView



        val rateBurp = findViewById(R.id.rateBurp) as RatingBar
        rateBurp.visibility = View.INVISIBLE
        // set up
        //imgMic.setImageResource(R.drawable.ic_mic_none_black_24dp)
        //imgSave.visibility = View.VISIBLE
        //imgDelete.visibility = View.VISIBLE

        imgMic.setOnClickListener {
            if (isRecording == false){
                isRecording = true
                imgMic.setImageResource(R.drawable.ic_mic_none_black_24dp)
                return@setOnClickListener
            }
            if (isRecording == true){
                imgMic.setImageResource(R.drawable.ic_play_circle_filled_black_24dp)
                imgSave.visibility = View.VISIBLE
                imgDelete.visibility = View.VISIBLE


            }
        }
    }


}
