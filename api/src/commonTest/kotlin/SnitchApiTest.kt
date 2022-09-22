import snitch.Snitch
import snitch.SnitchFake
import kotlin.test.Test

class SnitchApiTest {
    val toaster: Snitch = SnitchFake()

    @Test
    fun should_be_able_to__easily_construct_a_bubble() {
        val builder = toaster.makeNew("Customer Created")
        builder.show()
    }

    @Test
    fun should_be_able_to__easily_construct_a_bubble_with_actions() {
        toaster.makeNew("Costomer Created")
            .on("View") {
                println("Viewing")
            }.on("Close") {
                println("Closing")
            }.withIcon("+").show()
    }
}