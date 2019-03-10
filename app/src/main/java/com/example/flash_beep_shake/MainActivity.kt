package com.example.flash_beep_shake

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.support.annotation.RequiresApi
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val vibratorService = getSystemService(Context.VIBRATOR_SERVICE ) as Vibrator

        val buttonV:Button = findViewById(R.id.vibrate)
        buttonV.setOnClickListener {
            vibratorService.vibrate(500)
        }
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager





        val buttonT:Button = findViewById(R.id.torch)
        val cameraId = cameraManager.getCameraIdList()[0]
        val flashLightStatus =true
        }



    }
}
