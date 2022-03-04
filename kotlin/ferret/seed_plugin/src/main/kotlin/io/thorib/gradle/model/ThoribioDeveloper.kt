package io.thorib.gradle.model

/**
 * Developer name
 *
 * @property value
 * @constructor Create empty Developer name
 */
@JvmInline
value class DeveloperName(val value : String)


/**
 * Developer email
 *
 * @property value
 * @constructor Create empty Developer email
 */
@JvmInline
value class DeveloperEmail(val value : String)


/**
 * Developer organization
 *
 * @property value
 * @constructor Create empty Developer organization
 */
@JvmInline
value class DeveloperOrganization(val value : String)


/**
 * Thoribio developer
 *
 * @property name
 * @property email
 * @property organization
 * @constructor Create empty Thoribio developer
 */
data class ThoribioDeveloper(
    val name : DeveloperName  = DeveloperName("Thoribio San") ,
    val email : DeveloperEmail = DeveloperEmail("developer@thorib.io") ,
    val organization : DeveloperOrganization = DeveloperOrganization("Thoribio Framework") ,
)
