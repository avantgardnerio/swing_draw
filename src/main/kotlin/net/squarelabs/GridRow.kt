package net.squarelabs

import java.awt.Graphics2D
import java.awt.Point

class GridRow : Widget {
    private var children = mutableListOf<Widget>()

    override fun getChildren(): List<Widget> {
        return children
    }

    override fun addChild(child: Widget) {
        children.add(child)
    }

    override fun measure(g: Graphics2D): Bounds {
        val sizes = children.map { it.measure(g) }
        val width = Size(100, Unit.PERCENT)
        val height = sizes
            .filter { it.height.units == Unit.POINTS }
            .fold(0) { acc, cur -> Math.max(acc, cur.height.size) }
        return Bounds(width, Size(height, Unit.POINTS))
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {

    }

    override fun getOrigin(): Point {
        return Point(0, 0)
    }

    override fun resize(width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}