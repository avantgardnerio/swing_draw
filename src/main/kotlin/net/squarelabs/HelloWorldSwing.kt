package net.squarelabs

import java.awt.Dimension

fun main() {
    val grid = Grid()
    val row1 = GridRow()
    val row2 = GridRow()
    grid.addChild(row1)
    grid.addChild(row2)

    val givenNameLabel = Label("Given name")
    val givenNameText = TextBox("John")
    row1.addChild(givenNameLabel)
    row1.addChild(givenNameText)

    val familyNameLabel = Label("Family name")
    val familyNameText = TextBox("Doe")
    row2.addChild(familyNameLabel)
    row2.addChild(familyNameText)

    DrawingWindow(grid)
}
