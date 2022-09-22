@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package snitch

import kotlin.js.JsExport

interface Snitch {
    fun makeNew(title: String): BubbleBuilder<Any?, Any?>
    fun <I, B> show(builder: Bubble<I, B>)
}