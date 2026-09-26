package ca.gbc.comp3074.azimi.labex1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("CYCLE","onCreate")
        val label = findViewById<TextView>(R.id.label)
        val button = findViewById<Button>(R.id.button)


        button.setOnClickListener {
            val values = resources.getStringArray(R.array.values)
          Log.d("BTN", "button click")
            i=(i+1) % values.size
            label.setText(values[i])//R.string.click_value
            button.setBackgroundColor(getColor(R.color.green))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("CYCLE","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CYCLE","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CYCLE","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CYCLE","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CYCLE","onDestroy")
    }
}