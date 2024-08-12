import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    kotlin("jvm") version "2.0.0"
    id("org.jetbrains.dokka") version "1.9.20"
    id("org.jreleaser") version "1.13.1"
    `maven-publish`
    application
}

application {
    applicationName = "java-time-extensions"
}

group = "io.github.harryjhin"
version = "0.0.1"

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

java {
    withJavadocJar()
    withSourcesJar()
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

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set("java-time-extensions")
                description.set("Java Time Extensions")
                url.set("https://github.com/HarryJhin/java-time-extensions")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("harryjhin")
                        name.set("Harry Jhin")
                        email.set("joojinhyun00@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/HarryJhin/java-time-extensions.git")
                    developerConnection.set("scm:git:ssh://github.com/HarryJhin/java-time-extensions.git")
                    url.set("https://github.com/HarryJhin/java-time-extensions/tree/master")
                }
            }
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            artifacts {
                artifact(tasks["dokkaJavadocJar"])
                artifact(tasks.kotlinSourcesJar) {
                    classifier = "sources"
                }
            }
        }
    }
}

jreleaser {
    project {
        name = "java-time-extensions"
        version = "0.0.1"
        copyright = "2024 Harry Jhin"
        description = "Java Time Extensions"
        website = "harryjhin.github.io/java-time-extensions/"
        docsUrl = "harryjhin.github.io/java-time-extensions/"
        license = "MIT"
        authors = listOf("Harry Jhin")
    }
    release {
        github {
            repoOwner = "HarryJhin"
            token = System.getenv("GITHUB_TOKEN")
            overwrite = true
        }
    }
    distributions {
        create("app") {
            artifact {
                setPath("build/libs/java-time-extensions-0.0.1.jar")
            }
        }
    }
    signing {
        setActive("ALWAYS")
        armored = true
        publicKey = System.getenv("GPG_PUBLIC_KEY")
        secretKey = System.getenv("GPG_SECRET_KEY")
        passphrase = System.getenv("GPG_PASSPHRASE")
    }
    deploy {
//        version = "0.0.1"
        group = "io.github.harryjhin"
        maven {
            mavenCentral {
                create("sonatype") {
                    setActive("ALWAYS")
                    username = System.getenv("SONATYPE_USERNAME")
                    password = System.getenv("SONATYPE_PASSWORD")
                    url = "https://central.sonatype.com/api/v1/publisher"
                    stagingRepository("build/staging-deploy")
                }
            }
        }
    }
}