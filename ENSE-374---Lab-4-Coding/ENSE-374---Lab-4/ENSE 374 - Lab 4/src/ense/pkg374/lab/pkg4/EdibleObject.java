/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;

import java.util.HashMap;

/**
 *
 * @author Clayton
 */
public class EdibleObject extends NonLivingThings
{
    /* 
    Purpose:  default constructor
    Returns:
    */
    public EdibleObject(String organismName, int age)
    {
        HashMap properties = populateHashMap(age, organismName);
        NonLivingThings(properties);
    }
    
    /* 
    Purpose: create the organism
    Returns:
    */
    public void create(String organismName, int age)
    {
        new EdibleObject(organismName, age);
    }
    
    /* 
    Purpose: populate the hashmap from the given variables
    Returns:
    */
    private HashMap populateHashMap(int age, String elementName)
    {
        HashMap returnProperties = new HashMap();
        returnProperties.put("amountOfFood", 2);
        returnProperties.put("elementName", elementName);
        returnProperties.put("age",age );
        return returnProperties;
    }
}

