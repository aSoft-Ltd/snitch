@file:JsExport

package snitch

import presenters.actions.ActionsBuilder
import kotlin.js.JsExport

interface BubbleBuilder<I, B> : ActionsBuilder<BubbleBuilder<I, B>, () -> Unit> {
    fun show()
    fun withIcon(i: I): BubbleBuilder<I, B>
    fun withBody(b: B): BubbleBuilder<I, B>
    fun withTimeoutSeconds(value: Int): BubbleBuilder<I, B>
}