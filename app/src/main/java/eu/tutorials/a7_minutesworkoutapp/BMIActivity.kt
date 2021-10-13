package eu.tutorials.a7_minutesworkoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.tutorials.a7_minutesworkoutapp.databinding.ActivityBmiBinding

//TODO(Step 2 : Creating a BMI calculator activity.)
//START
class BMIActivity : AppCompatActivity() {
    //Todo 3 create binding for the activity
    private var binding: ActivityBmiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Todo 4 inflate the layout
        binding = ActivityBmiBinding.inflate(layoutInflater)
        //Todo 5 connect the layout to this activity
        setContentView(binding?.root)

        //TODO(Step 7 : Setting up an action bar in BMI calculator activity using toolbar and adding a back arrow button along with click event.)
        //START
        setSupportActionBar(binding?.toolbarBmiActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //set back button
        supportActionBar?.title = "CALCULATE BMI" // Setting a title in the action bar.
        binding?.toolbarBmiActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        // END
    }
}