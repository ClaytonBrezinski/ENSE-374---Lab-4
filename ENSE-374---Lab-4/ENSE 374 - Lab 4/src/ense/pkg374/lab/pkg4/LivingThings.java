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
    Collection getProperties()
    {
        return Characteristic.values();
    }
    Object getProperty(String propertyName)
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
}
