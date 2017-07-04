# Mbtiles server

The corresponding article can be found here:

* https://arnebosien.de/2016/12/28/vector-map-server-mbtiles-java.html

This sample application is implemented with Spring Boot. 

## Build
Build

    ./gradlew build

## Run
Run the app with:
    
    java -jar ./build/libs/mbtiles-server.jar

In order to use a different mbiles file than the one specified in `application.properties` override the property with:

    java -jar -Dspring.datasource.url=jdbc:sqlite:/path/to/myMap.mbtiles ./build/libs/mbtiles-server.jar

## Access
The server then can be reached e.g.:

    curl http://localhost:8080/map/1.0/tiles/1/1/1.pbf
