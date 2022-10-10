package com.mirzoiev.citygame;

import com.mirzoiev.citygame.repository.CityRead;
import com.mirzoiev.citygame.service.ServiceChain;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "src/main/resources/city.txt";

    public static void main(String[] args) throws IOException {
        CityRead cityRead = new CityRead();
        List<String> dataList = cityRead.getCities(FILE_NAME);

        ServiceChain chain2 = new ServiceChain();
        String longestChainOfCities = chain2.getChain(dataList);

        System.out.println(longestChainOfCities);

    }
}