plugins {
    id("java")
    id("application")
}

group = "ru.alfabank"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Source: https://mvnrepository.com/artifact/net.datafaker/datafaker
    implementation("net.datafaker:datafaker:2.5.4")

    // Source: https://mvnrepository.com/artifact/com.github.lalyos/jfiglet
    implementation("com.github.lalyos:jfiglet:0.0.8")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("ru.alfabank.hw.hw10.Main")
}

// Настройки для кодировки
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<JavaExec>().configureEach {
    systemProperty("file.encoding", "UTF-8")
    systemProperty("console.encoding", "UTF-8")
    systemProperty("stdout.encoding", "UTF-8")
}

// Настройка для чистого вывода
tasks.named<JavaExec>("run") {
    // Выключаем логи Gradle уровня INFO и ниже
    logging.captureStandardOutput(LogLevel.QUIET)
    logging.captureStandardError(LogLevel.QUIET)
}