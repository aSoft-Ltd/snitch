package snitch.internal

import snitch.Bubble
import snitch.BubbleBuilder
import snitch.Snitch

data class BubbleBuilderImpl<I, B>(
    val title: String,
    val snitch: Snitch
) : BubbleBuilder<I, B> {
    private var icon: I? = null
    private var body: B? = null

    private fun build() = Bubble(
        title = title,
        icon = icon,
        body = body,
        actions = listOf()
    )

    override fun show() {
        snitch.show(build())
    }

    override fun on(action: String, handler: () -> Unit): BubbleBuilder<I, B> {
        return this
    }

    override fun withIcon(i: I): BubbleBuilder<I, B> {
        icon = i
        return this
    }

    override fun withBody(b: B): BubbleBuilder<I, B> {
        body = b
        return this
    }
}