package de.arnebosien.mbtiles.business.control;

import de.arnebosien.mbtiles.business.control.iface.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @autor Arne Bosien
 */
@Component
public class MapModule implements MapService {
    private static final String QUERY =
            "SELECT tile_data " +
                    "FROM tiles " +
                    "WHERE zoom_level = ? AND tile_column = ? AND tile_row = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MapModule(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public byte[] getPbfTile(long zoomLevel, long column, long row) {
        // Flip Y coordinate because MBTiles files are TMS.
        row = (1 << zoomLevel) - 1 - row;

        try {
            return jdbcTemplate.queryForObject(QUERY, new Object[]{zoomLevel, column, row}, byte[].class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
