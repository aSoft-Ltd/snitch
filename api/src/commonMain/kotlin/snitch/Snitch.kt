@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package snitch

import kollections.List
import live.Live
import kotlin.js.JsExport

interface Snitch {

    val bubbles: Live<List<Bubble<Any?, Any?>>>

    fun makeNewSuccess(title: String): BubbleBuilder<Any?, Any?>

    fun makeNewInfo(title: String): BubbleBuilder<Any?, Any?>

    fun makeNewWarning(title: String): BubbleBuilder<Any?, Any?>

    fun makeNewError(title: String): BubbleBuilder<Any?, Any?>

    fun close(title: String)
}