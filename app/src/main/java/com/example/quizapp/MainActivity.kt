package com.example.quizapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReset.setOnClickListener {
            radioGroup.clearCheck()
            check1.isChecked = false
            check2.isChecked = false
            check3.isChecked = false
        }

        btnSubmit.setOnClickListener {
            var nowDate = LocalDateTime.now()

            var totalScore = 0

            if(radioGroup.checkedRadioButtonId == btnRadio1.id)
            {
                totalScore += 50
            }
            if (check1.isChecked) {
                totalScore += 25
            }
            if (check2.isChecked) {
                totalScore += 25
            }

            var formattedDate : String = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm a").format(nowDate).toString()

            if (totalScore >= 50)
            {
                var message1 = "Congratulations! You submitted on $formattedDate You achieved $totalScore%"
                Toast.makeText(this, message1, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "You submitted on $formattedDate You achieved $totalScore%", Toast.LENGTH_LONG).show()
            }

        }



    }
}