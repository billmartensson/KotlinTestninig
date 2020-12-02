package se.magictechnology.mytesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var calcButton : Button
    lateinit var calcTextview : TextView
    lateinit var calcEditText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcButton = findViewById<Button>(R.id.calcBTN)
        calcTextview = findViewById<TextView>(R.id.calcTV)
        calcEditText = findViewById<EditText>(R.id.calcET)


        calcButton.setOnClickListener {

            calcTextview.text = FancyCalc().checkEven(calcEditText.text.toString())

        }


    }
}