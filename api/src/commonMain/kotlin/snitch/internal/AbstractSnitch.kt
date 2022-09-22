package snitch.internal

import snitch.BubbleBuilder
import snitch.Snitch

abstract class AbstractSnitch : Snitch {
    override fun makeNew(title: String): BubbleBuilder<Any?, Any?> = BubbleBuilderImpl(title, this)
}