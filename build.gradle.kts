import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    kotlin("jvm") version "2.0.0"
    id("org.jetbrains.dokka") version "1.9.20"
    id("org.jreleaser") version "1.13.1"
    `java-library`
    `maven-publish`
}

val groupId: String by project
val version: String by project

project.description = "Kotlin을 위한 java.time.* 확장 함수 라이브러리"
project.group = "io.github.harryjhin"
project.version = "0.0.7"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

tasks.withType<DokkaTask>().configureEach {
    outputDirectory.set(file("docs"))

    dokkaSourceSets.configureEach {
        documentedVisibilities.set(
            setOf(
                DokkaConfiguration.Visibility.PUBLIC, DokkaConfiguration.Visibility.PROTECTED
            )
        )

        sourceLink {
            localDirectory.set(file("src/main/kotlin"))
            remoteUrl.set(URL("https://github.com/HarryJhin/java-time-extensions/blob/master/src/main/kotlin"))
            remoteLineSuffix.set("#L")
        }
    }
}

tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
    archiveClassifier.set("html-docs")
}

tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}

tasks.jar {
    dependsOn(tasks.named("dokkaJavadocJar"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("java-time-extensions")
                description.set("Java Time Extensions")
                url.set("https://github.com/HarryJhin/java-time-extensions")
                inceptionYear.set("2024")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("HarryJhin")
                        name.set("HarryJhin")
                        email.set("joojinhyun00@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git://github.com/HarryJhin/java-time-extensions.git")
                    developerConnection.set("scm:git:ssh://github.com/HarryJhin/java-time-extensions.git")
                    url.set("https://github.com/HarryJhin/java-time-extensions/tree/master")
                }
            }
        }
    }

    repositories {
        maven {
            setUrl(layout.buildDirectory.dir("staging-deploy"))
        }
    }
}

jreleaser {
    signing {
        setActive("ALWAYS")
        armored = true
    }
    deploy {
        maven {
            mavenCentral {
                create("sonatype") {
                    url = "https://central.sonatype.com/api/v1/publisher"
                    stagingRepository(layout.buildDirectory.dir("staging-deploy").get().toString())
                }
            }
        }
    }
    release {
        github {
            repoOwner = "HarryJhin"
            host = "github.com"
            overwrite = false
            update {
                enabled = false
            }
        }
    }
}