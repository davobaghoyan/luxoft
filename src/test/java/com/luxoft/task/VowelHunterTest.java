package com.luxoft.task;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class VowelHunterTest {


    @Test
    public void getNumberOfVowels_whenVowelsAbsent() {
        String testString = "Shy Gypsy, slyly spryly tryst by my crypt.";
        int expectedResult = 0;

        int actualResult = VowelHunter.getNumberOfVowels(testString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getNumberOfVowels_whenVowelsPresent() {
        String testString = "NEvEr give up";
        int expectedResult = 5;

        int actualResult = VowelHunter.getNumberOfVowels(testString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getVowels_whenVowelsAbsent() {
        String testString = "nymphly";
        Set<Character> expectedResult = new HashSet<>();

        Set<Character> actualResult = VowelHunter.getVowels(testString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getVowels_whenVowelsPresent() {
        String testString = "Euouae";
        Set<Character> expectedResult = new HashSet<>();
        expectedResult.add('e');
        expectedResult.add('u');
        expectedResult.add('o');
        expectedResult.add('a');

        Set<Character> actualResult = VowelHunter.getVowels(testString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getAverageOfVowels_whenVowelsPresent() {
        List<String> words = new ArrayList<>();
        words.add("exclusively");
        words.add("consisting");
        double expectedResult = 3.5;

        double actualResult = VowelHunter.getAverageOfVowels(words);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getAverageOfVowels_whenVowelsAbsent() {
        List<String> words = new ArrayList<>();
        words.add("hymn");
        words.add("myths");
        double expectedResult = 0.0;

        double actualResult = VowelHunter.getAverageOfVowels(words);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getAverageOfVowels() {
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("oleeh");
        words.add("Ukrain");
        words.add("uujiav");
        HashSet<Character> firstGroup = new HashSet<>();
        firstGroup.add('e');
        firstGroup.add('o');
        HashSet<Character> secondGroup = new HashSet<>();
        secondGroup.add('u');
        secondGroup.add('a');
        secondGroup.add('i');
        Map<VowelSet, Double> expectedResult = new TreeMap<>();
        expectedResult.put(new VowelSet(5, firstGroup), 2.5);
        expectedResult.put(new VowelSet(6, secondGroup), 3.5);

        Map<VowelSet, Double> actualResult = VowelHunter.getAverageVowelsGroups(words);

        assertIterableEquals(expectedResult.entrySet(), actualResult.entrySet());
    }

}
