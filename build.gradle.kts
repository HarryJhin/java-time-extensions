import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    kotlin("jvm") version "2.0.0"
    id("org.jetbrains.dokka") version "1.9.20"
    id("io.github.gradle-nexus.publish-plugin") version "2.0.0"
    `maven-publish`
    signing
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
                DokkaConfiguration.Visibility.PUBLIC,
                DokkaConfiguration.Visibility.PROTECTED
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
                    connection.set("scm:git:git://github.com/Hjson/java-time-extensions.git")
                    developerConnection.set("scm:git:ssh://github.com/Hjson/java-time-extensions.git")
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

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(System.getenv("SONATYPE_USERNAME"))
            password.set(System.getenv("SONATYPE_PASSWORD"))
        }
    }
}

signing {
    useInMemoryPgpKeys(
        System.getenv("GPG_SECRET_KEY"),
        System.getenv("GPG_PASSWORD"),
    )
    sign(publishing.publications)
}