package net.squarelabs.widgets

import net.squarelabs.Rect
import java.awt.Point

class WidgetImpl(
        override var bounds: Rect = Rect(Point(0, 0), Point(0, 0)),
        override var children: MutableList<Widget> = mutableListOf()
) : Widget