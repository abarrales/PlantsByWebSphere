# Migration from Gradle to Maven

This project has been migrated from Gradle to Maven. This document explains the key differences and how to work with the new Maven structure.

## Project Structure

The project structure remains largely the same, following the standard Maven directory layout:

```
src/main/java        - Java source files
src/main/resources   - Resource files
src/main/webapp      - Web application files
src/main/liberty     - Liberty server configuration
```

## Key Migration Changes

| Gradle | Maven |
|--------|-------|
| build.gradle | pom.xml |
| settings.gradle | pom.xml (artifactId defines project name) |
| apply plugin: 'war' | `<packaging>war</packaging>` |
| apply plugin: 'liberty' | liberty-maven-plugin |
| providedCompile | `<scope>provided</scope>` |
| serverLibs | maven-dependency-plugin (copy) |
| dependencies {} | `<dependencies>` section |
| task | plugins and their executions |

## Common Commands

### Building the Project

**Gradle:**
```
./gradlew build
```

**Maven:**
```
mvn clean package
```

### Running Liberty Server

**Gradle:**
```
./gradlew libertyStart
./gradlew libertyStop
```

**Maven:**
```
mvn liberty:start
mvn liberty:stop
```

### Creating WAR file

**Gradle:**
```
./gradlew war
```

**Maven:**
```
mvn package
```

### Open Browser (using profile)

**Gradle:**
```
./gradlew openBrowser
```

**Maven:**
```
mvn package -P open-browser
```

## Maven POM Details

The POM file includes:

1. Project coordinates (groupId, artifactId, version)
2. Dependencies
   - JavaEE API
   - Derby database
3. Plugins
   - maven-war-plugin - For creating WAR file
   - liberty-maven-plugin - For Liberty server operations
   - maven-dependency-plugin - For copying Derby library to Liberty server
4. Profile for opening the browser

## Runtime Configuration

The Liberty server runtime configuration in `src/main/liberty/config` remains unchanged and is still used by the Liberty Maven plugin.