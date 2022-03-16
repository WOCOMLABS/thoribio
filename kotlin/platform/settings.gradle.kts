rootProject.name = "sdk"

pluginManagement {
    
    val thoribioPluginVersion : String by settings
    
    repositories {
        
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
        
    }
    
    plugins {
        
        id("io.thorib.base.plugin") version thoribioPluginVersion
        
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


include(
    // TODO: 3/16/2022 uncomment this after running  seed publicToMavenLocal
    //":sdk" ,
)
