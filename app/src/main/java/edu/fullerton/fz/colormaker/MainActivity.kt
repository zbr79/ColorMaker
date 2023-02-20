package edu.fullerton.fz.colormaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Switch


var redCurrent: Int = 1
var greenCurrent: Int = 1
var blueCurrent: Int = 1



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redSeekBar = findViewById<SeekBar>(R.id.red_seekbar)
        val greenSeekBar = findViewById<SeekBar>(R.id.green_seekbar)
        val blueSeekBar = findViewById<SeekBar>(R.id.blue_seekbar)


        val colorButton = findViewById<Button>(R.id.colorButton)


        val redNumber = findViewById<TextView>(R.id.red_number)
        val greenNumber = findViewById<TextView>(R.id.green_number)
        val blueNumber = findViewById<TextView>(R.id.blue_number)

        val redSwitch = findViewById<Switch>(R.id.red_switch)
        val greenSwitch = findViewById<Switch>(R.id.green_switch)
        val blueSwitch = findViewById<Switch>(R.id.blue_switch)

        val reset = findViewById<Button>(R.id.reset_button)

        colorButton.setBackgroundColor(Color.rgb(255, 255, 255))

        redSwitch.setOnCheckedChangeListener { _, isChecked ->
            redSeekBar.isEnabled = isChecked
            redNumber.isEnabled = isChecked
            if (!isChecked) {
                redCurrent = redSeekBar.progress
                //println(redCurrent)
                //println("set to 0")
                redSeekBar.progress = 0
                redNumber.setText("0.000")
            }
            else
            {
                //println("ELSE RAN")
                //println(redCurrent)
                redSeekBar.progress = redCurrent
            }
            updateColor(colorButton, redSeekBar.progress, greenSeekBar.progress, blueSeekBar.progress)
        }

        greenSwitch.setOnCheckedChangeListener { _, isChecked ->
            greenSeekBar.isEnabled = isChecked
            greenNumber.isEnabled = isChecked
            if (!isChecked) {
                greenCurrent = greenSeekBar.progress
                //println(redCurrent)
                //println("set to 0")
                greenSeekBar.progress = 0
                greenNumber.setText("0.000")
            }
            else
            {
                //println("ELSE RAN")
                //println(redCurrent)
                greenSeekBar.progress = greenCurrent
            }
            updateColor(colorButton, redSeekBar.progress, greenSeekBar.progress, blueSeekBar.progress)
        }


        blueSwitch.setOnCheckedChangeListener { _, isChecked ->
            blueSeekBar.isEnabled = isChecked
            blueNumber.isEnabled = isChecked
            if (!isChecked) {
                blueCurrent = blueSeekBar.progress
                //println(redCurrent)
                //println("set to 0")
                blueSeekBar.progress = 0
                blueNumber.setText("0.000")
            }
            else
            {
                //println("ELSE RAN")
                //println(redCurrent)
                blueSeekBar.progress = blueCurrent
            }
            updateColor(colorButton, redSeekBar.progress, greenSeekBar.progress, blueSeekBar.progress)
        }

        redSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                updateColor(colorButton, redSeekBar.progress, greenSeekBar.progress, blueSeekBar.progress)
                val valueRed = progress / 255.0
                redNumber.text = "${String.format("%.3f", valueRed)}"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        greenSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                updateColor(colorButton, redSeekBar.progress, greenSeekBar.progress, blueSeekBar.progress)
                val valueGreen = progress / 255.0
                greenNumber.text = "${String.format("%.3f", valueGreen)}"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        blueSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                updateColor(colorButton, redSeekBar.progress, greenSeekBar.progress, blueSeekBar.progress)
                val valueBlue = progress / 255.0
                blueNumber.text = "${String.format("%.3f", valueBlue)}"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


        reset.setOnClickListener {
            redSeekBar.progress = 0
            greenSeekBar.progress = 0
            blueSeekBar.progress = 0
            redNumber.setText("0.000")
            greenNumber.setText("0.000")
            blueNumber.setText("0.000")
            redSwitch.isChecked = true
            greenSwitch.isChecked = true
            blueSwitch.isChecked = true
            //redCurrent = redSeekBar.progress
            //greenCurrent = greenSeekBar.progress
            //blueCurrent = blueSeekBar.progress
            //unable to get it back to where the seekbar was at before using reset button

            updateColor(colorButton, redSeekBar.progress, greenSeekBar.progress, blueSeekBar.progress)
        }




    }








        private fun updateColor(button: Button, red: Int, green: Int, blue: Int) {
        button.setBackgroundColor(Color.rgb(red, green, blue))
    }
}