@file:JsExport

package snitch

import actions.ActionsBuilder
import kotlin.js.JsExport

abstract class BubbleBuilder<I, B> : ActionsBuilder<BubbleBuilder<I, B>, () -> Unit>() {
    abstract fun show()
    abstract fun withIcon(i: I): BubbleBuilder<I, B>
    abstract fun withBody(b: B): BubbleBuilder<I, B>
    abstract fun withTimeoutSeconds(value: Int): BubbleBuilder<I, B>
}