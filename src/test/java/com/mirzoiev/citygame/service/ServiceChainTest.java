package com.mirzoiev.citygame.service;

import com.mirzoiev.citygame.repository.CityRead;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ServiceChainTest {
    String FILE_NAME = "src/test/resources/testCity.txt";
    CityRead cityRead = new CityRead();
    ServiceChain chain2 = new ServiceChain();

    @Test
    public void testGetChain() throws IOException {
        List<String> list = cityRead.getCities(FILE_NAME);

        String actual = chain2.getChain(list);
        String expected = "Днепр Ровно Одесса";

        assertEquals(expected, actual);

    }
}