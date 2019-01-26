package net.squarelabs.widgets

import net.squarelabs.Rect
import java.awt.Graphics2D

interface Widget {
    // children
    fun getChildren(): List<Widget>

    fun addChild(child: Widget)

    // coordinate system
    fun setBounds(rect: Rect)

    fun getBounds(): Rect

    // layout
    fun layout(rect: Rect) {
        setBounds(rect)
    }

    fun getChildBounds(): Rect {
        return getChildren().fold(Rect.MIN) { acc, cur ->
            Rect.union(
                acc,
                cur.getBounds()
            )
        }
    }

    // painting
    fun paint(graphics: Graphics2D, width: Int, height: Int) {
        getChildren().forEach { c ->
            graphics.translate(c.getBounds().origin.x, c.getBounds().origin.y)
            //graphics.clipRect(0, 0, c.getBounds().size.x, c.getBounds().size.y)

            val w = Math.min(width, c.getBounds().size.x)
            val h = Math.min(height, c.getBounds().size.y)
            c.paint(graphics, w, h)

            graphics.translate(-c.getBounds().origin.x, -c.getBounds().origin.y)
        }
    }
}