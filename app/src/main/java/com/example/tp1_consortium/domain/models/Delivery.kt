package com.example.tp1_consortium.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "deliveries")
data class Delivery (
                var jasmalt: Float = 0.0f,
                var kreotrium: Float = 0.0f,
                var xuskian: Float = 0.0f,
                var yefrium:Float=0.0f,
                var zuscum:Float=0.0f ) {
    @PrimaryKey(autoGenerate = true)
    var idDelivery : Int = 0
}


