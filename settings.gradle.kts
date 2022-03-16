rootProject.name = "thoribio"

listOf(
    "kotlin/platform",
    "kotlin/seed"
).forEach { project ->
    
    includeBuild(project)
    
}
