project {

    modelVersion '4.0.0'

    parent {
        groupId 'test'
        artifactId 'integration-test'
        version '0.0.1-SNAPSHOT'
        relativePath '../pom.groovy'
    }

    artifactId 'commons'

    dependencies {
        dependency('org.springframework:spring-web')
        dependency('org.apache.cxf:cxf-rt-transports-http-jetty:2.7.18')
        dependency('org.eclipse.jetty:jetty-webapp:8.2.0.v20160908')
    }
}
