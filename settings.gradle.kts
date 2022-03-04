rootProject.name = "thoribio framework"

listOf(
    "kotlin/multiplatform",
    "kotlin/ferret"
).forEach { project ->
    
    includeBuild(project)
}
