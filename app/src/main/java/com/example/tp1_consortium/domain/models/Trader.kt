package com.example.tp1_consortium.domain.models

import kotlin.random.Random

data class Trader(
    var name: String = "",

    var jasmalt: Float = 200.0F,
    var kreotrium: Float = 200.0F,
    var xuskian: Float = 200.0F,
    var yefrium: Float = 200.0F,
    var zuscum: Float = 200.0F
)

fun recharge() {
    /*trader.jasmalt = trader.jasmalt + Random.nextInt(50, 200)
    trader.xuskian = trader.xuskian + Random.nextInt(50, 200)
    trader.kreotrium = trader.kreotrium + Random.nextInt(50, 200)
    trader.yefrium = trader.yefrium + Random.nextInt(50, 200)
    trader.zuscum = trader.zuscum + Random.nextInt(50, 200)

    binding.incResources.txvJ.text = trader.jasmalt.toString()
    binding.incResources.txvK.text = trader.kreotrium.toString()
    binding.incResources.txvXu.text = trader.xuskian.toString()
    binding.incResources.txvZ.text = trader.zuscum.toString()
    binding.incResources.txvYe.text = trader.yefrium.toString()*/
}

