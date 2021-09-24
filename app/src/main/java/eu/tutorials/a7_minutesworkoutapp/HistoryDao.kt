package eu.tutorials.a7_minutesworkoutapp

import androidx.room.Dao
import androidx.room.Insert

//Todo 4 create a dao interface with insert method
@Dao
interface HistoryDao {

    @Insert
    suspend fun insert(historyEntity: HistoryEntity)
}