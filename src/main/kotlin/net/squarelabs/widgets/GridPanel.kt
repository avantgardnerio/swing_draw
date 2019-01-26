package net.squarelabs.widgets

import net.squarelabs.Rect
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.Point

class GridPanel(val cb: (it: GridPanel) -> Unit) : Widget {
    override var bounds: Rect
        get() = widget.bounds
        set(value) {
            widget.bounds = value
        }
    private val widget = WidgetImpl()
    private var backgroundColor = Color.GRAY
    private val gridSize = 25
    private val font = Font("Courier New", Font.PLAIN, gridSize)

    init {
        cb(this)
    }

    fun setBackgroundColor(color: Color) {
        backgroundColor = color
    }

    override fun layout(rect: Rect) {
        super.layout(rect)
        getChildren().forEach { child ->
            val origin = Point(rect.size.x / 4, rect.size.y / 4)
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
        (bounds.origin.y..bounds.origin.y + bounds.size.y step gridSize).forEach { y ->
            graphics.drawString("$y", 0, y + gridSize)
            graphics.drawLine(bounds.origin.x, y, bounds.origin.x + bounds.size.x, y)
        }
        (bounds.origin.x..bounds.origin.x + bounds.size.x step gridSize).forEach { x ->
            if (x % 4 == 0) graphics.drawString("$x", x, 0 + gridSize)
            graphics.drawLine(x, bounds.origin.y, x, bounds.origin.y + bounds.size.y)
        }

        super.paint(graphics, width, height)
    }

    // Widget
    override fun getChildren(): List<Widget> {
        return widget.getChildren()
    }

    override fun addChild(child: Widget) {
        widget.addChild(child)
    }
}