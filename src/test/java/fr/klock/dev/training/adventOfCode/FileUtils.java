package fr.klock.dev.training.adventOfCode;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public static String[] loadInput(Object classs, String resourcePath) throws IOException {
        InputStream resourceAsStream = classs.getClass().getResourceAsStream(resourcePath);
        String resourceAsString = IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
        if (resourceAsString.contains(StringUtils.CR + StringUtils.LF)) {
            return resourceAsString.split(StringUtils.CR + StringUtils.LF);
        } else {
            return resourceAsString.split(StringUtils.LF);
        }
    }
}
