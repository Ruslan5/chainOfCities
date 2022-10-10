package com.mirzoiev.citygame.repository;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class CityReadTest {
    String FILE_NAME = "src/test/resources/testCity.txt";
    CityRead cityRead = new CityRead();

    @Test
    public void testGetCities() throws IOException {
        List<String> actual = cityRead.getCities(FILE_NAME);
        List<String> expected = new ArrayList<>();
        expected.add("Днепр");
        expected.add("Одесса");
        expected.add("Ровно");
        assertEquals(expected, actual);
    }
}