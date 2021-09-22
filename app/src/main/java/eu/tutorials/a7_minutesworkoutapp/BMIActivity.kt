package eu.tutorials.a7_minutesworkoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.tutorials.a7_minutesworkoutapp.databinding.ActivityBmiBinding

class BMIActivity : AppCompatActivity() {
    //Todo create activity for the activity
    private var binding: ActivityBmiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Todo inflate the layout
        binding = ActivityBmiBinding.inflate(layoutInflater)
        //Todo connect the layout to this activity
        setContentView(binding?.root)

        //TODO(Step 5 : Setting up an action bar in BMI calculator activity using toolbar and adding a back arrow button along with click event.)
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