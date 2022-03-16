package io.thorib.gradle.extension

import groovy.lang.Closure
import io.thorib.gradle.ThoribioPlugin
import io.thorib.gradle.model.ThoribioCommonConfiguration
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import org.gradle.api.Action
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension
import java.io.File


/**
 * Fetch common configuration file
 *
 * @return
 */
fun Project.fetchCommonConfigurationFile() : String = fetchFile(
    // TODO: 3/15/2022 experiment with HOCON format :)
    "__thoribioCommonConfiguration__.json"
)


/**
 * Fetch file
 *
 * @param file
 * @return
 */
fun Project.fetchFile(file : String) : String = run {
    
    val filePath = "${projectDir}\\$file"
    if (file(filePath).exists()) {
        file(filePath).readText()
    } else {
        
        val jsonString = ThoribioPlugin::class.java
            .classLoader
            .getResource(file)
            ?.readText() ?: "{}"
        
        File(projectDir , file).writeText(jsonString)
        jsonString
        
    }
}


/**
 * Configure multi platform
 *
 */
fun Project.configureMultiPlatform() {
   
    json.decodeFromString<ThoribioCommonConfiguration>(
        fetchCommonConfigurationFile()
    ).artifacts
        .filter { dep -> dep.enabled }
        .forEach { (configurationName , dependencyNotation , _) ->
            
            ferret.i { "$configurationName(\"$dependencyNotation\")" }
            dependencies.add(
                configurationName ,
                dependencies.create(dependencyNotation)
            )
            
        }
    
    (kotlinExtension as KotlinMultiplatformExtension).run {
        
        jvm()
        js(IR) {
            browser()
            nodejs()
        }
        
        sourceSets.run {
            
            val commonMain = maybeCreate("commonMain")
            val jvmMain = maybeCreate("jvmMain")
            val jsMain = maybeCreate("jsMain")
            
            
            jvmMain.dependsOn(commonMain)
            jsMain.dependsOn(commonMain)
            
            
            val commonTest = maybeCreate("commonTest")
            val jvmTest = maybeCreate("jvmTest")
            val jsTest = maybeCreate("jsTest")
            
            
            jvmTest.dependsOn(commonTest)
            jsTest.dependsOn(commonTest)
            
        }
        
        
    }
}
