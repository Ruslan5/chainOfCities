package com.mirzoiev.citygame;

import com.mirzoiev.citygame.repository.CityRead;
import com.mirzoiev.citygame.service.ServiceChain;
import java.io.IOException;
import java.util.List;

public class Main {
    /**
     * path for Docker
     */
    private static final String FILE_NAME = "city.txt";
    /**
     * for this host path
     */
//    private static final String FILE_NAME = "src/main/resources/city.txt";

    public static void main(String[] args) throws IOException {

        /**
         * get data from repository
         */
        CityRead cityRead = new CityRead();
        List<String> dataList = cityRead.getCities(FILE_NAME);

        /**
         * make operation from service layer
         */
        ServiceChain chain2 = new ServiceChain();
        String longestChainOfCities = chain2.getChain(dataList);

        /**
         * output data
         */
        System.out.println(longestChainOfCities);
    }
}