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
public class GroundAnimals extends LivingThings
{
    public void GroundAnimals(String animalName, int xStart, int yStart, boolean isMale, int age, String[] whatItEats)
    {
        HashMap properties = populateHashMap(age, isMale, animalName, whatItEats);
        initializeParkElement(xStart,yStart);
        LivingThings(properties);
    }
    public HashMap populateHashMap(int age, boolean isMale, String elementName, String[] whatItEats)
    {
        HashMap returnProperties = new HashMap();
        
        returnProperties.put("elementName", elementName);
        returnProperties.put("whatItEats", whatItEats);
        returnProperties.put("Travel Distance",3 );
        returnProperties.put("hasTraveled",0 );
        returnProperties.put("daysSinceEaten",0 );
        returnProperties.put("noFoodTimeLimit",2 );
        returnProperties.put("age",age );
        returnProperties.put("isMale",isMale );
        return returnProperties;
    }
}
