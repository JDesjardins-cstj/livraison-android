package com.example.tp1_consortium.domain.repositories

import androidx.room.Dao
import androidx.room.Query

@Dao
interface DeliveryRepository {

    @Query("DELETE FROM deliveries")
    suspend fun deleteAll()
}