package com.mirzoiev.citygame.service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ServiceChain {

    public String getChain(List<String> words) throws IOException {
        String firstWord = "";
        Comparator<String> reversed = Comparator.comparing(String::length).reversed();
        TreeSet<String> sortedTreeSet = recursion(firstWord, words, new TreeSet<>(reversed));

        StringBuilder sb = new StringBuilder(sortedTreeSet.stream()
                .findFirst()
                .orElse(""));
        sb.deleteCharAt(0);
        return sb.toString();
    }

    private TreeSet<String> recursion(String firstWord, List<String> cityList,
                                      TreeSet<String> treeSet)
            throws IOException {
        for (String city : cityList) {
            if (!firstWord.isEmpty() && !isCharEqual(firstWord, city)) {
                continue;
            }

            String outputFormat = firstWord + " " + city;
            treeSet.add(outputFormat);
            if (cityList.size() > 1) {
                recursion(outputFormat, cityList.stream()
                        .filter(s -> !s.equals(city))
                        .collect(Collectors.toList()), treeSet);
            }
        }
        return treeSet;
    }

    private boolean isCharEqual(String firstWord, String nextWord) throws IOException {
        char lastChar = firstWord.toLowerCase().charAt(firstWord.length() - 1);
        char firstChar = nextWord.toLowerCase().charAt(0);
        if (!Character.isLetter(lastChar) || !Character.isLetter(firstChar)) {
            throw new IOException("wrong data format");
        }
        return lastChar == firstChar;
    }
}
