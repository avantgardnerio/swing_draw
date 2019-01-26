package net.squarelabs.widgets

import net.squarelabs.Rect
import java.awt.Graphics2D
import java.awt.Point
import java.awt.event.MouseEvent

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

    fun paintChild(graphics: Graphics2D, width: Int, height: Int, child: Widget) {
        val prevClip = graphics.clip
        graphics.translate(child.getBounds().origin.x, child.getBounds().origin.y)
        graphics.clipRect(0, 0, child.getBounds().size.x, child.getBounds().size.y)

        val w = Math.min(width, child.getBounds().size.x)
        val h = Math.min(height, child.getBounds().size.y)
        child.paint(graphics, w, h)

        graphics.translate(-child.getBounds().origin.x, -child.getBounds().origin.y)
        graphics.clip = prevClip
    }

    // painting
    fun paint(graphics: Graphics2D, width: Int, height: Int) {
        getChildren().forEach { paintChild(graphics, width, height, it) }
    }

    // events
    fun mousePressed(position: Point) {
        getChildren().forEach { child ->
            val bounds = child.getBounds()
            if(bounds.contains(position)) {
                child.mousePressed(bounds.toLocal(position))
            }
        }
    }

    fun mouseMoved(position: Point) {
        getChildren().forEach { child ->
            val bounds = child.getBounds()
            if(bounds.contains(position)) {
                child.mouseMoved(bounds.toLocal(position))
            }
        }
    }

    fun mouseReleased(position: Point) {
        getChildren().forEach { child ->
            val bounds = child.getBounds()
            if(bounds.contains(position)) {
                child.mouseReleased(bounds.toLocal(position))
            }
        }
    }
}