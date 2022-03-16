package io.thorib.gradle

import io.thorib.gradle.extension.*
import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.Instant
import kotlinx.serialization.encodeToString
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.jetbrains.kotlin.gradle.plugin.*
import org.jetbrains.kotlinx.serialization.gradle.SerializationGradleSubplugin
import org.barfuin.gradle.taskinfo.GradleTaskInfoPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


/**
 * Thoribio plugin
 *
 * @constructor Create empty Thoribio plugin
 */
@Suppress("unused")
class ThoribioPlugin : Plugin<Project> {
    
    
    override fun apply(project : Project) = project.run {
        
        val start : Instant = now()
        
        repositories.run {
            
            add(mavenCentral())
            add(google())
            add(gradlePluginPortal())
            add(mavenLocal())
        }
        
        repositories.asMap.forEach { (key , _) -> ferret.i { "[Repository] $key" } }
        
        listOf(
            MavenPublishPlugin::class.java ,
            //LibraryPlugin::class.java ,
            KotlinMultiplatformPluginWrapper::class.java ,
            //https://github.com/JetBrains/kotlin/blob/master/libraries/tools/kotlin-gradle-plugin/build.gradle.kts
            SerializationGradleSubplugin::class.java ,
            GradleTaskInfoPlugin::class.java ,
        ).forEach { plugin ->
            ferret.i { "[Enabled Plugin] ${plugin.simpleName}" }
            pluginManager.apply(plugin)
        }
        
        ferret.i {
            "[ConfigurationNames] ${
                json.encodeToString<Set<String>>(
                    configurations.asMap.keys
                )
            }"
        }
        configureMultiPlatform()
        
        tasks.withType(KotlinCompile::class.java) { kotlinCompile ->
            kotlinCompile.kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        
        ferret.i { "[Common Benchmark] ${(now().toEpochMilliseconds() - start.toEpochMilliseconds())} ms" }
        
    }
    
    
}
