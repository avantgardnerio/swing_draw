package net.squarelabs.widgets

import net.squarelabs.GraphUtils
import net.squarelabs.Rect
import net.squarelabs.listeners.ScalarListener
import net.squarelabs.listeners.WidgetListener
import net.squarelabs.sources.ScalarSource
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class VScroll(val dataSource: ScalarSource) : Widget {
    override var listeners: MutableList<WidgetListener>
        get() = widget.listeners
        set(value) { widget.listeners = value }
    
    override var children: MutableList<Widget>
        get() = widget.children
        set(value) { widget.children = value }

    override var bounds: Rect
        get() = widget.bounds
        set(value) { widget.bounds = value }
    
    private val scrollBarWidth = 15
    private val widget = WidgetImpl()
    private val scrollListeners = mutableListOf<ScalarListener>()
    private var downPos: Double? = null

    override fun layout(rect: Rect) {
        val origin = Point(rect.size.x - scrollBarWidth - 1, 0)
        val size = Point(scrollBarWidth, rect.size.y - scrollBarWidth)
        widget.bounds = Rect(origin, size)
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        super.paint(graphics, width, height)

        val barOrigin = Point(0, 0)
        val barSize = Point(scrollBarWidth, bounds.size.y)
        val sliderOrigin = Point(barOrigin.x + 1, sliderTop)
        val sliderSize = Point(scrollBarWidth - 2, sliderHeight)
        GraphUtils.drawEmbossedRect(graphics, Rect(barOrigin, barSize), true, Color.DARK_GRAY)
        GraphUtils.drawEmbossedRect(graphics, Rect(sliderOrigin, sliderSize), false, Color.GRAY)
    }

    val dataRange: Double
        get() = dataSource.getMax() - dataSource.getMin()

    val sliderHeight: Int
        get() = ((bounds.size.y - 2) * (bounds.size.y / dataRange)).toInt()

    val sliderRange: Int
        get() = bounds.size.y - sliderHeight

    val sliderTop: Int
        get() = (dataSource.getValue() / dataRange * sliderRange).toInt()

    fun addScrollListener(listener: ScalarListener) {
        scrollListeners.add(listener)
    }

    override fun mousePressed(position: Point) {
        downPos = (position.y - sliderTop).toDouble() / sliderHeight
    }

    override fun mouseMoved(position: Point) {
        if (downPos == null) return
        val newTop = position.y - sliderHeight * downPos!!
        val newVal = (newTop / sliderRange) * dataRange + dataSource.getMin()
        val clamped = Math.min(Math.max(newVal, dataSource.getMin()), dataSource.getMax())
        scrollListeners.forEach { it.onChange(clamped) }
    }

    override fun mouseReleased(position: Point) {
        downPos = null
    }
}
