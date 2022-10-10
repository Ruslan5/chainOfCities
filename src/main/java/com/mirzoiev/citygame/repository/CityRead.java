package com.mirzoiev.citygame.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class CityRead
 * designed to receive data (read cities from a file)
 * and error handling when accessing data
 *
 * @author R.Mirzoiev
 * @since 07.10.2022
 */
public class CityRead {
    private static final int LIMIT_OF_CITIES = 10;
    public List<String> getCities(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName),
                StandardCharsets.UTF_8);

        for (String s: lines) {
            Pattern pattern = Pattern.compile("\\s\\S");
            Matcher matcher = pattern.matcher(s);
            boolean found = matcher.find();
            if (found) {
                throw new IOException("String contains more then one word");
            }
        }

        Set<String> citySet=new LinkedHashSet<>(lines);
        if (citySet.size() > LIMIT_OF_CITIES) {
            throw new IOException("limit is exceeded. maximum" + LIMIT_OF_CITIES);
        }
        if (citySet.isEmpty()){
            throw new IOException("list is empty");
        }
            return new ArrayList<>(citySet);
    }
}
