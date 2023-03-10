package eu.tutorials.a7minutesworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import eu.tutorials.a7minutesworkout.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {
    private var binding: ActivityFinishBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarFinishActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarFinishActivity?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding?.btnFinish?.setOnClickListener {
            finish()
        }

        //get the dao through the database in the application class
        val dao = (application as WorkOutApp).db.historyDao()
        addDateToDatabase(dao)
    }
        private fun addDateToDatabase(historyDao: HistoryDao) {
            val c = Calendar.getInstance() // Calendars Current Instance
            val dateTime = c.time // Current Date and Time of the system.

            val sdf =
                SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault()) // Date Formatter
            val date = sdf.format(dateTime) // dateTime is formatted in the given format.
            Log.e("Formatted Date : ", "" + date) // Formatted date is printed in the log.

            lifecycleScope.launch {
                historyDao.insert(HistoryEntity(date)) // Add date function is called.
                Log.e(
                    "Date : ",
                    "Added..."
                ) // Printed in log which is printed if the complete execution is done.
            }
        }

}