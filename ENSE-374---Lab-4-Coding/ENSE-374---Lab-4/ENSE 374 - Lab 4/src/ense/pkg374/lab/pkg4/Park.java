/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;
/**
 *
 * @author Clayton
 */
public class Park 
{
    private List inventory;
    private Location[][] parkMap;
    private int xMax;
    private int yMax;

    /* 
    Purpose: Default constructor 
    Returns:
    */
    public Park()
    {
        inventory = new LinkedList();
        xMax = 100;
        yMax = 100;
        parkMap = new Location[xMax][yMax];
        
    }
    
    /* 
    Purpose: Custom constructor when user enters bounds
    Returns:
    */
    public Park(int xMaxG, int yMaxG)
    {
        inventory = new LinkedList();
        parkMap = new Location[xMaxG][yMaxG];
        xMax = xMaxG;
        yMax = yMaxG;
    }
    
    /* 
    Purpose: adds a parkElement to the parkMap. Based on the given inputs this creates a living thing
    Returns:
    */
    public void addParkElement(String type, String animalName, int xStart, int yStart, boolean isMale, int age, String[] whatItEat)
    {
        if (type == "AnimalsWithWings")
        {
            AnimalsWithWings instantiatedElement = new AnimalsWithWings(animalName,isMale, age, whatItEat);
            inventory.add(instantiatedElement);
            parkMap[xStart][yStart] = new Location(xStart, yStart, instantiatedElement);

        }
        else if (type == "GroundAnimals")
        {
            GroundAnimals instantiatedElement = new GroundAnimals(animalName, isMale, age, whatItEat);
            inventory.add(instantiatedElement);
            parkMap[xStart][yStart] = new Location(xStart, yStart, instantiatedElement);  
        }
        else if (type == "Insects")
        {
            Insects instantiatedElement = new Insects(animalName, isMale, age, whatItEat);
            inventory.add(instantiatedElement); 
            parkMap[xStart][yStart] = new Location(xStart, yStart, instantiatedElement);   
        }
        else
        {
            // error in addParkElement area
        }
    }
    
    /* 
    Purpose: adds a parkElement to the parkMap. Based on the given inputs this creates a non living thing
    Returns:
    */
    public void addParkElement(String type, String organismName, int xCo, int yCo, int age)
    {
        if  (type == "EdibleObject")
        {
            EdibleObject instantiatedElement = new EdibleObject(organismName, age);
            inventory.add(instantiatedElement);
            parkMap[xCo][yCo] = new Location(xCo, yCo, instantiatedElement); 
        }
        else if (type == "NonEdibleObject")
        {
            NonEdibleObject instantiatedElement = new NonEdibleObject(organismName, age);
            inventory.add(instantiatedElement);
            parkMap[xCo][yCo] = new Location(xCo, yCo, instantiatedElement); 
        }
        else
        {
            // error in addParkElement area
        }
    }
    
    /* 
    Purpose: adds parkElements to the parkMap
    Returns:
    */
    public void initializeParkElements()
    {
        addParkElement("AnimalsWithWings", "BlueJay", 1, 1, true, 24, (whatItEats.BLUE_JAY.toString()).split(","));
        addParkElement("GroundAnimals","Fox", 1, 2, true, 22, (whatItEats.FOX.toString()).split(","));
        addParkElement("Insects", "Caterpillar", 1, 3,true,1,(whatItEats.CATERPILLAR.toString()).split(","));
        addParkElement("EdibleObject", "Trees/Shrubs", 1, 4, 90);
        addParkElement("NonEdibleObject", "Rock", 1, 5, 1000);
    }
    
