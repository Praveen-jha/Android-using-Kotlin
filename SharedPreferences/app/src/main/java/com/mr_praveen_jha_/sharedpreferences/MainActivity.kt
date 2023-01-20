package com.mr_praveen_jha_.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("MyPref", MODE_PRIVATE)
        val editor = sharedPref.edit()
        save.setOnClickListener {
            val name = etname.text.toString()
            val age = etage.text.toString().toInt()
            val isAdult = checkBox.isChecked

            editor.apply {
                putString("NAME", name)
                putInt("AGE", age)
                putBoolean("ADULT", isAdult)
                apply()
            }
        }

        load.setOnClickListener {
            val name = sharedPref.getString("NAME", null)
            val age = sharedPref.getInt("AGE", 0)
            val adult = sharedPref.getBoolean("ADULT", false)



            etname.setText(name)
            etage.setText(age.toString())
            checkBox.isChecked = adult
        }
    }
}