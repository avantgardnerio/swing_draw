package net.squarelabs

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import javax.swing.JFrame

class DrawingWindow : JFrame() {

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        size = Dimension(400, 400)
        isVisible = true
    }

    override fun paint(p0: Graphics?) {
        super.paint(p0)
    }
}