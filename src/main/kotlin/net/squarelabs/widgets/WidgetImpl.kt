package net.squarelabs.widgets

import net.squarelabs.Rect
import java.awt.Point

class WidgetImpl : Widget {
    private var bounds = Rect(Point(0, 0), Point(0, 0))
    private val children = mutableListOf<Widget>()

    override fun setBounds(rect: Rect) {
        bounds = rect
    }

    override fun getChildren(): List<Widget> {
        return children
    }

    override fun addChild(child: Widget) {
        children.add(child)
    }

    override fun getBounds(): Rect {
        return bounds
    }
}