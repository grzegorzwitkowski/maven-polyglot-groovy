# Integration Test

## build

```mvn package```

## run "legacy" soap web service
 
```mvn -pl user-data-ws package exec:java```

It will run on port 8080. WSDL is available at [http://localhost:8080/getUsers?wsdl](http://localhost:8080/getUsers?wsdl)

## run "shiny new" REST service

```mvn -pl user-full-data-rs package camel:run```

Then send GET request to [http://localhost:8082/users/1](http://localhost:8082/users/1).
Camel will route incoming requests to legacy service.

