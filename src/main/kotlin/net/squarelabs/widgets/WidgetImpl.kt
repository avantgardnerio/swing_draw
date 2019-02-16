package net.squarelabs.widgets

import net.squarelabs.Rect
import net.squarelabs.listeners.WidgetListener
import java.awt.Point

class WidgetImpl(
        override var bounds: Rect = Rect(Point(0, 0), Point(0, 0)),
        override var children: MutableList<Widget> = mutableListOf(),
        override var listeners: MutableList<WidgetListener> = mutableListOf()
) : Widget