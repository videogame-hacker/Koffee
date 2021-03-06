import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.70"
    `maven-publish`
}

group = "codes.som.anthony"
version = "8.0.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    arrayOf("asm", "asm-tree", "asm-commons").forEach {
        implementation(group = "org.ow2.asm", name = it, version = "8.0.1")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    repositories {
        maven("$buildDir/repo")
    }

    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
        }
    }
}
