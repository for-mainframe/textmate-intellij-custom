plugins {
  id("org.jetbrains.intellij.platform") version "2.1.0"
  kotlin("jvm") version "1.9.24"
  kotlin("plugin.serialization") version "1.9.24"
  java
}

group = "org.jetbrains.plugins.textmate"
version = "0.0.1"

repositories {
  mavenCentral()
  intellijPlatform {
    defaultRepositories()
    jetbrainsRuntime()
  }
  maven {
    url = uri("https://zowe.jfrog.io/zowe/libs-release")
    flatDir {
      dir("libscustom")
    }
  }
}

java {
  sourceCompatibility = JavaVersion.VERSION_21
  targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
  jvmToolchain(21)
}

dependencies {
  intellijPlatform {
    intellijIdeaCommunity("2024.2")
    instrumentationTools()
    jetbrainsRuntime()

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.6.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("org.jruby.joni:joni:2.2.2-SNAPSHOT")
    implementation("org.jruby.jcodings:jcodings:1.0.58")
  }
}

sourceSets {
  main {
    java.srcDirs("src", "core/src")
    resources.srcDirs("resources")
  }
}

tasks {
  wrapper {
    gradleVersion = "8.10.2"
  }
}

intellijPlatform {
  pluginConfiguration {
    version = "0.0.1"
  }
}
