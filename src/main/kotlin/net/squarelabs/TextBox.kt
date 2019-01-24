package net.squarelabs

import java.awt.Graphics2D
import java.awt.Point

class TextBox(text: String) : Widget {
    override fun measure(g: Graphics2D): Bounds {
        return Bounds(Size(0, Unit.PERCENT), Size(0, Unit.PERCENT))
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

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        
    }
}