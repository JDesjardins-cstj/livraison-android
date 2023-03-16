package com.example.tp1_consortium.domain.repositories

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tp1_consortium.domain.models.Delivery
import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryRepository {

    @Query("DELETE FROM deliveries")
    suspend fun deleteAll()

    @Query("SELECT * FROM deliveries")
    fun retrieveAll() : Flow<List<Delivery>>

    @Insert
    suspend fun insert(delivery: Delivery)
}