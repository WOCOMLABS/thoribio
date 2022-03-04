rootProject.name = "seed plugin"

pluginManagement {
    
    val kotlinVersion : String by settings
    val taskInfoVersion : String by settings
    
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
    
    plugins {
        base
        kotlin("jvm") version kotlinVersion
        id("org.barfuin.gradle.taskinfo") version taskInfoVersion
    }
    
}


dependencyResolutionManagement {
    
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
    
}


include (
    ":seed_plugin",
)
