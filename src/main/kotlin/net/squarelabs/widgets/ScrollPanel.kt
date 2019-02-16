package net.squarelabs.widgets

import net.squarelabs.Rect
import net.squarelabs.listeners.ScalarListener
import net.squarelabs.listeners.WidgetListener
import net.squarelabs.sources.ScalarSource
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class ScrollPanel : Widget {
    override var listeners: MutableList<WidgetListener>
        get() = widget.listeners
        set(value) { widget.listeners = value }

    override var children: MutableList<Widget>
        get() = widget.children
        set(value) { widget.children = value }

    override var bounds: Rect
        get() = widget.bounds
        set(value) { widget.bounds = value }

    private val widget = WidgetImpl()

    private val hScroll = HScroll(object : ScalarSource {
        override fun getMin(): Double { return 0.0 }

        override fun getMax(): Double { return (getChildBounds().size.x - bounds.size.x).toDouble() }

        override fun getValue(): Double { return -getChildBounds().origin.getX() }
    })

    private val vScroll = VScroll(object : ScalarSource {
        override fun getMin(): Double { return 0.0 }

        override fun getMax(): Double { return (getChildBounds().size.y - bounds.size.y).toDouble() }

        override fun getValue(): Double { return -getChildBounds().origin.getY() }
    })

    init {
        addChild(hScroll)
        addChild(vScroll)
        hScroll.addScrollListener(object : ScalarListener {
            override fun onChange(value: Double) {
                children.forEach {
                    if(it != hScroll && it != vScroll) {
                        it.layout(Rect(Point(-value.toInt(), it.bounds.origin.y), it.bounds.size))
                        listeners.forEach { it.invalidated(bounds) }
                    }
                }
            }
        })
        vScroll.addScrollListener(object : ScalarListener {
            override fun onChange(value: Double) {
                children.forEach {
                    if(it != hScroll && it != vScroll) {
                        it.layout(Rect(Point(it.bounds.origin.x, -value.toInt()), it.bounds.size))
                        listeners.forEach { it.invalidated(bounds) }
                    }
                }
            }
        })
    }

    override fun layout(rect: Rect) {
        super.layout(rect)
        hScroll.layout(rect)
        vScroll.layout(rect)
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        println("ScrollPanel $width $height ${bounds} ${bounds}")
        super.paint(graphics, width, height)

        graphics.color = Color.DARK_GRAY
        graphics.drawRect(0, 0, bounds.size.x - 1, bounds.size.y - 1)

        paintChild(graphics, width, height, hScroll)
        paintChild(graphics, width, height, vScroll)
    }
}