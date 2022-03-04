package io.thorib.gradle

import io.thorib.gradle.model.ThoribioMetadata
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.publish.maven.tasks.AbstractPublishToMaven
import org.gradle.api.tasks.*
import org.gradle.api.tasks.options.Option

/**
 * Thoribio configuration task
 *
 * @constructor Create empty Thoribio configuration task
 */
abstract class ThoribioConfigurationTask : DefaultTask() {
    
    init {
        description = """provide unified common properties for
      
            |
            |'maven-plugin' :
            |   [group]
            |   [version]
            |   [developer.name]
            |   [developer.email]
            |   [developer.organization]
            |
            |'multiplatform' -> todo
            |'dokka' -> todo
            |""".trimMargin()
        group = "Thoribio"
    }
    
    
    @get:Input
    @get:Option(
        option = "metadata" ,
        description = "add common Metadata"
    )
    @get:Optional
    abstract val metadata : Property<ThoribioMetadata>
    
    
    /**
     * Sample action
     *
     */
    @TaskAction
    fun sampleAction() {
        group = metadata.get().artifact.group.value
        
//        version = metadata..artifact.version
//
//        tasks.withType(AbstractPublishToMaven::class.java).configureEach{ publicationTask ->
//            publicationTask.publication.run {
//                version =
//                        artifactId
//                groupId
//
//            }
//        }
        logger.lifecycle(metadata.get().toString())
    }
}
