rootProject.name = "platform specific plugins"

pluginManagement {
    
    val thoribioPluginVersion : String by settings

    repositories {
      
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
    }
    
    plugins {
        id("io.thorib.base.plugin") version thoribioPluginVersion
    }
    
}

dependencyResolutionManagement {
   
    repositories {
       
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
        
    }
}



include (
    ":android_plugin",
    ":bff_plugin",
    //":web"
    //":desktop"
    //":linux"
    //":cli"
    //":macos"
    //":ios"
)
