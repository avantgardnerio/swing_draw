package net.squarelabs

import java.awt.Point

data class Rect(val origin: Point, val size: Point) {

    fun contains(p: Point): Boolean {
        if(p.x < origin.x) return false
        if(p.y < origin.y) return false
        if(p.x > origin.x + size.x) return false
        if(p.y > origin.y + size.y) return false
        return true
    }

    fun toLocal(p: Point): Point {
        return Point(p.x - origin.x, p.y - origin.y)
    }

    companion object {
        val MIN = Rect(Point(Int.MAX_VALUE, Int.MAX_VALUE), Point(Int.MIN_VALUE, Int.MIN_VALUE))

        fun union(a: Rect, b: Rect): Rect {
            val w = Math.min(a.origin.x, b.origin.x)
            val n = Math.min(a.origin.y, b.origin.y)
            val e = Math.max(a.origin.x + a.size.x, b.origin.x + b.size.x)
            val s = Math.max(a.origin.y + a.size.y, b.origin.y + b.size.y)
            val origin = Point(w, n)
            val size = Point(e - w, s - n)
            return Rect(origin, size)
        }
    }
}
