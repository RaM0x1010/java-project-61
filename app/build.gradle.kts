plugins {
    id("com.github.ben-manes.versions") version ("0.52.0")
    id("org.sonarqube") version "6.2.0.5505"
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "RaM0x1010_java-project-61")
        property("sonar.organization", "ram0x1010")
    }
}
