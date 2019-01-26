package net.squarelabs.widgets

import net.squarelabs.GraphUtils
import net.squarelabs.Rect
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class ScrollPanel : Widget {
    private val widget = WidgetImpl()
    private val scrollBarWidth = 15

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        println("ScrollPanel $width $height ${getBounds()} ${getBounds()}")
        super.paint(graphics, width, height)
        graphics.color = Color.DARK_GRAY
        graphics.drawRect(0, 0, getBounds().size.x - 1, getBounds().size.y - 1)

        // calculate
        val childBounds = getChildBounds()

        // horizontal
        if (childBounds.size.x > getBounds().size.x) {
            val ratio = 1.0 * getBounds().size.x / childBounds.size.x
            val barOrigin = Point(0, getBounds().size.y - scrollBarWidth - 1)
            val barSize = Point(getBounds().size.x - scrollBarWidth, scrollBarWidth)
            val sliderSize = Point(((barSize.x - 2) * ratio).toInt(), scrollBarWidth - 2)
            val sliderOrigin = Point(1, barOrigin.y + 1)
            println("hScroll ${childBounds.size.x}/${getBounds().size.x} hSize=$ratio ${sliderSize.x}/${barSize.x}")
            GraphUtils.drawEmbossedRect(graphics, Rect(barOrigin, barSize), true, Color.DARK_GRAY)
            GraphUtils.drawEmbossedRect(graphics, Rect(sliderOrigin, sliderSize), false, Color.GRAY)
        }

        // vertical
        if (childBounds.size.y > getBounds().size.y) {
            val ratio = 1.0 * getBounds().size.y / childBounds.size.y
            val barOrigin = Point(getBounds().size.x - scrollBarWidth - 1, 0)
            val barSize = Point(scrollBarWidth, getBounds().size.y - scrollBarWidth)
            val sliderSize = Point(scrollBarWidth - 2, ((barSize.y - 2) * ratio).toInt())
            val sliderOrigin = Point(barOrigin.x + 1, 1)
            println("vScroll ${childBounds.size.y}/${getBounds().size.y} hSize=$ratio ${sliderSize.y}/${barSize.y}")
            GraphUtils.drawEmbossedRect(graphics, Rect(barOrigin, barSize), true, Color.DARK_GRAY)
            GraphUtils.drawEmbossedRect(graphics, Rect(sliderOrigin, sliderSize), false, Color.GRAY)
        }
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