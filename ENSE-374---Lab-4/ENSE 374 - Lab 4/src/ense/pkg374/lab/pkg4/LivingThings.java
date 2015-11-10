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
public abstract class LivingThings extends ParkElement
{
    private HashMap Characteristic = new HashMap();
    
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
    }
    Collection getLivingProperties()
    {
        return Characteristic.values();
    }
    Object getLivingProperty(String propertyName)
    {
        return Characteristic.get(propertyName);
    }
    boolean hasStarved()
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
    void moveToClosestFood()
    {
        // check surrounding in 1 square arc, if one is present go there, if not, search a square arc one bigger, 
        // if at the food currently, eatFood();
    }
    void move(int x, int y)
    {
        setXYCoords(x,y);
    }
    void findFood()
    {
        // first check surroundings in a 1 square arc
    }
    void eatFood()
    {
        // if at food location -> days since eaten = 0
        //      if nonliving thing -> increment has been eaten. 
        //      if living thing -> change alive to false
        
        Characteristic.put("daysSinceEaten", 0);
    }   
    public String[] whatItEats(String type)
    {
        String[] a;
        switch(type)
        {
            case "CATERPILLAR":     return new String[] {"TREES_SHRUBS"};
            case "BLUE_JAY":        a =  new String[] {"CATERPILLAR", "GRASSHOPPER", "TREES_SHRUBS"};
            case "HAWK":            a = new String[] {"MOUSE","SQUIRREL"};
            case "GRASSHOPPER":     a = new String[] {"GRASS"};
            case "MOUSE":           a = new String[] {"TREES_SHRUBS", "GRASS"};
            case "FOX":             a = new String[] {"BLUE_JAY", "MOUSE", "SQUIRREL", "RABBIT"};
            case "SQUIRREL":        a = new String[] {"TREES_SHRUBS"};
            case "RABBIT":          a = new String[] {"GRASS"};
            case "DEER":            a = new String[] {"TREES_SHRUBS", "GRASS"};
            case "WOLF":            a = new String[] {"RABBIT","DEER"};
            default:              a = new String[] {"Unspecified"};
            return a;
        }
    }
    
}
