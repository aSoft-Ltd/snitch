package snitch

import snitch.internal.AbstractSnitch

class SnitchFake : AbstractSnitch() {
    override fun <I, B> show(bubble: Bubble<I, B>) {
        println("title: ${bubble.title}")
    }
}