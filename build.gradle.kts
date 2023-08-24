import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
}

group = "voyagersoft.mockbot"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.mindrot:jbcrypt:0.4")
	implementation("org.modelmapper:modelmapper:3.1.1")

	implementation("io.jsonwebtoken:jjwt:0.9.1")
	implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")

	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

// 2023.01.16[holywater]: apllication.yml이 여러 개이기때문에 INCLUDE
tasks.processResources {
	duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

// 2023.01.16[holywater]: build 파일 이름 변경
tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
	archiveBaseName.set("ROOT")
}

// 2023.01.16[holywater]: profile
var profiles = "local"
if (project.hasProperty("profile")) {
	profiles = project.property("profile").toString()
}

val active: String? = System.getProperty("spring.profiles.active")
if (active != null) {
	profiles = active
}

// 2023.01.16[holywater]: 빌드 환경에 따른 프로퍼티 경로 지정
sourceSets {
	main {
		resources {
			srcDirs(listOf("src/main/resources", "src/main/resources-${profiles}"))
		}
	}
}