package eu.tutorials.a7minutesworkoutapp

import android.app.Application
import eu.tutorials.a7minutesworkoutapp.database.HistoryDatabase

// create the application class
class WorkOutApp: Application() {

    val db: HistoryDatabase by lazy {
        HistoryDatabase.getInstance(this)
    }
}