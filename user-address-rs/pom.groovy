project {
    modelVersion '4.0.0'

    parent {
        groupId 'test'
        artifactId 'integration-test'
        version '0.0.1-SNAPSHOT'
    }

    artifactId 'user-address-rs'

    dependencies {
        dependency('test:commons:${project.version}')
        dependency('org.apache.cxf:cxf-rt-frontend-jaxrs:2.7.16')
        dependency('org.springframework:spring-web')
        dependency('org.codehaus.jackson:jackson-jaxrs:1.9.13')
        dependency('org.codehaus.jackson:jackson-xc:1.9.13')
        dependency('com.google.guava:guava')
        dependency('org.slf4j:slf4j-log4j12')
        dependency('log4j:log4j')
    }

    build {
        resources {
            resource {
                targetPath 'webapp'
                directory 'src/main/webapp'
            }
            resource {
                directory 'src/main/resources'
            }
        }
        plugins {
            plugin {
                artifactId 'maven-war-plugin'
            }
            plugin {
                groupId 'org.codehaus.mojo'
                artifactId 'exec-maven-plugin'
                executions {
                    execution {
                        goals {
                            goal 'java'
                        }
                    }
                }
                configuration {
                    mainClass 'test.Main'
                }
            }
        }
    }
}
