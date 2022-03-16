package io.thorib.gradle.model

import kotlinx.serialization.Serializable

/**
 * Thoribio common configuration
 *
 * @property plugins
 * @property artifacts
 * @constructor Create empty Thoribio common configuration
 */
@Serializable
data class ThoribioCommonConfiguration(
    val artifacts : List<Artifact> = emptyList()
)


/**
 * Artifact
 *
 * @property configurationName
 * @property dependencyNotation
 * @property enabled
 * @constructor Create empty Artifact
 */
@Serializable
data class Artifact(
    val configurationName : String ,
    val dependencyNotation : String ,
    val enabled : Boolean
)
