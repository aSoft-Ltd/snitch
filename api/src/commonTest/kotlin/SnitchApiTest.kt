import koncurrent.SynchronousExecutor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import cinematic.watch
import snitch.Snitch
import snitch.toDetailedString
import kotlin.test.Test

class SnitchApiTest {
    val toaster: Snitch = Snitch()

    @Test
    fun should_be_able_to__easily_construct_a_bubble() {
        val builder = toaster.makeNewInfo("Customer Created")
        builder.show()
    }

    @Test
    fun should_be_able_to__easily_construct_a_bubble_with_actions() = runTest {
        var bubbleNotifications = 0
        val watcher = toaster.bubbles.watch(SynchronousExecutor) { bubbles ->
            bubbleNotifications++
            println("Bubble notifications: $bubbleNotifications")
            println("Bubble size: ${bubbles.size}")
            bubbles.forEach { println(it.toDetailedString()) }
        }

        toaster.makeNewInfo("Customer Created")
            .withBody("Check this shit out")
            .on("View") {
                println("Viewing")
            }.on("Close") {
                println("Closing")
            }.withIcon("+").show()

        toaster.close("Customer Created")
        watcher.stop()
    }

    @Test
    fun should_be_able_to_self_close_automagically() = runTest {
        var bubbleNotifications = 0
        val watcher = toaster.bubbles.watch(SynchronousExecutor) { bubbles ->
            bubbleNotifications++
            println("Bubble notifications: $bubbleNotifications")
            println("Bubble size: ${bubbles.size}")
            bubbles.forEach { println(it.toDetailedString()) }
        }

        toaster.makeNewInfo("Customer Created")
            .withBody("Check this shit out")
            .withTimeoutSeconds(1)
            .on("View") {
                println("Viewing")
            }.on("Close") {
                println("Closing")
            }.withIcon("+").show()

        withContext(Dispatchers.Default) { delay(2000) }
        watcher.stop()
    }
}