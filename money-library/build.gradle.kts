plugins {
	java
	`maven-publish`
}


group = "com.practicalunittesting.chp03.money"
version = "1.0"      

repositories {
	mavenCentral()
}

// Настройка публикации
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])  // Публикуем JAR-артефакт
            // Дополнительные метаданные (опционально)
            pom {
                name.set("Money Library")
                description.set("A library for monetary operations")
                url.set("http://example.com")
            }
        }
    }
    repositories {
        maven {
            url = uri("../mvn-repo")  // Относительный путь к локальному репозиторию
        }
    }
}

dependencies {
	testImplementation("org.assertj:assertj-core:3.6.1")
	implementation("com.google.guava:guava:33.4.6-jre")
	testImplementation(platform("org.junit:junit-bom:5.12.1"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}