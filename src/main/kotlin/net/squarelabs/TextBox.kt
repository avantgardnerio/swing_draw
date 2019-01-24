package net.squarelabs

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class TextBox(text: String) : Widget {
    override fun measure(g: Graphics2D): Bounds {
        return Bounds(Size(200, Unit.POINTS), Size(20, Unit.POINTS))
    }

    override fun getOrigin(): Point {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChildren(): List<Widget> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addChild(child: Widget) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resize(width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun paint(g: Graphics2D, width: Int, height: Int) {
        g.color = Color.DARK_GRAY
        g.drawLine(0, 0, width, 0)
        g.drawLine(width, 0, width, height)

        g.color = Color.LIGHT_GRAY
        g.drawLine(width, height, 0, height)
        g.drawLine(0, height, 0, 0)
    }
}