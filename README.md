# TelegramLampModule
[![](https://jitpack.io/v/U61vashka/TelegramLampModule.svg)](https://jitpack.io/#U61vashka/TelegramLampModule)

Telegram module for the Lamp (https://github.com/Revxrsal/Lamp)

This module provides basic function, except MessageEvent listening that need to be provided by yourself



Get all TelegramHandler instances:
  ```
    List<TelegramHandler> handlers = TelegramHandler.getInstances();
  ```

## Getting Started

**Maven**:
  <details>
    <summary>pom.xml</summary>

      <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
      </repositories>

      <dependencies>
        <dependency>
            <groupId>com.github.Revxrsal.Lamp</groupId>
            <artifactId>common</artifactId>
            <version>[lamp-version]</version>
        </dependency>
        <dependency>
            <groupId>com.github.U61vashka</groupId>
            <artifactId>TelegramLampModule</artifactId>
            <version>[version]</version>
        </dependency>
      </dependencies>
  
  </details>

**Gradle**:
  <details>
    <summary>build.gradle</summary>
    
      repositories {
        maven { url = 'https://jitpack.io' }
      }

      dependencies {
        implementation 'com.github.Revxrsal.Lamp:common:[lamp-version]'
        implementation 'com.github.U61vashka:TelegramLampModule:[verison]'
      }
      
  </details>


