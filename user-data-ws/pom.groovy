project {
    modelVersion '4.0.0'

    parent {
        groupId 'test'
        artifactId 'integration-test'
        version '0.0.1-SNAPSHOT'
    }

    artifactId 'user-data-ws'

    dependencies {
        dependency('test:commons:${project.version}')
        dependency('org.apache.cxf:cxf-rt-frontend-jaxws:2.7.18')
        dependency('org.springframework:spring-web')
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
                configuration {
                    failOnMissingWebXml 'false'
                }
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