    /* 
    Purpose: runs the park simulation for each day
    Returns:
    */
    public void runPark()
    {
        boolean endSim = false;
        
        while (endSim == false)
        {
        for (int i = 0; i < parkMap.length; i++)
        {
            for (int j = 0; j < parkMap[i].length; j++)
            {
                if (parkMap[i][j] != null)
                {
                    // determine food that the organism can eat
                    String[] whatItEats = parkMap[i][j].getParkElement().whatItEats();
                    // search for closest food for the organism and set the closest food's coords
                    int [] closeFoodCoords = searchForClosestFood(i,j,whatItEats);
                    // if -1,-1 have the organsim stay stationary, they cannot detect any food within a 10x10 square of them.
                    if ( closeFoodCoords[0] != -1 && closeFoodCoords[1] != -1)
                    {
                        // get the organism's max travelling distance
                        int maxTravelDistance = parkMap[i][j].getParkElement().getMaxTravelDistance();
                        // get the # of tiles between the organism and the food
                        int distance = closeFoodCoords[0] + closeFoodCoords[1] - 1; 
                        // if distance <= maxTravellingDistance, have the organism eat the other organism and take its spot
                        if (distance <= maxTravelDistance)
                        {
                            // if edible object, \
                            if (parkMap[closeFoodCoords[0]][closeFoodCoords[1]].getParkElement().isLivingThing() == false)
                            {
                                parkMap[closeFoodCoords[0]][closeFoodCoords[1]].getParkElement().beenEaten();
                                ParkElement moveElement = parkMap[i][j].getParkElement();
                                parkMap[closeFoodCoords[0] - 1][closeFoodCoords[1]].setParkElement(moveElement);
                                parkMap[i][j].setParkElement(null);
                            }
                            else // set the eaten organism to no longer alive and remove it from the map
                            {
                                
                            }
                            
                            parkMap[closeFoodCoords[0]][closeFoodCoords[1]].getParkElement().beenEaten();
                            // place the current organism in the place of the eaten organism
                            ParkElement moveElement = parkMap[i][j].getParkElement();
                            parkMap[closeFoodCoords[0]][closeFoodCoords[1]].setParkElement(moveElement);
                        }
                        else // if distance > maxTravellingDistance close the distance between the organism and the closest food
                        {
                            int [] currentCords = {i,j};
                            currentCords = closeDistance(maxTravelDistance, currentCords, closeFoodCoords);

                            ParkElement moveElement = parkMap[i][j].getParkElement();
                            parkMap[currentCords[0]][currentCords[1]].setParkElement(moveElement);
                        }
                        
                        ParkElement moveElement = parkMap[i][j].getParkElement();
                        parkMap[closeFoodCoords[0]][closeFoodCoords[1]].setParkElement(moveElement);
                        
                    }
                    
                    // copy the current parkElement and place it in the position it will move to

                } 
            }
            //increment animal has been eaten 
        }
        
        }
    }
    
    /* 
    Purpose: from given element name, it determines the corresponding letter to indicate the element on the program
    Returns: char- the corresponding letter to the given element
    */
    private char elementNameToChar(String elementName)
    {
        switch(elementName)
        {
            case("Caterpillar"): return 'C';
            case("Trees/Shrubs"):return 'T';
            case("BlueJay"):return 'B';
            case("Hawk"):return 'H';
            case("Grasshopper"):return 'G';
            case("Mouse"):return 'M';       
            case("Fox"):return 'F';   
            case("Squirrel"):return 'S';    
            case("Rabbit"):return 'R';   
            case("Grass"):return 'O';   
            case("Deer"):return 'D';
            case("Wolf"):return 'w';
            default: return '.';
        }
    }
    
    /* 
    Purpose: print the park onto the command line
    Returns:
    */
    public void printPark()
    {
        System.out.println("C - caterpillar");
        System.out.println("T - trees/shrubs");
        System.out.println("B - bluejay");
        System.out.println("H - hawk");
        System.out.println("G - grasshopper");
        System.out.println("M - mouse");
        System.out.println("F - fox");
        System.out.println("S - squirrel");
        System.out.println("R - rabbit");
        System.out.println("O - grass");
        System.out.println("D - deer");
        System.out.println("W - wolf");
    
        for (int i = 0; i < parkMap.length; i++)
        {
            for (int j = 0; j < parkMap[i].length; j++)
            {
                if (parkMap[i][j] != null)
                {  
                    System.out.print(elementNameToChar(parkMap[i][j].getParkElement().getProperty("elementName").toString()));
                }
                else
                {
                    System.out.print('.');
                }
            }
            System.out.print('\n');
        }
    }
    
