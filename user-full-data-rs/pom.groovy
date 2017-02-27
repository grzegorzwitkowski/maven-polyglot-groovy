project {
    modelVersion '4.0.0'

    parent {
        groupId 'test'
        artifactId 'integration-test'
        version '0.0.1-SNAPSHOT'
        relativePath '../pom.groovy'
    }

    artifactId 'user-full-data-rs'

    packaging 'bundle'
    
    dependencies {
        dependency('org.apache.camel:camel-core:2.12.4')
        dependency('org.apache.camel:camel-cxf:2.12.4')
        dependency('org.apache.cxf:cxf-rt-transports-http-jetty:2.7.16')
        dependency('org.apache.cxf:cxf-rt-frontend-jaxrs:2.7.16')
        dependency('org.apache.cxf:cxf-rt-frontend-jaxws:2.7.16')
        dependency('org.codehaus.jackson:jackson-jaxrs:1.9.13')
        dependency('org.apache.cxf:cxf-rt-rs-extension-providers:2.7.16')
        dependency('org.apache.camel:camel-xmljson:2.12.4')
    }

    build {
        plugins {
            plugin {
                groupId 'org.apache.camel'
                artifactId 'camel-maven-plugin'
                version '2.12.4'
            }
            plugin {
                groupId 'org.apache.cxf'
                artifactId 'cxf-codegen-plugin'
                version '2.7.16'
                executions {
                    execution {
                        phase 'generate-sources'
                        goals {
                            goal 'wsdl2java'
                        }
                        configuration {
                            sourceRoot '${project.build.directory}/generated/cxf'
                            wsdlOptions {
                                wsdlOption {
                                    wsdl '${basedir}/src/main/resources/getUser.wsdl'
                                }
                            }
                        }
                    }
                }
            }
            plugin {
                groupId 'org.apache.felix'
                artifactId 'maven-bundle-plugin'
                version '3.2.0'
                extensions 'true'
                configuration {
                    instructions {
                        'Bundle-SymbolicName' 'user-full-data-rs'
                        'Import-Package' '*'
                    }
                }
            }
        }
    }
}
