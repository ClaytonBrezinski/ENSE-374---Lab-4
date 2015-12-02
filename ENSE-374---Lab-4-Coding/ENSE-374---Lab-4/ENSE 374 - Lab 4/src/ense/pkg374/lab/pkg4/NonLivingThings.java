/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Clayton
 */
public abstract class NonLivingThings implements ParkElement 
{
    private HashMap Characteristic = new HashMap();
    
    /* 
    Purpose: Default constructor based on user entered variables
    Returns:
    */
    public void NonLivingThings(HashMap properties) 
    {
        if (properties == null) 
        {
            this.Characteristic = new HashMap();
        } 
        else
        {
            this.Characteristic = new HashMap(properties);
            // put in that it cannot move here
        }
    }
    
    /* 
    Purpose: 
    Returns:Collection- return all the properties of the living thing
    */
    public Collection getProperties()
    {
        return Characteristic.values();
    }
    
    /* 
    Purpose: 
    Returns:  object- corresponding variable to the given propertyName 
    */
    public Object getProperty(String propertyName)
    {
        return Characteristic.get(propertyName);
    }
    
    /* 
    Purpose: if the organism has been eaten decrement the amount of food that the organism currently has
    Returns: 
    */
    public void beenEaten()
    {
        Object food = Characteristic.get("amountOfFood");
        int foodLeft = Integer.parseInt(food.toString());
        Characteristic.put("amountOfFood",foodLeft - 1);
    }
    
    /* 
    Purpose: return if the organism has food or not
    Returns: boolean: true- organism currently has food
    */
    boolean hasFood()
    {
        Object food = Characteristic.get("amountOfFood");
        int foodLeft = Integer.parseInt(food.toString());
        if (foodLeft >= 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /* 
    Purpose: move the organism to the closest food
    Returns: 
    */
    public void moveToClosestFood()
    {
        return; // non living objects do not move in this current iteration of the project
    }
    
    /* 
    Purpose: 
    Returns:
    */
    public void create(String animalName, boolean isMale, int age, String[] whatItEats)
    {
        // never will get hit
    }
    
    /* 
    Purpose: 
    Returns: string[]- organism does not eat anything so return as such
    */
    public String[] whatItEats()
    {
        String[] ret = {};
        return ret;
    }
    
    /* 
    Purpose: 
    Returns: int- nonliving things cannot move so return 0
    */
    public int getMaxTravelDistance()
    {
        return 0;
    }
    
    /* 
    Purpose: 
    Returns: boolean: false- organism is not living
    */
    public boolean isLivingThing()
    {
        return false;
    }  
    
    /* 
    Purpose: sets the givene property
    Returns: 
    */
    public void setProperty(String propertyName, String value)
    {
        Characteristic.put(propertyName, value);
    }
    
    /* 
    Purpose: sets the givene property
    Returns: 
    */
    public void setProperty(String propertyName, int value)
    {
        Characteristic.put(propertyName, value);
    }
}
