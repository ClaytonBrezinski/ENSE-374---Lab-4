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
public class NonEdibleObject extends NonLivingThings
{
    public NonEdibleObject(String organismName, int xCo, int yCo, int age)
    {
        HashMap properties = populateHashMap(age, organismName);
        initializeParkLocation(xCo,yCo);
        NonLivingThings(properties);
    }
    private HashMap populateHashMap(int age, String elementName)
    {
        HashMap returnProperties = new HashMap();
        returnProperties.put("amountOfFood", 0);
        returnProperties.put("elementName", elementName);
        returnProperties.put("age",age );
        return returnProperties;
    }
}
