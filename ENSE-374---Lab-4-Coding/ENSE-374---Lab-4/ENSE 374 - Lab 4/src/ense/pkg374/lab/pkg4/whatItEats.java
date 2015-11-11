/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;

import java.util.Arrays;

/**
 *
 * @author Clayton
 */
public enum whatItEats 
{
    CATERPILLAR, BLUE_JAY, HAWK, GRASSHOPPER, MOUSE, FOX, SQUIRREL, RABBIT, DEER, WOLF;
    
    @Override
    public String toString()
    {
        switch(this)
        {
            case CATERPILLAR:     return "TREES_SHRUBS";
            case BLUE_JAY:        return "CATERPILLAR, GRASSHOPPER, TREES_SHRUBS";
            case HAWK:            return "MOUSE, SQUIRREL";
            case GRASSHOPPER:     return "GRASS";
            case MOUSE:           return "TREES_SHRUBS, GRASS";
            case FOX:             return "BLUE_JAY, MOUSE, SQUIRREL, RABBIT";
            case SQUIRREL:        return "TREES_SHRUBS";
            case RABBIT:          return "GRASS";
            case DEER:            return "TREES_SHRUBS, GRASS";
            case WOLF:            return "RABBIT, DEER";
            default:              return "Unspecified";   
        }
    }
}

