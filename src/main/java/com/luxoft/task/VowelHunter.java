package com.luxoft.task;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.entry;
import static java.util.stream.Collectors.groupingBy;

public class VowelHunter {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'u', 'o');
    //Regex is used to clean non-english characters
    private static final String REG_EX_LETTERS = "[^A-Za-z]+";


    public static Map<VowelSet, Double> getAverageVowelsGroups(List<String> words){
        Map<VowelSet, List<String>> groupedVowels = words.stream()
                .collect(groupingBy(t -> new VowelSet(t.toLowerCase()
                        .replaceAll(REG_EX_LETTERS, "").length(), getVowels(t))));

        var result   = groupedVowels.entrySet().stream()
                .map(e -> entry(e.getKey(), getAverageOfVowels(e.getValue())))
                .filter(e -> e.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new TreeMap<>(result);
    }

    public static double getAverageOfVowels(List<String> words){
        int count = words.stream()
                .map(word -> getNumberOfVowels(word.toLowerCase()))
                .reduce(0, Integer::sum);

        return (double)count / (double)words.size();
    }

    public static int getNumberOfVowels(String str){
        String lowerCaseString = str.toLowerCase();
       return (int)lowerCaseString.chars()
                .filter(ch -> VOWELS.contains((char)ch))
                .count();
    }

    public static Set<Character> getVowels(String str){
        String lowerCaseString = str.toLowerCase();
        Set<Character> vowels = new HashSet<>();

        for(int i=0; i<lowerCaseString.length(); i++) {
            char ch = lowerCaseString.charAt(i);
            if(VOWELS.contains(ch)){
                vowels.add(ch);
            }
        }

        return vowels;
    }
}
