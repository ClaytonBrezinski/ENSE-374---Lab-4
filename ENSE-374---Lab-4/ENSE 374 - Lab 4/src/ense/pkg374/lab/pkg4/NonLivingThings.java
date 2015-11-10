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
public abstract class NonLivingThings extends ParkElement 
{
    private HashMap Characteristic = new HashMap();
    
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
    Collection getNonLivingProperties()
    {
        return Characteristic.values();
    }
    Object getNonLivingProperty(String propertyName)
    {
        return Characteristic.get(propertyName);
    }
    void beenEaten()
    {
        Object food = Characteristic.get("amountOfFood");
        int foodLeft = Integer.parseInt(food.toString());
        Characteristic.put("amountOfFood",foodLeft - 1);
    }
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
}
