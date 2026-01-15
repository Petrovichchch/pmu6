package com.example.lab6  // ← должен совпадать с package в InputDialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity(), InputDialog.InputDialogListener {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tvDisplayText)
        val button = findViewById<Button>(R.id.btnShowDialog)

        button.setOnClickListener {
            showInputDialog()
        }
    }

    private fun showInputDialog() {
        val dialog = InputDialog(this, this)
        dialog.show()
    }

    override fun onTextSend(text: String) {
        textView.text = "Введенный текст: $text"
    }

    override fun onExitApp() {
        finish()
    }
}