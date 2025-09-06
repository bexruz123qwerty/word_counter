package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(wordCounter("hello hello world world !!! world .....", 3));
    }

    public static String wordCounter(String input, int n) {
        Map<String, Integer> map = new HashMap<>();
        String regex = "[,.!;:'?]";

        Arrays.stream(input.replaceAll(regex, " ")
                        .split("\\s+"))
                .forEach(word -> {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                });
        return map.entrySet().stream()
                .filter(e-> e.getValue() == n)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(" "));
    }
}
