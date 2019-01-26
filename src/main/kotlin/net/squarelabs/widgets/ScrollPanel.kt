package net.squarelabs.widgets

import net.squarelabs.GraphUtils
import net.squarelabs.Rect
import net.squarelabs.ScalarSource
import java.awt.Color
import java.awt.Graphics2D

class ScrollPanel : Widget {
    private val widget = WidgetImpl()
    private val hScroll = HScroll(object : ScalarSource {
        override fun getMin(): Double {
            return 0.0
        }

        override fun getMax(): Double {
            return getChildBounds().size.x.toDouble()
        }

        override fun getValue(): Double {
            return 0.0
        }
    })
    private val vScroll = VScroll(object : ScalarSource {
        override fun getMin(): Double {
            return 0.0
        }

        override fun getMax(): Double {
            return getChildBounds().size.y.toDouble()
        }

        override fun getValue(): Double {
            return 0.0
        }
    })

    init {
        addChild(hScroll)
        addChild(vScroll)
    }

    override fun layout(rect: Rect) {
        super.layout(rect)
        hScroll.layout(rect)
        vScroll.layout(rect)
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        println("ScrollPanel $width $height ${getBounds()} ${getBounds()}")
        super.paint(graphics, width, height)

        graphics.color = Color.DARK_GRAY
        graphics.drawRect(0, 0, getBounds().size.x - 1, getBounds().size.y - 1)

        paintChild(graphics, width, height, hScroll)
        paintChild(graphics, width, height, vScroll)
    }

    // Widget
    override fun getChildren(): List<Widget> {
        return widget.getChildren()
    }

    override fun addChild(child: Widget) {
        widget.addChild(child)
    }

    override fun setBounds(rect: Rect) {
        widget.setBounds(rect)
    }

    override fun getBounds(): Rect {
        return widget.getBounds()
    }
}