package net.squarelabs

import java.awt.SystemColor.text
import sun.swing.SwingUtilities2.stringWidth
import java.awt.*

class Label(var text: String = "", var fontSize: Int = 24) : Widget {

    override fun getOrigin(): Point {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getChildren(): List<Widget> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addChild(child: Widget) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var width: Int = 0
    private var height: Int = 0

    override fun measure(g: Graphics2D): Bounds {
        val font = Font("TimesRoman", Font.PLAIN, fontSize)
        val metrics = g.getFontMetrics(font)
        val width = Size(metrics.stringWidth(text) + 2, Unit.POINTS)
        val height = Size(metrics.getHeight() + 2, Unit.POINTS)
        return Bounds(width, height)
    }

    override fun resize(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    override fun paint(g: Graphics2D, width: Int, height: Int) {
        println("Label $text $width $height")
        g.color = Color.GRAY
        g.fillRect(0, 0, width, height)

        g.font = Font("TimesRoman", Font.PLAIN, fontSize)
        g.color = Color.DARK_GRAY
        g.drawString(text, 0, fontSize)
    }
}