/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;
import java.util.*;
/**
 *
 * @author Clayton
 */
public abstract class LivingThings implements ParkElement
{
    private HashMap Characteristic = new HashMap();
    private boolean alive;
    
    /* 
    Purpose: default constructor based on user input
    Returns:
    */
    public void LivingThings(HashMap properties) 
    {
        if (properties == null) 
        {
            this.Characteristic = new HashMap();
        } 
        else
        {
            this.Characteristic = new HashMap(properties);
        }
        alive = true;
    }
    
    /* 
    Purpose: 
    Returns: Collection- return all the properties of the living thing
    */
    public Collection getProperties()
    {
        return Characteristic.values();
    }
    
    /* 
    Purpose: 
    Returns: object- corresponding variable to the given propertyName 
    */
    public Object getProperty(String propertyName)
    {
        return Characteristic.get(propertyName);
    }
    
    /* 
    Purpose: function to state if the animal has starved or not
    Returns: true: animal has starved, false: animal has not starved
    */
    public boolean hasStarved()
    {
        Object starve = Characteristic.get("daysSinceEaten");
        int starvation = Integer.parseInt(starve.toString());
        Object death = Characteristic.get("noFoodTimeLimit");
        int deathPoint = Integer.parseInt(death.toString());
        if (starvation >= deathPoint)
        {
            //living thing has starved.
            return true;
        }
        else
        {
            // living thing has not starved
            return false;
        }
    }
    
    /* 
    Purpose: if the living thing has been eaten, set its living status as not alive
    Returns: 
    */
    public void beenEaten()
    {
        alive = false;
    }
    
    /* 
    Purpose: 
    Returns: boolean- true: animal has food, false: animal does not have food
    */
    public boolean hasFood()
    {
        if (alive == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /* 
    Purpose: if the animal has been exposed to food, reset its daysSinceEaten counter
    Returns: 
    */
    private void eatFood()
    {
        Characteristic.put("daysSinceEaten", 0);
    }   
    
    /* 
    Purpose: create the organism
    Returns:
    */
    public void create(String organismName, int age)
    {
        // never will be hit
    }
    
    /* 
    Purpose: determine what the organism can eat and return it
    Returns: String[] - list of all the food that the organism can consume
    */
    public String[] whatItEats()
    {
        String whatItEats = this.getProperty("whatItEats").toString();
        whatItEats = whatItEats.replaceAll(" ", "");
        return whatItEats.split(",");
    }
    
    /* 
    Purpose: 
    Returns:int- the max distance the organism can travel in 1 day
    */
    public int getMaxTravelDistance()
    {
       return (Integer) this.getProperty("Travel Distance");
    }
    
    /* 
    Purpose: 
    Returns: boolean- the organism is a living thing
    */
    public boolean isLivingThing()
    {
        return true;
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
