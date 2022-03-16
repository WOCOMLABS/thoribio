import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val thoribioPluginVersion : String by project

plugins {
    id("org.gradle.java-gradle-plugin")
    id("org.gradle.maven-publish")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
}

group = "io.thorib.gradle"
version = thoribioPluginVersion

gradlePlugin {
    
    val thoribioCommon by plugins.creating {
        id = "io.thorib.base.plugin"
        implementationClass = "io.thorib.gradle.ThoribioPlugin"
    }
    
}

// common dependencies
val kotlinVersion : String by project
val ktorVersion : String by project
val kermitVersion : String by project
val kotlinxDatetimeVersion : String by project
val kotlinxSerializationJsonVersion : String by project
//common plugins
val kotlinGradlePluginVersion : String by project
val kotlinxSerializationPluginVersion : String by project
val taskInfoPluginVersion : String by project
val androidPluginVersion : String by project

dependencies {
    // Common plugins
    listOf(
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinGradlePluginVersion}" ,
        "org.jetbrains.kotlin:kotlin-serialization:${kotlinxSerializationPluginVersion}" ,
        "gradle.plugin.org.barfuin.gradle.taskinfo:gradle-taskinfo:${taskInfoPluginVersion}" ,
        "com.android.tools.build:gradle:${androidPluginVersion}" ,
        "com.android.library:com.android.library.gradle.plugin:${androidPluginVersion}" ,
        "org.gradle.kotlin.kotlin-dsl:org.gradle.kotlin.kotlin-dsl.gradle.plugin:2.2.0"
    ).forEach { dependencyNotation ->
        logger.lifecycle("[use plugin]  : $dependencyNotation")
        api(dependencyNotation)
    }
    // Common libraries
    listOf(
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}" ,
        "io.ktor:ktor-client-core:${ktorVersion}" ,
        "co.touchlab:kermit:${kermitVersion}" ,
        "org.jetbrains.kotlinx:kotlinx-datetime:${kotlinxDatetimeVersion}" ,
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${kotlinxSerializationJsonVersion}" ,
        "org.jetbrains.kotlinx:kotlinx-serialization-hocon:${kotlinxSerializationJsonVersion}" ,
    ).forEach { dependencyNotation ->
        logger.lifecycle("[use library] : $dependencyNotation")
        api(dependencyNotation)
    }
    
}

java {
    
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.majorVersion
    }
}
