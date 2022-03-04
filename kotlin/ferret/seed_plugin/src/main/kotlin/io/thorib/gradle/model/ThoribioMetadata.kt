package io.thorib.gradle.model

/**
 * Thoribio metadata
 *
 * @property developer
 * @property artifact
 * @constructor Create empty Thoribio metadata
 */
data class ThoribioMetadata(
    val developer : ThoribioDeveloper = ThoribioDeveloper() ,
    val artifact : ThoribioArtifact ,
)
