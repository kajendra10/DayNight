package com.kjprojects.daynight
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.mahfa.dnswitch.DayNightSwitch


class MainActivity : AppCompatActivity() {

    private var sun: ImageView? = null
    private var dayland: ImageView? = null
    private var nightland: ImageView? = null
    private var daySky: View? = null
    private var nightSky: View? = null
    private var dayNightSwitch: DayNightSwitch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sun = findViewById(R.id.sun)
        dayland = findViewById(R.id.day_landscape)
        nightland = findViewById(R.id.night_landscape)
        daySky = findViewById(R.id.day_bg)
        nightSky = findViewById(R.id.night_bg)
        dayNightSwitch = findViewById(R.id.day_night_switch)
        sun?.translationY = -110f

        dayNightSwitch?.setListener { isnight ->
            if (isnight) {
                sun?.animate()?.translationY(110f)?.duration = 1000
                dayland?.animate()?.alpha(0f)?.duration = 1300
                daySky?.animate()?.alpha(0f)?.duration = 1300
            } else {
                sun?.animate()?.translationY(-110f)?.duration = 1000
                dayland?.animate()?.alpha(1f)?.duration = 1300
                daySky?.animate()?.alpha(1f)?.duration = 1300
            }
        }
    }
}