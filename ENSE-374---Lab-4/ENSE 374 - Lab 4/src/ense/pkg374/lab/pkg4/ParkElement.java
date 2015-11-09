/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;

/**
 *
 * @author Clayton
 */
public class ParkElement 
{
    private int xLocation;
    private int yLocation;
    private boolean alive;

    void initializeParkElement(int xCo, int yCo)
    {
       this.xLocation = xCo;
       this.yLocation = yCo;
    }
    int getXLocation()
    {
        return xLocation;
    }
    int getYLocation()
    {
        return yLocation;
    }
    String getLocation()
    {
        int xCo = getXLocation();
        int yCo = getYLocation();
        String returnString = xCo + "," + yCo;
        return returnString;      
    }
    boolean getStatus()
    {
        return alive;
    }
}
