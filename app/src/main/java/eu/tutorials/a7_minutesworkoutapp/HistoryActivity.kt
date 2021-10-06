package eu.tutorials.a7_minutesworkoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import eu.tutorials.a7_minutesworkoutapp.databinding.ActivityHistoryBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    // create a binding for the layout
    private var binding: ActivityHistoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//inflate the layout
        binding = ActivityHistoryBinding.inflate(layoutInflater)
// bind the layout to this activity
        setContentView(binding?.root)

//Setting up the action bar in the History Screen Activity and
// adding a back arrow button and click event for it.)
        setSupportActionBar(binding?.toolbarHistoryActivity)

        val actionbar = supportActionBar//actionbar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true) //set back button
            actionbar.title = "HISTORY" // Setting a title in the action bar.
        }

        binding?.toolbarHistoryActivity?.setNavigationOnClickListener {
            onBackPressed()
        }
        /**  Todo 3: get the dao through the database in the application class
         *  then call getAllCompletedDates method and pass in the dao
         */

        val dao = (application as WorkOutApp).db.historyDao()
        getAllCompletedDates(dao)
    }


    // TODO(Step 2 : Created a function to get the list of completed dates from the History Table.)
    // START
    /**
     * Function is used to get the list exercise completed dates.
     */
    private fun getAllCompletedDates(historyDao: HistoryDao) {


       lifecycleScope.launch {
          historyDao.fetchALlDates().collect { allCompletedDatesList->
              // List items are printed in log.
              for (i in allCompletedDatesList) {
                  Log.e("Date : ", "" + i)
              }
          }
       }

    }
    // END
    override fun onDestroy() {
        super.onDestroy()
// reset the binding to null to avoid memory leak
        binding = null
    }
}