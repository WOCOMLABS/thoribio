rootProject.name = "seed"

pluginManagement {
    
    val kotlinVersion : String by settings
    val kotlinxSerializationPluginVersion : String by settings
    
    repositories {
        
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
        
    }
    
    plugins {
        
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.serialization") version kotlinxSerializationPluginVersion
        
    }
}


dependencyResolutionManagement {
    
    repositories {
        
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
        
    }
    
}


include (
    ":seed",
)
