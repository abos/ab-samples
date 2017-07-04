/*
 * https://arnebosien.de
 *
 * Copyright 2017 Arne Bosien
 * Licensed under MIT (https://github.com/abos/ab-samples/blob/master/LICENSE)
 */
package de.arnebosien.mbtiles.business.control.iface;

/**
 * @autor Arne Bosien
 */
public interface MapService {
    byte[] getPbfTile(long zoomLevel, long column, long row);
}
