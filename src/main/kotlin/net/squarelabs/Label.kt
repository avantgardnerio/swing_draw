package net.squarelabs

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Font



class Label(var text: String = "", var fontSize: Int = 24) : Widget {
    private var width: Int = 0
    private var height: Int = 0

    override fun getWidth(): Int {
        return this.width
    }

    override fun getHeight(): Int {
        return this.height
    }

    override fun resize(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    override fun paint(g: Graphics2D) {
        g.color = Color.GRAY
        g.fillRect(0, 0, width, height)

        g.font = Font("TimesRoman", Font.PLAIN, fontSize)
        g.color = Color.DARK_GRAY
        g.drawString(text, 0, fontSize)
    }
}