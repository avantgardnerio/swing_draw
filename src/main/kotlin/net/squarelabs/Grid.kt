package net.squarelabs

import java.awt.Graphics2D
import java.awt.Point

class Grid : Widget {
    private var children = mutableListOf<Widget>()

    override fun getChildren(): List<Widget> {
        return children
    }

    override fun addChild(child: Widget) {
        children.add(child)
    }

    override fun resize(width: Int, height: Int) {
        
    }

    override fun paint(g: Graphics2D, width: Int, height: Int) {
        super.paint(g, width, height)

        val rowSizes = children.map { it.measure(g) }
        val heightPt = rowSizes.filter { it.height.units == Unit.POINTS }.fold(0) { acc, cur -> acc + cur.height.size }
        val heightPct = rowSizes.filter { it.height.units == Unit.PERCENT }.fold(0) { acc, cur -> acc + cur.height.size }
        val remainingHeight = Math.max(0, height - heightPt)
        val colCount = children.fold(0) { acc, row -> Math.max(acc, row.getChildren().size) }
        val colSizes = (0..colCount).map { idx ->
            children.fold(0) { acc, row ->
                val width = if(row.getChildren().size > idx) {
                    val width = row.getChildren()[idx].measure(g).width
                    if(width.units == Unit.PERCENT) { 0 } else { width.size }
                } else {
                    0
                }
                Math.max(acc, width)
            }
        }

        children.foldIndexed(0) { rowIdx, top, row ->
            // compute child space
            val bounds = rowSizes[rowIdx]
            val height = if (bounds.height.units == Unit.POINTS) {
                bounds.height.size
            } else {
                bounds.height.size / heightPct * remainingHeight
            }

            // draw child
            row.getChildren().foldIndexed(0) { colIdx, left, cell ->
                println("Rendering row=$rowIdx col=$colIdx")
                val width = colSizes[colIdx]
                val offsetX = left - row.getOrigin().x
                val offsetY = top - row.getOrigin().y

                //g.clipRect(top, left, width, height)
                g.translate(offsetX, offsetY)
                cell.paint(g, width, height)

                g.translate(-offsetX, -offsetY)
                left + width
            }
            top + height
        }
    }

    override fun getOrigin(): Point {
        return Point(0, 0)
    }

    override fun measure(graphics: Graphics2D): Bounds {
        return Bounds(Size(100, Unit.PERCENT), Size(100, Unit.PERCENT))
    }
}