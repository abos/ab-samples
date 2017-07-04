package de.arnebosien.mbtiles.business.control.iface;

/**
 * @autor Arne Bosien
 */
public interface MapService {
    byte[] getPbfTile(long zoomLevel, long column, long row);
}
