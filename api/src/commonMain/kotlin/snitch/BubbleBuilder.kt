@file:JsExport

package snitch

import kotlin.js.JsExport

interface BubbleBuilder<I, B> {
    fun show()
    fun on(action: String, handler: () -> Unit): BubbleBuilder<I, B>
    fun withIcon(i: I): BubbleBuilder<I, B>
    fun withBody(b: B): BubbleBuilder<I, B>
}