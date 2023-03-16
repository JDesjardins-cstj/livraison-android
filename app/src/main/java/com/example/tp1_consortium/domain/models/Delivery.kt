package com.example.tp1_consortium.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "deliveries")
data class Delivery (
                var jasmalt: Double = 0.0,
                var kreotrium: Double = 0.0,
                var xuskian: Double = 0.0,
                var yefrium:Double=0.0,
                var zuscum:Double=0.0 ) {
    @PrimaryKey(autoGenerate = true)
    var idDelivery : Int = 0
}


