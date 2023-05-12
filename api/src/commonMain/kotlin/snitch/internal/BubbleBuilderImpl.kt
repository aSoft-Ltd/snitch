package snitch.internal

import kevlar.Action0
import kevlar.ActionsBuilder
import kevlar.action0
import kollections.List
import kollections.iMutableListOf
import kollections.toIList
import snitch.Bubble
import snitch.BubbleBuilder
import snitch.Type

internal class BubbleBuilderImpl<I, B>(
    val title: String,
    val type: Type,
    val snitch: SnitchImpl
) : BubbleBuilder<I, B>() {
    private var icon: I? = null
    private var body: B? = null
    private var timeoutSeconds = Bubble.DEFAULT_TIMEOUT_SECONDS

    private var actions = iMutableListOf<Action0<Unit>>()

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

    override fun on(name: String, key: String, handler: () -> Unit): BubbleBuilder<I, B> {
        val action = action0(name, key, handler)
        actions.add(action)
        return this
    }

    override fun sub(name: String, key: String, builder: ActionsBuilder<BubbleBuilder<I, B>, () -> Unit>.() -> Unit) {
        val subBuilder = BubbleBuilderImpl<I, B>(title, type, snitch).apply(builder)
        actions.add(action0(name, key, subBuilder.actions))
    }

    override fun sub(name: String, key: String, actions: List<BubbleBuilder<I, B>>) {

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