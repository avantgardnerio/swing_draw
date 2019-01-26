package net.squarelabs.widgets

import net.squarelabs.GraphUtils
import net.squarelabs.Rect
import net.squarelabs.ScalarListener
import net.squarelabs.ScalarSource
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class VScroll(val dataSource: ScalarSource) : Widget {
    override var bounds: Rect
        get() = widget.bounds
        set(value) {
            widget.bounds = value
        }
    private val scrollBarWidth = 15
    private val widget = WidgetImpl()
    private val listeners = mutableListOf<ScalarListener>()
    private var dragging = false

    override fun layout(rect: Rect) {
        val origin = Point(rect.size.x - scrollBarWidth - 1, 0)
        val size = Point(scrollBarWidth, rect.size.y - scrollBarWidth)
        widget.bounds = Rect(origin, size)
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        super.paint(graphics, width, height)

        val range = dataSource.getMax() - dataSource.getMin()
        val ratio = bounds.size.y / range
        val barOrigin = Point(0, 0)
        val barSize = Point(scrollBarWidth, bounds.size.y)
        val sliderSize = Point(scrollBarWidth - 2, ((barSize.y - 2) * ratio).toInt())
        val sliderOrigin = Point(barOrigin.x + 1, 1)
        GraphUtils.drawEmbossedRect(graphics, Rect(barOrigin, barSize), true, Color.DARK_GRAY)
        GraphUtils.drawEmbossedRect(graphics, Rect(sliderOrigin, sliderSize), false, Color.GRAY)
    }

    fun addListener(listener: ScalarListener) {
        listeners.add(listener)
    }

    override fun mousePressed(position: Point) {
        dragging = true
    }

    override fun mouseReleased(position: Point) {
        dragging = false
    }

    // widget
    override fun getChildren(): List<Widget> {
        return widget.getChildren()
    }

    override fun addChild(child: Widget) {
        widget.addChild(child)
    }
}
