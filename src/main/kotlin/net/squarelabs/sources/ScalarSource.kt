package net.squarelabs.sources

interface ScalarSource {
    fun getMin(): Double

    fun getMax(): Double

    fun getValue(): Double
}
