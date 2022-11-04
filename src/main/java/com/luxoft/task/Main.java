package com.luxoft.task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String dir = System.getProperty("user.dir");
        String fileNamee = "\\input.txt";
        var words = FileReader.readWordsFromFile(dir + fileNamee);
        var result = VowelHunter.getAverageVowelsGroups(words);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String outputFileName = sc.nextLine();
        OutputGenerator.insertOutput(outputFileName, result);
    }
}