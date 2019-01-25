package net.squarelabs

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class ScrollPanel : Widget {
    private val widget = WidgetImpl()
    private val scrollBarWidth = 15

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        println("ScrollPanel $width $height ${getInnerRect()} ${getOuterRect()}")
        //super.paint(graphics, width, height)

        graphics.color = Color.GRAY
        GraphUtils.drawEmbossedRect(
            graphics, Rect( // horizontal
                Point(getInnerRect().origin.x, getInnerRect().size.y - scrollBarWidth - 1),
                Point(getInnerRect().size.x - scrollBarWidth, scrollBarWidth)
            ), true
        )
        GraphUtils.drawEmbossedRect(
            graphics, Rect( // vertical
                Point(getInnerRect().size.x - scrollBarWidth - 1, getInnerRect().origin.y),
                Point(scrollBarWidth, getInnerRect().size.y - scrollBarWidth)
            ), true
        )
    }

    // Widget
    override fun getChildren(): List<Widget> {
        return widget.getChildren()
    }

    override fun addChild(child: Widget) {
        widget.addChild(child)
    }

    override fun setInnerRect(rect: Rect) {
        widget.setInnerRect(rect)
    }

    override fun setOuterRect(rect: Rect) {
        widget.setOuterRect(rect)
    }

    override fun getInnerRect(): Rect {
        return widget.getInnerRect()
    }

    override fun getOuterRect(): Rect {
        return widget.getOuterRect()
    }
}