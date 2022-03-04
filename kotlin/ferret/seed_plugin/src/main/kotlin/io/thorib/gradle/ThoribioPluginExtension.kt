package io.thorib.gradle

import io.thorib.gradle.model.ThoribioMetadata
import org.gradle.api.Project
import org.gradle.api.provider.Property
import javax.inject.Inject

/**
 * Thoribio plugin extension
 *
 * @constructor
 *
 * @param project
 */
abstract class ThoribioPluginExtension @Inject constructor(project : Project) {
    
    private val objects = project.objects
    
    val metadata : Property<ThoribioMetadata> = objects.property(
        ThoribioMetadata::class.java
    )
    
}
