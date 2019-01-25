package net.squarelabs

import java.awt.Color
import java.awt.Graphics2D

object GraphUtils {
    fun drawEmbossedRect(g: Graphics2D, rect: Rect, indent: Boolean) {
        val w = rect.origin.x
        val n = rect.origin.y
        val e = rect.origin.x + rect.size.x
        val s = rect.origin.y + rect.size.y

        g.color = Color.GRAY
        g.fillRect(w, n, rect.size.x, rect.size.y)

        g.color = if (indent) Color.DARK_GRAY else Color.LIGHT_GRAY
        g.drawLine(w, n, e, n) // top
        g.drawLine(w, n, w, s) // left

        g.color = if (indent) Color.LIGHT_GRAY else Color.DARK_GRAY
        g.drawLine(e, n, e, s) // right
        g.drawLine(w, s, e, s) // bottom
    }
}