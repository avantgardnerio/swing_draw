package net.squarelabs

import java.awt.Point

data class Rect(val origin: Point, val size: Point) {
    companion object {
        val MIN = Rect(Point(Int.MAX_VALUE, Int.MAX_VALUE), Point(Int.MIN_VALUE, Int.MIN_VALUE))

        fun union(a: Rect, b: Rect): Rect {
            val w = Math.min(a.origin.x, b.origin.x)
            val n = Math.min(a.origin.y, b.origin.y)
            val s = Math.max(a.origin.x + a.size.x, b.origin.x + b.size.x)
            val e = Math.max(a.origin.y + a.size.y, b.origin.y + b.size.y)
            val origin = Point(w, n)
            val size = Point(e - w, s - n)
            return Rect(origin, size)
        }
    }
}
