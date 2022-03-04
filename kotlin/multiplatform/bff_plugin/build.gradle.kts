import io.thorib.gradle.model.*

plugins {
    id("io.thorib.base.plugin")
}

thoribio {
    metadata.set(
        ThoribioMetadata(
            developer = ThoribioDeveloper() ,
            artifact = ThoribioArtifact(
                group = ThoribioArtifactGroup("io.thorib.bff"),
                version = ThoribioArtifactVersion("0.1.0-SNAPSHOP")
            )
        )
    )
    
}
