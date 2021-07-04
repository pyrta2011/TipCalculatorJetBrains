package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.slider.Slider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edit_text)
        val slider = findViewById<Slider>(R.id.slider)
        val textView = findViewById<TextView>(R.id.text_view)

        fun changeText(x: String = editText.text.toString(), y: Float = slider.value) {
            if (x == "") textView.text = ""
            else {
                val df = DecimalFormat("###0.00")
                val tip: String? = df.format(x.toFloat() * y / 100)
                "Tip amount: $tip".also { textView.text = it }
            }
        }
        slider.addOnChangeListener {_, value, _ -> changeText(y = value)}

        editText.doAfterTextChanged { text ->
            val new = text?.toString() ?: ""
            changeText(x = new)
        }
    }
}