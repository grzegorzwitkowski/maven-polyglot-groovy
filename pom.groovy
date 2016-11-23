project {
    modelVersion '4.0.0'
    groupId 'test'
    artifactId 'integration-test'
    version '0.0.1-SNAPSHOT'
    packaging 'pom'

    modules {
        module 'user-data-ws'
        module 'user-address-rs'
        module 'commons'
        module 'user-full-data-rs'
    }

    properties {
        'maven.compiler.source' '1.7'
        'maven.compiler.target' '1.7'
    }

    dependencyManagement {
        dependencies {
            dependency('org.springframework:spring-web:3.2.17.RELEASE')
            dependency('com.google.guava:guava:15.0')
            dependency('org.slf4j:slf4j-log4j12:1.7.21')
            dependency('log4j:log4j:1.2.17')
        }
    }
    build {
        pluginManagement {
            plugins {
                plugin {
                    groupId 'org.codehaus.mojo'
                    artifactId 'exec-maven-plugin'
                    version '1.5.0'
                }
                plugin {
                    artifactId 'maven-war-plugin'
                    version '2.6'
                }
            }
        }
    }
}
