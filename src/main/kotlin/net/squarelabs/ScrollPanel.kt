package net.squarelabs

class ScrollPanel : Widget {
    private val widget = WidgetImpl()

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