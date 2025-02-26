pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://glassbox.jfrog.io/artifactory/Glassbox-Android-Sdk")


    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://glassbox.jfrog.io/artifactory/Glassbox-Android-Sdk")
    }
}

rootProject.name = "GlassboxDynatraceBug"
include(":app")
 