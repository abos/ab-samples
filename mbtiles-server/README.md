# Mbtiles server

* https://arnebosien.de/2016/12/28/vector-map-server-mbtiles-java.html

## Build
Build

    ./gradlew build
    
Run
    
    java -jar ./build/libs/mbtiles-server.jar -Dspring.datasource.url=jdbc:sqlite:/path/to/myMap.mbtiles
    
The server can be reached like this:

    curl http://localhost:8080/data/osm2vectortiles/1/1/1.pbf
