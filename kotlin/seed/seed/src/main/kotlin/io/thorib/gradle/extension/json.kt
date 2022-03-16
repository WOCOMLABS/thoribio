package io.thorib.gradle.extension

import kotlinx.serialization.json.Json

val json = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
}
