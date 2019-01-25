package net.squarelabs

import java.awt.Point

class WidgetImpl : Widget {
    private var innerRect = Rect(Point(0, 0), Point(0, 0))
    private var outerRect = Rect(Point(0, 0), Point(0, 0))
    private val children = mutableListOf<Widget>()

    override fun setInnerRect(rect: Rect) {
        innerRect = rect
    }

    override fun setOuterRect(rect: Rect) {
        outerRect = rect
    }

    override fun getChildren(): List<Widget> {
        return children
    }

    override fun addChild(child: Widget) {
        children.add(child)
    }

    override fun getInnerRect(): Rect {
        return innerRect
    }

    override fun getOuterRect(): Rect {
        return outerRect
    }
}