    /* 
    Purpose: Search algorithm used by the animal in order to find food that it can eat
    Returns: int[] coords of the closest food to the animal within a distance of 10.
    */
    private int[] searchForClosestFood(int xCo, int yCo, String[] foodToSearchFor)
    {
        int maxDistance = 10;
        int xPos = -1;
        int yPos = -1;
        for (int d = 1; d < maxDistance; d++)
        {
            for (int i = 0; i < d + 1; i++)
            {
                int x1 = xCo - d + i;
                int y1 = yCo - i;

                // Check point (x1, y1) and that x & y stay within bounds
                if (x1 <= xMax && y1 <= yMax)
                {
                    if (foodMatchesElement(x1, y1, foodToSearchFor) == true)
                    {
                        xPos = x1;
                        yPos = y1;
                    }
                }
                int x2 = xCo + d - i;
                int y2 = yCo + i;

                // Check point (x2, y2) and that x & y stay within bounds
                if (x2 <= xMax && y2 <= yMax)
                {
                    if (foodMatchesElement(x2, y2, foodToSearchFor) == true)
                    {
                        xPos = x2;
                        yPos = y2;
                    }
                }
            }
            for (int i = 1; i < d; i++)
            {
                int x1 = xCo - i;
                int y1 = yCo + d - i;
                
                // Check point (x1, y1) and that x & y stay within bounds
                if (x1 <= xMax && y1 <= yMax)
                {
                    if (foodMatchesElement(x1, y1, foodToSearchFor) == true)
                    {
                        xPos = x1;
                        yPos = y1;
                    }
                }

                int x2 = xCo + d - i;
                int y2 = yCo - i;

                // Check point (x2, y2) and that x & y stay within bounds
                if (x2 <= xMax && y2 <= yMax)
                {
                    if (foodMatchesElement(x2, y2, foodToSearchFor) == true)
                    {
                        xPos = x2;
                        yPos = y2;
                    }
                }
            }
        }
       
        int [] ret = {xPos,yPos};
        return ret;
    }
    
    /* 
    Purpose: checks if the element at the current location is food that the given animal can consume
    Returns: boolean - true: organism can eat it, false: organism cannot eat it
    */
    private boolean foodMatchesElement(int xCo, int yCo, String[] foodToSearchFor)
    {
        for (int i = 0; i < foodToSearchFor.length; i++)
        {
            if (parkMap[xCo][yCo].getParkElementName().equalsIgnoreCase(foodToSearchFor[i]) == true);
            {
                return true;
            }
        }
        return false;
    }
    
    /* 
    Purpose: given the coordinates of where the animal wishes to travel and where it currently is, tell the animal where to go
    Returns: int[]- location the animal should travel to based on the given coordinates
    */
    private int[] closeDistance(int maxTravelDistance, int[] currentCords, int desiredCords[])
    {
        int xDifference = currentCords[0] - desiredCords[0];
        int yDifference = currentCords[1] - desiredCords[1];
        int negMaxTravelDistance = maxTravelDistance * - 1;
        int ret[] = {0,0};
        
        if (xDifference > maxTravelDistance)
        {
            ret[0] = maxTravelDistance + currentCords[0];
        }
        else if (xDifference < negMaxTravelDistance)
        {
            ret[0] = negMaxTravelDistance + currentCords[0];
        }
        else if (xDifference < maxTravelDistance && xDifference > 0)
        {
            ret[0] = xDifference + currentCords[0];
            ret[1] = (maxTravelDistance - xDifference) + currentCords[1];
        }
        else if (xDifference > negMaxTravelDistance && xDifference < 0)
        {
            ret[0] = xDifference + currentCords[0];
            ret[1] = (maxTravelDistance + xDifference) + currentCords[1];
        }
        else if (xDifference == 0 && yDifference > maxTravelDistance )
        {
            ret[1] = maxTravelDistance + currentCords[1];
        }
        else if (xDifference == 0 && yDifference < negMaxTravelDistance)
        {
            ret[1] = negMaxTravelDistance + currentCords[1];
        }
        else if ( Math.abs(yDifference) < maxTravelDistance)
        {
            ret[1] = yDifference + currentCords[1];
        }
                
        return ret;
    }
}
