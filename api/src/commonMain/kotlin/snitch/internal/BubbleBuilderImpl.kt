package snitch.internal

import kotlinx.collections.interoperable.iMutableListOf
import presenters.actions.ActionsBuilder
import presenters.actions.SimpleAction
import snitch.Bubble
import snitch.BubbleBuilder
import snitch.Type

internal class BubbleBuilderImpl<I, B>(
    val title: String,
    val type: Type,
    val snitch: SnitchImpl
) : ActionsBuilder<BubbleBuilder<I, B>, () -> Unit>, BubbleBuilder<I, B> {
    private var icon: I? = null
    private var body: B? = null
    private var timeoutSeconds = Bubble.DEFAULT_TIMEOUT_SECONDS

    private var actions = iMutableListOf<SimpleAction>()

    private fun build() = Bubble(
        title = title,
        icon = icon,
        body = body,
        type = type,
        timeoutSeconds = timeoutSeconds,
        actions = actions
    )

    override fun show() {
        snitch.show(build())
    }

    override fun on(name: String, handler: () -> Unit): BubbleBuilder<I, B> {
        val action = SimpleAction(name, handler)
        actions.add(action)
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

    override fun withTimeoutSeconds(value: Int): BubbleBuilder<I, B> {
        timeoutSeconds = value
        return this
    }
}