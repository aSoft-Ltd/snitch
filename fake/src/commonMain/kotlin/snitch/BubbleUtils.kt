package snitch

fun Bubble<Any?, Any?>.toDetailedString() = StringBuilder().apply {
    appendLine("[${type.name} Bubble]")
    appendLine("Title: $title")
    if (body != null) {
        appendLine("Body: $body")
    }
    if (actions.isNotEmpty()) {
        append("Actions: ")
        appendLine(actions.joinToString(prefix = "[", separator = ",", postfix = "]") { it.name })
    }
    appendLine()
}