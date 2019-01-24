package net.squarelabs

import java.awt.*
import java.awt.event.*
import javax.swing.JFrame

class DrawingWindow : JFrame(), MouseListener, MouseMotionListener, KeyListener {

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        size = Dimension(400, 400)
        isVisible = true
        addMouseListener(this)
        addMouseMotionListener(this)
        addKeyListener(this)
    }

    override fun paint(graphics: Graphics?) {
        super.paint(graphics)

        val g = graphics as Graphics2D
        g.color = Color.BLACK
        g.fillRect(0, 0, 400, 400)
    }

    override fun mouseReleased(p0: MouseEvent?) {
        println("mouseReleased")
    }

    override fun mouseEntered(p0: MouseEvent?) {
        println("mouseEntered")
    }

    override fun mouseClicked(p0: MouseEvent?) {
        println("mouseClicked")
    }

    override fun mouseExited(p0: MouseEvent?) {
        println("mouseExited")
    }

    override fun mousePressed(p0: MouseEvent?) {
        println("mousePressed")
    }

    override fun mouseMoved(p0: MouseEvent?) {
        //println("mouseMoved")
        repaint()
    }

    override fun mouseDragged(p0: MouseEvent?) {
        //println("mouseDragged")
    }

    override fun keyTyped(p0: KeyEvent?) {
        println("keyTyped")
    }

    override fun keyPressed(p0: KeyEvent?) {
        println("keyPressed")
    }

    override fun keyReleased(p0: KeyEvent?) {
        println("keyReleased")
    }
}
