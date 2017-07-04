/*
 * https://arnebosien.de
 *
 * Copyright 2017 Arne Bosien
 * Licensed under MIT (https://github.com/abos/ab-samples/blob/master/LICENSE)
 */
package de.arnebosien.mbtiles.business.boundary;

import de.arnebosien.mbtiles.business.control.iface.MapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * @autor Arne Bosien
 */
@Controller
public class MapRestFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapRestFacade.class);

    private final MapService mapService;

    @Autowired
    public MapRestFacade(MapService mapService) {
        this.mapService = mapService;
    }

    @RequestMapping(value = "/map/1.0/tiles/{zoomLevel}/{column}/{row}.pbf", method = RequestMethod.GET, produces = "application/x-protobuf")
    @ResponseBody
    public byte[] getTile(
            @PathVariable(value = "zoomLevel") long zoomLevel,
            @PathVariable(value = "column") long column,
            @PathVariable(value = "row") long row,
            HttpServletResponse response
    ) {
        LOGGER.debug("getTile: <{}>, <{}>, <{}>", zoomLevel, column, row);

        byte[] tile = mapService.getPbfTile(zoomLevel, column, row);

        if (tile == null) {
            throw new ResourceNotFoundException();
        }

        response.addHeader("Content-Encoding", "gzip");
        response.setHeader("Cache-Control", "max-age=3600"); // 60 min

        return tile;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private static class ResourceNotFoundException extends RuntimeException {
    }
}
