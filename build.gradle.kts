plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("junit:junit:5");
    testImplementation("org.mockito:mockito-core:2.24.0")
    compileOnly ("org.projectlombok:lombok:1.18.20")
    compileOnly ("org.jetbrains:annotations:16.0.2")
    implementation("com.google.inject:guice:5.0.1")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
    implementation ("com.google.code.gson:gson:2.8.5")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}