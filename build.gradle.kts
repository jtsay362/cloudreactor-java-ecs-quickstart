import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
  java
  application
  id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "io.cloudreactor"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val log4j2Version = "2.15.0"

dependencies {
  implementation("org.apache.logging.log4j", "log4j-api", log4j2Version)
  implementation("org.apache.logging.log4j", "log4j-core", log4j2Version)
  implementation("org.apache.logging.log4j", "log4j-slf4j-impl", log4j2Version)
  implementation("io.cloudreactor", "tasksymphony", "0.4.0")
  testImplementation(platform("org.junit:junit-bom:5.8.2"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
  mainClass.set("io.cloudreactor.javaquickstart.Main")
}

tasks.getByName<Test>("test") {
  useJUnitPlatform()
}

tasks {
  named<ShadowJar>("shadowJar") {
    archiveBaseName.set("app")
    archiveClassifier.set("")
    archiveVersion.set("")
  }
}
