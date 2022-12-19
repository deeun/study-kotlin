package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etHeight: EditText = findViewById(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            Log.d("MainActivity", "calculate button clicked!")

            if (etHeight.text.isEmpty() || etWeight.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //이 아래로는 빈 값이 올 수 없음
            val height: Int = etHeight.text.toString().toInt()
            val weight: Int = etWeight.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
//            Log.d("MainActivity", "height: $height weight: $weight")
        }

    }
}