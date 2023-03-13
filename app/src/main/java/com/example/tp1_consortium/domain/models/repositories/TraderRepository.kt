package com.example.tp1_consortium.domain.models.repositories

import androidx.room.Dao
import androidx.room.Query
import com.example.tp1_consortium.domain.models.models.Trader
import kotlinx.coroutines.flow.Flow

@Dao
interface TraderRepository {

    @Query("SELECT * FROM notes")
    fun retrieveAll() : Flow<List<Trader>>

}