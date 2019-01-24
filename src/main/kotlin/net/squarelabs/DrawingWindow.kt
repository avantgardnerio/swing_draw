package net.squarelabs

import java.awt.*
import java.awt.event.*
import javax.swing.JFrame

class DrawingWindow(var root: Widget) : JFrame(), MouseListener, MouseMotionListener, KeyListener, ComponentListener {

    init {
        addComponentListener(this)
        addMouseListener(this)
        addMouseMotionListener(this)
        addKeyListener(this)
        defaultCloseOperation = EXIT_ON_CLOSE
        size = Dimension(400, 400)
        isVisible = true
    }

    override fun paint(graphics: Graphics?) {
        val g = graphics as Graphics2D
        val top = height - contentPane.height

        g.translate(-root.getOrigin().x, top - root.getOrigin().y)
        g.clipRect(0, 0, width, height - top)
        root.paint(g, width, height)
    }

    override fun componentResized(me: ComponentEvent?) {
        println("componentResized")
        root.resize(contentPane.width, contentPane.height)
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

    override fun componentMoved(p0: ComponentEvent?) {
        println("componentMoved")
    }

    override fun componentHidden(p0: ComponentEvent?) {
        println("componentHidden")
    }

    override fun componentShown(p0: ComponentEvent?) {
        println("componentShown")
    }
}
