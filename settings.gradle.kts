pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Payments App"
include(":app")
include(":core:designsystem")
include(":core:network")
include(":core:presentation")
include(":feature:auth:impl")
include(":feature:auth:api")
include(":feature:payments")
