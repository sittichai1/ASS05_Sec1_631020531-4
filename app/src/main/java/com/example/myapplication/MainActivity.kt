package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClickSendData()
        onClickReset()
    }
    fun onClickSendData(){
        btnSend.setOnClickListener{
            val selectID:Int = radioGroup.checkedRadioButtonId
            val checkedRadioText: RadioButton = findViewById(selectID)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("employee", Employee(editName.text.toString(), checkedRadioText.text.toString(), editEMail.text.toString(), editSalary.text.toString().toInt()))
            startActivity(intent)
        }
    }
    fun onClickReset(){
        btnReset.setOnClickListener{
            editName.text?.clear()
            editEMail.text?.clear()
            editSalary.text.clear()
            radioGroup.clearCheck()
        }
    }
}