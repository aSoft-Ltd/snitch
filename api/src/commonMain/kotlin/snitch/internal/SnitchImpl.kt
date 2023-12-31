package snitch.internal

import kollections.MutableList
import kollections.iMutableListOf
import kollections.toIMutableList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import cinematic.MutableLive
import cinematic.mutableLiveOf
import snitch.Bubble
import snitch.BubbleBuilder
import snitch.Snitch
import snitch.Type

internal class SnitchImpl : Snitch {
    override val bubbles: MutableLive<MutableList<Bubble<Any?, Any?>>> = mutableLiveOf(iMutableListOf())

    val scope = CoroutineScope(Dispatchers.Default)

    fun <I, B> show(bubble: Bubble<I, B>) {
        bubbles.value = (bubbles.value + bubble).toIMutableList()
        scope.launch {
            delay(bubble.timeoutSeconds * 1000L)
            close(bubble)
        }
    }

    fun close(bubble: Bubble<Any?, Any?>) = close(bubble.title)

    override fun close(title: String) {
        val found = bubbles.value.find { it.title == title } ?: return
        bubbles.value = (bubbles.value - found).toIMutableList()
    }

    override fun makeNewSuccess(title: String): BubbleBuilder<Any?, Any?> = BubbleBuilderImpl(title, Type.Success, this)
    override fun makeNewInfo(title: String): BubbleBuilder<Any?, Any?> = BubbleBuilderImpl(title, Type.Info, this)
    override fun makeNewWarning(title: String): BubbleBuilder<Any?, Any?> = BubbleBuilderImpl(title, Type.Warning, this)
    override fun makeNewError(title: String): BubbleBuilder<Any?, Any?> = BubbleBuilderImpl(title, Type.Error, this)
}