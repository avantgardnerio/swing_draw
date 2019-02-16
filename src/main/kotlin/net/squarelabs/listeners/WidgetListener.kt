package net.squarelabs.listeners

import net.squarelabs.Rect

interface WidgetListener {
    fun invalidated(region: Rect)
}