@file:JsExport

package snitch

import kotlin.js.JsExport

data class Bubble<out I, out B>(
    val title: String,
    val icon: I,
    val body: B,
    val actions: List<Any>,
)