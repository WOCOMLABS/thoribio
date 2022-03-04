package io.thorib.gradle

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.tasks.AbstractPublishToMaven
import org.gradle.jvm.tasks.Jar


/**
 * Thoribio plugin
 *
 * @constructor Create empty Thoribio plugin
 */
@Suppress("unused")
class ThoribioPlugin : Plugin<Project> {
    
    
    override fun apply(project : Project) = project.run {
        // TODO: 3/3/2022 bring these from json || hocon || yml
        // kotlinx serialization|datetime|
        // https://discuss.kotlinlang.org/t/uuid-for-kotlin-multiplatform/21925
        // kotlin poet
        // kotlin cli ( maybe in the jvm plugin )
        // ktor !!
        listOf(
            "base",
            "org.gradle.java-gradle-plugin" ,
            "org.jetbrains.kotlin.jvm" ,
            "org.gradle.maven-publish",
            "org.barfuin.gradle.taskinfo"
        ).forEach { plugin ->
            pluginManager.apply(plugin)
        }
        
        with(repositories){
            add(mavenLocal())
            add(mavenCentral())
            add(gradlePluginPortal())
            
        }
        val extension = extensions.create(
            EXTENSION_NAME ,
            ThoribioPluginExtension::class.java ,
            project
        )
        // this task does nothing I'll
        tasks.register(
            TASK_NAME ,
            ThoribioConfigurationTask::class.java
        ) { task ->
            task.metadata.set(extension.metadata)
        }
        
        
        Unit
    }
    
    
    companion object {
        
        const val EXTENSION_NAME = "thoribio"
        const val TASK_NAME = "thoribioConfiguration"
        
    }
}
