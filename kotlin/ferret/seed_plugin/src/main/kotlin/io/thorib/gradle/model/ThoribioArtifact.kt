package io.thorib.gradle.model

/**
 * Thoribio artifact group
 *
 * @property value
 * @constructor Create empty Thoribio artifact group
 */
@JvmInline
value class ThoribioArtifactGroup(val value : String)


/**
 * Thoribio artifact version
 *
 * @property value
 * @constructor Create empty Thoribio artifact version
 */
@JvmInline
value class ThoribioArtifactVersion(val value : String)


/**
 * Thoribio artifact
 *
 * @property group
 * @property version
 * @constructor Create empty Thoribio artifact
 */
data class ThoribioArtifact(
    val group : ThoribioArtifactGroup = ThoribioArtifactGroup("io.thorib") ,
    val version : ThoribioArtifactVersion
)
