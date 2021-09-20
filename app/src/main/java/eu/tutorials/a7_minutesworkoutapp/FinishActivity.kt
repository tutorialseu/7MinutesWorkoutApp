package eu.tutorials.a7_minutesworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.tutorials.a7_minutesworkoutapp.databinding.ActivityExerciseBinding
import eu.tutorials.a7_minutesworkoutapp.databinding.ActivityFinishBinding

class FinishActivity : AppCompatActivity() {
    //Todo 1: Create a binding variable
    private var binding: ActivityFinishBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//Todo 2: inflate the layout
        binding = ActivityFinishBinding.inflate(layoutInflater)
//Todo 3: bind the layout to this Activity
        setContentView(binding?.root)
//Todo 4: Replace kotlin synthetic with viewbinding
        setSupportActionBar(binding?.toolbarFinishActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarFinishActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        //END

        //TODO(Step 5 : Adding a click event to the Finish Button.)
        //START
        binding?.btnFinish?.setOnClickListener {
            finish()
        }
    }
}