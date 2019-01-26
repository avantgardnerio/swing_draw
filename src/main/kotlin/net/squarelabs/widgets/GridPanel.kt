package net.squarelabs.widgets

import net.squarelabs.Rect
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.Point

class GridPanel : Widget {
    private val widget = WidgetImpl()
    private var backgroundColor = Color.GRAY
    private val gridSize = 25
    private val font = Font("Courier New", Font.PLAIN, gridSize)

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
        println("Drawing $backgroundColor origin=${getBounds().origin} size=${getBounds().size}")
        graphics.color = backgroundColor
        graphics.fillRect(getBounds().origin.x, getBounds().origin.y, getBounds().size.x, getBounds().size.y)

        graphics.color = Color.WHITE
        graphics.font = font
        (getBounds().origin.y..getBounds().origin.y + getBounds().size.y step gridSize).forEach { y ->
            graphics.drawString("$y", 0, y + gridSize)
            graphics.drawLine(getBounds().origin.x, y, getBounds().origin.x + getBounds().size.x, y)
        }
        (getBounds().origin.x..getBounds().origin.x + getBounds().size.x step gridSize).forEach { x ->
            if(x % 4 == 0) graphics.drawString("$x", x, 0 + gridSize)
            graphics.drawLine(x, getBounds().origin.y, x, getBounds().origin.y + getBounds().size.y)
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

    override fun setBounds(rect: Rect) {
        widget.setBounds(rect)
    }

    override fun getBounds(): Rect {
        return widget.getBounds()
    }
}