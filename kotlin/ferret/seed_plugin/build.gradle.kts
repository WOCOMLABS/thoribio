plugins {
    id("org.gradle.java-gradle-plugin")
    id("org.gradle.maven-publish")
    id("org.jetbrains.kotlin.jvm")
    id("org.barfuin.gradle.taskinfo")
}

group = "io.thorib.gradle"
version = "0.1.12-SNAPSHOT"

gradlePlugin {
    
    val thoribio by plugins.creating {
        id = "io.thorib.base.plugin"
        implementationClass = "io.thorib.gradle.ThoribioPlugin"
    }
    
}

dependencies {
    
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    implementation("gradle.plugin.org.barfuin.gradle.taskinfo:gradle-taskinfo:1.3.1")
    
}

java {
    
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    
}
