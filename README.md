[![Deploy static content to Pages](https://github.com/HarryJhin/java-time-extensions/actions/workflows/static.yml/badge.svg)](https://github.com/HarryJhin/java-time-extensions/actions/workflows/static.yml)
[![CI](https://github.com/HarryJhin/java-time-extensions/actions/workflows/ci.yml/badge.svg)](https://github.com/HarryJhin/java-time-extensions/actions/workflows/ci.yml)
[![Publish to Sonatype](https://github.com/HarryJhin/java-time-extensions/actions/workflows/publish.yml/badge.svg)](https://github.com/HarryJhin/java-time-extensions/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.harryjhin/java-time-extensions.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.harryjhin/java-time-extensions)

# Kotlin용 java.time.* 확장 라이브러리

`java-time-extensions`는 `java.time.*` 패키지의 자주 사용되는 기능을 확장하여, `kotlin` 사용자에게 유의미한 경험을 제공합니다.

기능 사용법은 [Wiki](https://github.com/HarryJhin/java-time-extensions/wiki)를 참조하세요.

## Gradle 설정

### build.gradle

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.harryjhin:java-time-extensions:$version'
}
```

### build.gradle.kts

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.harryjhin:java-time-extensions:$version")
}
```

## License

라이센스 권한 및 제한사항은 [LICENSE](LICENSE) 파일을 참조하세요 (MIT).