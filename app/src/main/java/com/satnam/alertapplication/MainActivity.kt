package com.satnam.alertapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.satnam.alertapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


         binding.snackbar.setOnClickListener {
            var snackbarview =
            Snackbar.make(binding.snackbar, "This is snackbar", Snackbar.LENGTH_LONG)
            snackbarview.show()
            snackbarview.setAnchorView(R.id.snackbar)
            snackbarview.setAction("OK"){
                Toast.makeText(this, "This is toast",Toast.LENGTH_LONG).show()
            }
        }
         binding.alertdialog.setOnClickListener {
            AlertDialog.Builder(this,)
                .setTitle("Alert Title")
                .setMessage("This is Alert title")
                .setCancelable(true)
                .setPositiveButton("Positive") { _, _ ->
                    Toast.makeText(this, "Positive Button", Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("Negative") { _, _ ->
                    Toast.makeText(this, "Negative Button", Toast.LENGTH_LONG).show()
                }
                .setNeutralButton("Neutral") { _, _ ->
                    Toast.makeText(this, "Neutral Button", Toast.LENGTH_LONG).show()
                }
                .show()
        }
            binding.alertdialog.setOnClickListener {
                var dialog = Dialog( this)
                dialog.setContentView(R.layout.custom_dialog)
                dialog.show()
                var btnSet = dialog.findViewById<Button>(R.id.set)
                var btnCancel = dialog.findViewById<Button>(R.id.cancel)
                var entername = dialog.findViewById<EditText>(R.id.entername)
                entername.setText(binding.hello.text)
                btnSet.setOnClickListener {
                    if (entername.text.toString().isNullOrEmpty()){
                        entername.error = "Enter name"
                    }else{
                        binding.hello.text = entername.text.toString()

                    Toast.makeText(this, "SET",Toast.LENGTH_LONG).show()
                        dialog.dismiss()}
                }
                btnCancel.setOnClickListener {
                    Toast.makeText(this,"Cancel",Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }
            }
    }
}