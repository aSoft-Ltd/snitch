import java.io.File

pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

listOf(
    "cinematic", "koncurrent", "kommander", "kevlar", "kase"
).forEach { includeBuild("../$it") }

rootProject.name = "snitch"

includeSubs("snitch", "../snitch", "api", "fake")
