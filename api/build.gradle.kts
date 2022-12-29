plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("org.jetbrains.dokka")
}

kotlin {
    jvm { library() }
    js(IR) { library() }

    sourceSets {
        val commonMain by getting {
            dependencies {
                compileOnly(kotlinx.serialization.core)
                api(projects.presentersActions)
                api(projects.liveCore)
                api(projects.actionsCore)
                api(kotlinx.coroutines.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(projects.expectCoroutines)
                implementation(projects.snitchFake)
                implementation(kotlinx.serialization.json)
            }
        }
    }
}
