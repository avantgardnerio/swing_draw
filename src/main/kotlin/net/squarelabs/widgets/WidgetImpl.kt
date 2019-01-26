package net.squarelabs.widgets

import net.squarelabs.Rect
import java.awt.Point

class WidgetImpl(
        override var bounds: Rect = Rect(Point(0, 0), Point(0, 0))
) : Widget {
    private val children = mutableListOf<Widget>()

    override fun getChildren(): List<Widget> {
        return children
    }

    override fun addChild(child: Widget) {
        children.add(child)
    }
}