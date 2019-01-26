package net.squarelabs

interface ScalarSource {
    fun getMin(): Double

    fun getMax(): Double

    fun getValue(): Double
}

interface ScalarListener {
    fun onChange(value: Double)
}