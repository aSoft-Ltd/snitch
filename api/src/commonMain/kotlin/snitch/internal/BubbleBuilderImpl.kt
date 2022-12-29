package snitch.internal

import actions.Action0I1R
import actions.ActionsBuilder
import actions.action0I0R
import actions.action0I1R
import kotlinx.collections.interoperable.iMutableListOf
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

    private var actions = iMutableListOf<Action0I1R<Unit>>()

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
        val action = action0I0R(name, handler)
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