package net.squarelabs.widgets

import net.squarelabs.Rect
import net.squarelabs.listeners.WidgetListener
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.Point

class GridPanel(
        cb: (it: GridPanel) -> Unit
) : Widget {
    
    override var listeners: MutableList<WidgetListener>
        get() = widget.listeners
        set(value) { widget.listeners = value }

    override var children: MutableList<Widget>
        get() = widget.children
        set(value) { widget.children = value }

    override var bounds: Rect
        get() = widget.bounds
        set(value) { widget.bounds = value }
    
    var backgroundColor = Color.GRAY
    private val widget = WidgetImpl()
    private val gridSize = 25
    private val font = Font("Courier New", Font.PLAIN, gridSize)

    init {
        cb(this)
    }

    override fun layout(rect: Rect) {
        super.layout(rect)
        children.forEach { child ->
            val origin = Point(rect.size.x / 4 + rect.origin.x, rect.size.y / 4 + rect.origin.y)
            val size = Point(rect.size.x / 2, rect.size.y / 2)
            child.layout(Rect(origin, size))
        }
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        println("Drawing $backgroundColor origin=${bounds.origin} size=${bounds.size}")
        graphics.color = backgroundColor
        graphics.fillRect(bounds.origin.x, bounds.origin.y, bounds.size.x, bounds.size.y)

        graphics.color = Color.WHITE
        graphics.font = font
        (0..bounds.size.y step gridSize).forEach { y ->
            graphics.drawString("$y", 0, y + bounds.origin.y + gridSize)
            graphics.drawLine(
                    bounds.origin.x,
                    y + bounds.origin.y,
                    bounds.origin.x + bounds.size.x,
                    y + bounds.origin.y
            )
        }
        (0..bounds.size.x step gridSize).forEach { x ->
            if (x % 4 == 0) graphics.drawString("$x", x + bounds.origin.x, 0 + gridSize)
            graphics.drawLine(
                    x + bounds.origin.x,
                    bounds.origin.y,
                    x + bounds.origin.x,
                    bounds.origin.y + bounds.size.y
            )
        }

        super.paint(graphics, width, height)
    }
}