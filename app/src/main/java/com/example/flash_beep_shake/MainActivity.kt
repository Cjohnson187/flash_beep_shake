package com.example.flash_beep_shake

import android.annotation.TargetApi
import android.content.Context
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.support.annotation.RequiresApi
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowTitleEnabled(false)


        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE ) as Vibrator

        val buttonV:Button = this.findViewById(R.id.vibrate)
            buttonV.setOnClickListener {
            vibratorService.vibrate(500)
        }

        val buttonB:Button = this.findViewById(R.id.beep)
        val tone = ToneGenerator(AudioManager.STREAM_MUSIC, 50)

        buttonB.setOnClickListener {
            tone.startTone(ToneGenerator.TONE_DTMF_C,500)
        }



        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        val buttonT:Button = findViewById(R.id.torch)
        val cameraId = cameraManager.getCameraIdList()[0]
        var flashLightStatus =false


        buttonT.setOnClickListener {
            if (flashLightStatus == false){
                cameraManager.setTorchMode(cameraId, true)
                flashLightStatus = true
            }

            else if (flashLightStatus == true) {
                cameraManager.setTorchMode(cameraId, false)
                flashLightStatus = false
            }

        }







    }



}

