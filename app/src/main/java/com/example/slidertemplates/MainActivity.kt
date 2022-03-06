package com.example.slidertemplates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

//    var text_field : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text_field : TextView = findViewById(R.id.text_hello)
        //var text_to_return: String = changeText(text_field.text.toString())
        var edit_field : EditText = findViewById(R.id.input_field_text)


            edit_field.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {}

                override fun beforeTextChanged(s: CharSequence, start: Int,
                                               count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int,
                                           before: Int, count: Int) {
                    if (s.isEmpty()){
                        edit_field.error = "Empty Field"
                    }
                    else{
                        var text:String = changeText(text_field.text.toString()+s)
                        text_field.setText("")
                        text_field.setText(text)
                    }
                }
            })



    }

    protected fun changeText(text: String): String  {
        var changedString : String = ""
        for (i:Char in text.reversed()){
            changedString += i
        }
        return changedString
    }
}