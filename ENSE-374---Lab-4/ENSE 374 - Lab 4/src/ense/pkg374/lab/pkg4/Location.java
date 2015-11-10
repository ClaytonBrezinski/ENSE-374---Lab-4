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
public class Location 
{
    private int xCoordinate;
    private int yCoordinate;
    private ParkElement parkElement;
    public Location()
    {
        this.xCoordinate = 1;
        this.yCoordinate = 1;
        parkElement = null;
    }
    public Location(int xCo, int yCo, ParkElement element)
    {
        this.xCoordinate = xCo;
        this.yCoordinate = yCo;
        this.parkElement = element;
    }
    public int getXLocation()
    {
        return xCoordinate;
    }
    public int getYLocation()
    {
        return yCoordinate;
    }
    public ParkElement getParkElement()
    {
        return parkElement;
    }
    public void setXLocation(int xCo)
    {
        this.xCoordinate = xCo;
    }
    public void setYLocation(int yCo)
    {
        this.yCoordinate = yCo;
    }
    public void setParkElement(ParkElement element)
    {
         this.parkElement = element;
    }
}
