[![Deploy static content to Pages](https://github.com/HarryJhin/java-time-extensions/actions/workflows/static.yml/badge.svg)](https://github.com/HarryJhin/java-time-extensions/actions/workflows/static.yml)
[![CI](https://github.com/HarryJhin/java-time-extensions/actions/workflows/ci.yml/badge.svg)](https://github.com/HarryJhin/java-time-extensions/actions/workflows/ci.yml)
[![Publish to Sonatype](https://github.com/HarryJhin/java-time-extensions/actions/workflows/publish.yml/badge.svg)](https://github.com/HarryJhin/java-time-extensions/actions/workflows/publish.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.harryjhin/java-time-extensions.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.harryjhin/java-time-extensions)
[![Kotlin](https://img.shields.io/badge/kotlin-2.0.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![KDoc link](https://img.shields.io/badge/API_reference-KDoc-blue)](https://harryjhin.github.io/java-time-extensions/)
[![License](https://img.shields.io/github/license/HarryJhin/java-time-extensions)](https://opensource.org/licenses/MIT)

# Kotlin용 java.time.* 확장 라이브러리

`java-time-extensions`는 `java.time.*` 패키지를 확장하여 Kotlin 사용자에게 더 편리한 기능을 제공합니다.
이 라이브러리는 Kotlin 개발자들이 `java.time.*` API를 사용할 때 자주 필요한 기능을 쉽게 사용할 수 있도록 도와줍니다.

사용 예시는 [Wiki](https://github.com/HarryJhin/java-time-extensions/wiki)를 참조하세요.

## 주요 특징

`java-time-extensions`는 Kotlin 사용자들에게 `java.time.*` 패키지의 다양한 클래스(`LocalDate`, `LocalTime`, `LocalDateTime` 등)를
확장하여 더욱 편리하게 사용할 수 있도록 돕는 라이브러리입니다.
이 라이브러리는 확장 함수와 확장 프로퍼티를 통해 기존 API를 간편하게 확장하여 사용할 수 있는 기능을 제공합니다.

주요 기능들은 다음과 같습니다:

- **다양한 날짜 및 시간 타입 확장**: `java.time.*` 패키지의 여러 클래스에 대한 유용한 확장 기능을 제공합니다.
- **편리한 인스턴스 생성**: `String`, `Int`, `Long` 등의 다양한 타입으로부터 쉽게 인스턴스를 생성할 수 있습니다.
- **유연한 타입 변환**: 날짜 및 시간 인스턴스를 다른 타입으로 쉽게 변환할 수 있도록 도와줍니다.
- **Safety 타입 변환**: 다양한 타입 변환 함수들은 예외를 던지지 않고 `null`을 반환할 수 있도록 지원합니다.
- **직관적인 중위 함수**: `LocalDate`와 `LocalTime`을 결합하여 `LocalDateTime`을 만들거나,
두 `LocalDate` 인스턴스 간의 차이를 계산하는 등, 기존 메서드를 사용하는 것보다 직관적인 문법을 제공합니다.

## kotlinx-datetime 비교

`kotlinx-datetime`은 시간대를 포함한 civil time(상용시)을 다루는데 특화된 라이브러리입니다.
예를 들어, kotlinx-datetime은 모든 시간 객체에 시간대 정보를 포함시키며,
이를 통해 로컬 시간대(예: UTC+9)와 관련된 작업을 쉽게 처리할 수 있습니다.
이 라이브러리는 시간대 정보가 필요하지 않은 단순한 연산(예: 한 달 더하기)도 지원합니다.

반면, `java-time-extensions`는 `java.time.*` 패키지를 기반으로 하여,
기존의 API를 더 편리하게 사용할 수 있도록 돕는 확장 기능을 제공합니다.
`kotlinx-datetime`처럼 새로운 엔티티나 시간대에 대한 복잡한 처리를 추가하지는 않습니다.
대신, `java.time.*` 패키지를 사용하는 **Kotlin 사용자**들이 더 쉽게 날짜와 시간을 다룰 수 있도록 하는 것이 이 라이브러리의 주된 목적입니다.

따라서 `java-time-extensions`는 `kotlinx-datetime`을 대체하기 위한 것이 아니라,
이미 `java.time.*`을 사용하고 있는 Kotlin 개발자들에게 **더 나은 개발 경험을 제공**하는 데 초점을 맞추고 있습니다.

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