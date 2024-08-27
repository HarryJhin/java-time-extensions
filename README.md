[![Deploy static content to Pages](https://github.com/HarryJhin/java-time-extensions/actions/workflows/static.yml/badge.svg)](https://github.com/HarryJhin/java-time-extensions/actions/workflows/static.yml)
[![CI](https://github.com/HarryJhin/java-time-extensions/actions/workflows/ci.yml/badge.svg)](https://github.com/HarryJhin/java-time-extensions/actions/workflows/ci.yml)
[![Publish to Sonatype](https://github.com/HarryJhin/java-time-extensions/actions/workflows/publish.yml/badge.svg)](https://github.com/HarryJhin/java-time-extensions/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.harryjhin/java-time-extensions.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.harryjhin/java-time-extensions)
[![Kotlin](https://img.shields.io/badge/kotlin-2.0.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![KDoc link](https://img.shields.io/badge/API_reference-KDoc-blue)](https://harryjhin.github.io/java-time-extensions/)
[![License](https://img.shields.io/github/license/HarryJhin/java-time-extensions)](https://opensource.org/licenses/MIT)

# Kotlin용 java.time.* 확장 라이브러리

`java-time-extensions`는 `java.time.*` 패키지의 자주 사용되는 기능을 확장하여, `kotlin` 사용자에게 유의미한 경험을 제공합니다.

기능 사용법은 [Wiki](https://github.com/HarryJhin/java-time-extensions/wiki)를 참조하세요.

## kotlinx-datetime 비교

`kotilnx-datetime` 라이브러리는 사람들이 시간에 대해 이야기할 때 사용하는 로컬 시간대(UTC+9 등)를 전제로 하는 시민 시간을 구분짓고 있습니다.  
즉, 라이브러리에서 제공하는 엔티티는 시간대 정보를 반드시 포함하고 있습니다.
단, 한 달 더하기와 같은 시간대 정보가 불필요한 편의 연산은 제공합니다.

`java-time-extensions` 라이브러리는 `kotlinx-datetime` 라이브러리와 비슷한 기능을 일부 제공합니다.
그러나 `kotlinx-datetime` 라이브러리에서 제공하는 API는 최소한의 사용 사례를 충족시키기 위해 표준에 가깝게 설계되었습니다.
반면, `java-time-extensions` 라이브러리는 최대한 많은 사용 사례를 충족시키기 위해 설계되었습니다.
또한, `java.time.*` 패키지를 확장하는 것이 목적이므로, 별도로 구현된 엔티티를 제공하지 않습니다.

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