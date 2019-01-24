package net.squarelabs

enum class Unit { POINTS, PERCENT }

data class Size(val size: Int, val units: Unit)

data class Bounds(val width: Size, val height: Size)