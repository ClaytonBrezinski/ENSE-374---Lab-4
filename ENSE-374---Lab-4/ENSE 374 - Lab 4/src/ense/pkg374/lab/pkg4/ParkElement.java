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
    private Location location;
    private boolean alive;

    void initializeParkElement(int xCo, int yCo)
    {
       location = new Location(xCo,yCo);
    }
    int getXCoords()
    {
        return location.getXLocation();
    }
    int getYCoords()
    {
        return location.getYLocation();
    }
    void setXYCoords(int x, int y)
    {
        location.setXLocation(x);
        location.setYLocation(y);
    }
    String getCoords()
    {
        int xCo = location.getXLocation();
        int yCo = location.getYLocation();
        String returnString = xCo + "," + yCo;
        return returnString;      
    }
    boolean getStatus()
    {
        return alive;
    }
}
