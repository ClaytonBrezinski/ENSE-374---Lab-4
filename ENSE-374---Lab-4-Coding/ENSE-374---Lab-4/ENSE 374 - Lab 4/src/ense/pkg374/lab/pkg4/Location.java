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
    
    /* 
    Purpose: default constuctor
    Returns:
    */
    public Location()
    {
        this.xCoordinate = 1;
        this.yCoordinate = 1;
        parkElement = null;
    }
    
    /* 
    Purpose: custom constructor based off of user inputs
    Returns:
    */
    public Location(int xCo, int yCo, ParkElement element)
    {
        this.xCoordinate = xCo;
        this.yCoordinate = yCo;
        this.parkElement = element;
    }
    
    /* 
    Purpose: 
    Returns: int- x coordinate of the location
    */
    public int getXLocation()
    {
        return xCoordinate;
    }
    
    /* 
    Purpose: 
    Returns: int- y coordinate of the location
    */
    public int getYLocation()
    {
        return yCoordinate;
    }
    
    /* 
    Purpose: 
    Returns: ParkElement - the current ParkElement within in the location
    */
    public ParkElement getParkElement()
    {
        return parkElement;
    }
    
    /* 
    Purpose: 
    Returns: String - the park element's name
    */
    public String getParkElementName()
    {
        Object temp = parkElement.getProperty("elementName");
        return temp.toString();
    }
        
    /* 
    Purpose: set the parkElement to the given element
    Returns:
    */
    public void setParkElement(ParkElement element)
    {
         this.parkElement = element;
    }
}

