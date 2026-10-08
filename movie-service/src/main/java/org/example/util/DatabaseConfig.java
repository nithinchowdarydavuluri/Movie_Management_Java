package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     DatabaseConfig.class
                             .getClassLoader()
                             .getResourceAsStream("database.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "database.properties not found"
                );
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load database.properties", e
            );
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}