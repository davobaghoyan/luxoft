package com.luxoft.task;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileReader {
    public static List<String> readWordsFromFile(String filePath){
        List<String> lines;

        try {
            lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Unable to read the file on path: " + filePath);
            throw new IllegalArgumentException("Unable to read the file on path: " + filePath);
        }

       return lines.stream()
               .map(e -> e.split(" "))
               .flatMap(Arrays::stream)
               .toList();
    }

}
