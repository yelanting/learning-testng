package org.testng.internal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Version {

    public static String VERSION = "7.0.1";

    static {
        String version = readVersion();
        if (!version.trim().isEmpty()) {
            VERSION = version;
        }
    }

    public static String getVersionString() {
        return VERSION;
    }

    public static void displayBanner() {
        System.out.println("...\n... TestNG " + getVersionString() + " by Cédric Beust (cedric@beust.com)\n...\n");
    }

    private static String readVersion() {
        try {
            Path path = Paths
                .get(Objects
                    .requireNonNull(Version.class.getClassLoader().getResource("/version.txt")).toURI());
            String version = String.join("", Files.readAllLines(path));
            if (version.contains("project.version")) {
                return "";
            }
            return version;
        } catch (URISyntaxException | NullPointerException | IOException e) {
            return "";
        }
    }
}
