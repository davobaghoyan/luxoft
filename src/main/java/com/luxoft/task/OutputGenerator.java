package com.luxoft.task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class OutputGenerator {

    public static void insertOutput(String filename, Map<VowelSet, Double> data) {
        String fileName = createFile(filename);
        try(FileWriter myWriter = new FileWriter(fileName)) {
            for (Map.Entry<VowelSet, Double> entry : data.entrySet()) {
                myWriter.write(stringDecorator(entry));
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred." + e.getMessage());
        }
    }

    public static String stringDecorator(Map.Entry<VowelSet, Double> entry) {
        return "(" + entry.getKey() + ")" + " -> " + entry.getValue() + "\r";
    }

    public static String createFile(String filename) {
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                return myObj.getName();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred." + e.getMessage());
        }

        return filename;
    }
}
