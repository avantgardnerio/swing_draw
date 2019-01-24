package net.squarelabs

import java.awt.Graphics2D

interface Widget {
    fun getWidth(): Int
    fun getHeight(): Int
    fun resize(width: Int, height: Int)
    fun paint(graphics: Graphics2D)
}