/*
 * https://arnebosien.de
 *
 * Copyright 2017 Arne Bosien
 * Licensed under MIT (https://github.com/abos/ab-samples/blob/master/LICENSE)
 */
package de.arnebosien.mbtiles.app;

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
