package net.squarelabs.widgets

import net.squarelabs.GraphUtils
import net.squarelabs.Rect
import net.squarelabs.ScalarSource
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Point

class HScroll(val dataSource: ScalarSource) : Widget {
    private val scrollBarWidth = 15
    private val widget = WidgetImpl()

    override fun layout(rect: Rect) {
        val origin = Point(0, rect.size.y - scrollBarWidth - 1)
        val size = Point(rect.size.x - scrollBarWidth, scrollBarWidth)
        widget.setBounds(Rect(origin, size))
    }

    override fun paint(graphics: Graphics2D, width: Int, height: Int) {
        super.paint(graphics, width, height)

        val range = dataSource.getMax() - dataSource.getMin()
        val ratio =  getBounds().size.x / range
        val barOrigin = Point(0, 0)
        val barSize = Point(getBounds().size.x, scrollBarWidth)
        val sliderSize = Point(((barSize.x - 2) * ratio).toInt(), scrollBarWidth - 2)
        val sliderOrigin = Point(1, barOrigin.y + 1)
        GraphUtils.drawEmbossedRect(graphics, Rect(barOrigin, barSize), true, Color.DARK_GRAY)
        GraphUtils.drawEmbossedRect(graphics, Rect(sliderOrigin, sliderSize), false, Color.GRAY)
    }

    // widget
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
