plugins {
    id("groovy")
    kotlin("jvm") version "1.3.70"
    jacoco
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
}

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://repo.jenkins-ci.org/releases/") }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//dependencyManagement {
//    imports {
//        mavenBom("io.jenkins.tools.bom:bom-2.150.x:3")
//    }
//}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:3.0.2")
    implementation("org.apache.maven:maven-model:3.6.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testImplementation("org.mockito:mockito-core:3.3.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

sourceSets["test"].withConvention(GroovySourceSet::class)  {
    groovy.srcDir("test/groovy")
}

sourceSets["main"].withConvention(GroovySourceSet::class)  {
    groovy.srcDir("src")
    groovy.srcDir("vars")
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
        html.destination = file("${buildDir}/jacocoHtml")
    }
//    classDirectories.setFrom(
//            sourceSets.main.get().output.asFileTree.matching {
//                exclude("xxx/**/*.class")
//            }
//    )
}
