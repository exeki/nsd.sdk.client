plugins {
    kotlin("jvm") version "1.9.10"
    id("maven-publish")
    id("groovy")
    id("org.jetbrains.dokka") version "1.9.10"
}

group = "ru.kazantsev.nsd"
version = "1.0.0"

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    javadoc {
        dependsOn(dokkaJavadoc)
    }

    dokkaJavadoc {
        outputDirectory.set(buildDir.resolve("docs\\javadoc"))
    }

    register<Jar>("javadocJar") {
        from(getByName("javadoc").outputs.files)
        archiveClassifier.set("javadoc")
    }

    register<Jar>("sourcesJar") {
        from(sourceSets.main.get().allSource)
        archiveClassifier.set("sources")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["kotlin"])

            artifact(tasks.named("javadocJar"))
            artifact(tasks.named("sourcesJar"))

            pom {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
            }
        }
    }
    repositories {
        mavenLocal()
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    api("ru.kazantsev.nsd:sdk_data:1.0.0")
    api("ru.kazantsev.nsd:basic_api_connector:1.0.0")
    implementation("org.slf4j:slf4j-api:2.0.9")

    testImplementation("ch.qos.logback:logback-classic:1.4.11")
    testImplementation("org.codehaus.groovy:groovy-all:3.0.19")
    testImplementation(kotlin("test"))
}