package fr.klock.dev.training.adventOfCode;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public static String[] loadInput(Object classs, String resourcePath) throws IOException {
        InputStream resourceAsStream = classs.getClass().getResourceAsStream(resourcePath);
        return IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8).split("\r\n");
    }
}
