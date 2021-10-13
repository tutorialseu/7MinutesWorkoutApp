package eu.tutorials.a7_minutesworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.tutorials.a7_minutesworkoutapp.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    //Todo 1 creat a binding variable
    private var binding:ActivityExerciseBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//Todo 2 inflate the layout
        binding = ActivityExerciseBinding.inflate(layoutInflater)
//Todo 3 pass in binding?.root in the content view
        setContentView(binding?.root)
//Todo 5: then set support action bar and get toolBarExcerciser using the binding
//variable
        setSupportActionBar(binding?.toolbarExercise)

        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}