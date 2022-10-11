package com.example.quizapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
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
            val nowDate = LocalDateTime.now()

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

            val formattedDate : String = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm a").format(nowDate).toString()

            val congratulationString = if (totalScore >= 50) "Congratulations! " else ""
            //Create an Alert dialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Quiz Result")
            builder.setMessage("$congratulationString You submitted on $formattedDate You achieved $totalScore%")
            builder.setIcon(android.R.drawable.ic_dialog_info)
            //Give only dismiss button for alert
            builder.setPositiveButton("Dismiss"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Dismissed",Toast.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()

        }

    }
}