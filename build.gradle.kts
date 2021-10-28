
plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

allprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
        testImplementation("junit:junit:4.12");
        testImplementation("org.mockito:mockito-core:2.24.0")
        testImplementation("org.hamcrest:hamcrest-all:1.3")
        compileOnly ("org.projectlombok:lombok:1.18.20")
        compileOnly ("org.jetbrains:annotations:16.0.2")
        implementation("com.google.inject:guice:5.0.1")
        annotationProcessor("org.projectlombok:lombok:1.18.20")
        implementation ("com.google.code.gson:gson:2.8.5")
    }
}

repositories {
    mavenCentral()
}

