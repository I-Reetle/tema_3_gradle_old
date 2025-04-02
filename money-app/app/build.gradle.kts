plugins {
    kotlin("jvm")
    application
}

dependencies {
    implementation(project(":greeter-library"))
    implementation("com.example.money:money-library:1.0")
}

application {
    mainClass.set("AppKt")
}

repositories {
    maven {
        url = uri("../mvn-repo")  // Путь к локальному репозиторию
    }
    mavenCentral()
}