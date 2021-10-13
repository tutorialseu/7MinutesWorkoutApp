package eu.tutorials.a7_minutesworkoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import eu.tutorials.a7_minutesworkoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //  The binding is name just like the name of the layout with Binding attached
    //Todo 5:We create a variable for it and assign to null
    private var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Todo 7: We inflate the late file by calling inflate on the Binding name
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Todo 8: Then replace the setContentView parameter with binding?.root
        setContentView(binding?.root)

        binding?.flStart?.setOnClickListener {
            val intent = Intent(this,ExerciseActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        //Todo 9: TO avoid memory leak we unassign the binding once the activity is destroyed
        binding = null
    }
}