package snitch

import snitch.internal.SnitchImpl
import kotlin.js.JsName

@JsName("makeSnitch")
fun Snitch(): Snitch = SnitchImpl()