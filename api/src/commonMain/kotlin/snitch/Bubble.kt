@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package snitch

import kevlar.Action0
import kollections.List
import kotlin.js.JsExport

data class Bubble<out I, out B>(
    val title: String,
    val icon: I,
    val body: B,
    val timeoutSeconds: Int,
    val type: Type,
    val actions: List<Action0<Unit>>,
) {
    companion object {
        val DEFAULT_TYPE = Type.Info
        val DEFAULT_TIMEOUT_SECONDS = 5
    }
}