package com.example.lab6

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText

class InputDialog(
    private val context: Context,
    private val listener: InputDialogListener
) {

    interface InputDialogListener {
        fun onTextSend(text: String)
        fun onExitApp()
    }

    private var dialog: AlertDialog? = null

    fun show() {
        val builder = AlertDialog.Builder(context)


        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.dialog_input, null)


        val editTextInput = dialogView.findViewById<EditText>(R.id.editTextInput)
        val btnExitApp = dialogView.findViewById<Button>(R.id.btnExitApp)
        val btnCloseDialog = dialogView.findViewById<Button>(R.id.btnCloseDialog)
        val btnSendText = dialogView.findViewById<Button>(R.id.btnSendText)


        btnSendText.setOnClickListener {
            val text = editTextInput.text.toString()
            if (text.isNotEmpty()) {
                listener.onTextSend(text)
                dialog?.dismiss()
            }
        }

        btnCloseDialog.setOnClickListener {
            dialog?.dismiss()
        }

        btnExitApp.setOnClickListener {
            listener.onExitApp()
            dialog?.dismiss()
        }


        builder.setView(dialogView)
        dialog = builder.create()
        dialog?.show()
    }

    fun dismiss() {
        dialog?.dismiss()
    }
}