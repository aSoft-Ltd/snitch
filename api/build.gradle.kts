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
                api(libs.cinematic.live.core)
                api(libs.kevlar.core)
                api(kotlinx.coroutines.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kommander.coroutines)
                implementation(projects.snitchFake)
                implementation(kotlinx.serialization.json)
            }
        }
    }
}
