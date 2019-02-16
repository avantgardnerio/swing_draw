package net.squarelabs.widgets

import net.squarelabs.GraphUtils
import net.squarelabs.Rect
import net.squarelabs.ScalarListener
import net.squarelabs.ScalarSource
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class HScroll(val dataSource: ScalarSource) : Widget {
    override var children: MutableList<Widget>
        get() = widget.children
        set(value) {
            widget.children = value
        }
    override var bounds: Rect
        get() = widget.bounds
        set(value) {
            widget.bounds = value
        }
    private val scrollBarWidth = 15
    private val widget = WidgetImpl()
    private val listeners = mutableListOf<ScalarListener>()
    private var downPos: Double? = null
    private var downValue: Double? = null

    override fun layout(rect: Rect) {
        val origin = Point(0, rect.size.y - scrollBarWidth - 1)
        val size = Point(rect.size.x - scrollBarWidth, scrollBarWidth)
        widget.bounds = Rect(origin, size)
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        super.paint(graphics, width, height)

        val barOrigin = Point(0, 0)
        val barSize = Point(bounds.size.x, scrollBarWidth)
        val sliderOrigin = Point(sliderLeft, barOrigin.y + 1)
        val sliderSize = Point(sliderWidth, scrollBarWidth - 2)
        GraphUtils.drawEmbossedRect(graphics, Rect(barOrigin, barSize), true, Color.DARK_GRAY)
        GraphUtils.drawEmbossedRect(graphics, Rect(sliderOrigin, sliderSize), false, Color.GRAY)
    }

    val dataRange: Double
        get() = dataSource.getMax() - dataSource.getMin()

    val sliderWidth: Int
        get() = ((bounds.size.x - 2) * (bounds.size.x / dataRange)).toInt()

    val sliderRange: Int
        get() = bounds.size.x - sliderWidth

    val sliderLeft: Int
        get() = (dataSource.getValue() / dataRange * sliderRange).toInt()

    // events
    fun addListener(listener: ScalarListener) {
        listeners.add(listener)
    }

    override fun mousePressed(position: Point) {
        println("down")
        downPos = (position.x - sliderLeft).toDouble() / sliderWidth
        downValue = dataSource.getValue()
    }

    override fun mouseMoved(position: Point) {
        if (downPos == null || downValue == null) return
        println("draggin")
    }

    override fun mouseReleased(position: Point) {
        println("up")
        downPos = null
        downValue = null
    }
}
