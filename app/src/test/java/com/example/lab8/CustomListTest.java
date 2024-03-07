package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * adds a city then checks if it returns true
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);

        assertTrue(list.hasCity(city));

    }

    /**
     * adds then deletes cities then uses hasCity
     * to check if it returns false
     */
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);

        list.deleteCity(city);

        assertFalse(list.hasCity(city));
    }

    /**
     * adds city then uses assertEquals to check if its 1
     * then deleteCity to check if its 0
     */
    @Test
    public void countCitiesTest(){
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);

        assertEquals(1, list.countCities(city));

        list.deleteCity(city);
        assertEquals(0,list.countCities(city));
    }


}
