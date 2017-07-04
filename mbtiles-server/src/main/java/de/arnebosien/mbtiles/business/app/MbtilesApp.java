package de.arnebosien.mbtiles.business.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @autor Arne Bosien
 */
@SpringBootApplication(scanBasePackages = "de.arnebosien")
public class MbtilesApp {
    public static void main(String[] args) {
        SpringApplication.run(MbtilesApp.class, args);
    }
}
