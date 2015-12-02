/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Clayton
 */
public class GroundAnimals extends LivingThings
{
    
    /* 
    Purpose:  default constructor
    Returns:
    */
    public GroundAnimals(String animalName, boolean isMale, int age, String[] whatItEats)
    {
        HashMap properties = populateHashMap(age, isMale, animalName, whatItEats);
        LivingThings(properties);
    }
    
    /* 
    Purpose: create the organism
    Returns:
    */
    public void create(String animalName, boolean isMale, int age, String[] whatItEats)
    {
        new GroundAnimals(animalName, isMale, age, whatItEats);
    }
    
    /* 
    Purpose: populate the hashmap from the given variables
    Returns:
    */
    private HashMap populateHashMap(int age, boolean isMale, String elementName, String[] whatItEats)
    {
        HashMap returnProperties = new HashMap();
        // set the array so that it can be easily used in the hashmap and elsewhere
        String whatItEatsDelimmited = Arrays.toString(whatItEats);
        whatItEatsDelimmited = whatItEatsDelimmited.replace("[", "");
        whatItEatsDelimmited = whatItEatsDelimmited.replace("]", "");
       
        
        returnProperties.put("elementName", elementName);
        returnProperties.put("whatItEats", whatItEatsDelimmited);
        returnProperties.put("Travel Distance",3 );
        returnProperties.put("hasTraveled",0 );
        returnProperties.put("daysSinceEaten",0 );
        returnProperties.put("noFoodTimeLimit",2 );
        returnProperties.put("age",age );
        returnProperties.put("isMale",isMale );
        return returnProperties;
    }
}
