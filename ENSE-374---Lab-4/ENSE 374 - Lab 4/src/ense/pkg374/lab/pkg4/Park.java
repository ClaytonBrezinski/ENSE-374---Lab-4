/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Clayton
 */
public class Park 
{
    private List inventory;
    private Location[][] parkMap;

    public Park()
    {
        inventory = new LinkedList();
        parkMap = new Location[100][100];
    }
    public Park(int xMax, int yMax)
    {
        inventory = new LinkedList();
        parkMap = new Location[xMax][yMax];
    }
    public void addParkElement(String type, String animalName, int xStart, int yStart, boolean isMale, int age, String[] whatItEat)
    {
        if (type == "AnimalsWithWings")
        {
            AnimalsWithWings instantiatedElement = new AnimalsWithWings(animalName, xStart, yStart, isMale, age, whatItEat);
            inventory.add(instantiatedElement);
            ParkElement parkElement = instantiatedElement.getParkElement();
            parkMap[xStart][yStart] = new Location(xStart, yStart, parkElement);

        }
        else if (type == "GroundAnimals")
        {
            GroundAnimals instantiatedElement = new GroundAnimals(animalName, xStart, yStart, isMale, age, whatItEat);
            inventory.add(instantiatedElement);
            ParkElement parkElement = instantiatedElement.getParkElement();
            parkMap[xStart][yStart] = new Location(xStart, yStart, parkElement);  
        }
        else if (type == "Insects")
        {
            Insects instantiatedElement = new Insects(animalName, xStart, yStart, isMale, age, whatItEat);
            inventory.add(instantiatedElement); 
            ParkElement parkElement = instantiatedElement.getParkElement();
            parkMap[xStart][yStart] = new Location(xStart, yStart, parkElement);   
        }
        else
        {
            // error in addParkElement area
        }
    }
    public void addParkElement(String type, String organismName, int xCo, int yCo, int age)
    {
        if  (type == "EdibleObject")
        {
            EdibleObject instantiatedElement = new EdibleObject(organismName, xCo, yCo, age);
            inventory.add(instantiatedElement);
            ParkElement parkElement = instantiatedElement.getParkElement();
            parkMap[xCo][yCo] = new Location(xCo, yCo, parkElement); 
        }
        else if (type == "NonEdibleObject")
        {
            NonEdibleObject instantiatedElement = new NonEdibleObject(organismName, xCo, yCo, age);
            inventory.add(instantiatedElement);
            ParkElement parkElement = instantiatedElement.getParkElement();
            parkMap[xCo][yCo] = new Location(xCo, yCo, parkElement); 
        }
        else
        {
            // error in addParkElement area
        }
    }
    void initializeParkElements()
    {
        addParkElement("AnimalsWithWings", "blueJay", 1, 1, true, 24, (whatItEats.BLUE_JAY.toString()).split(","));
        addParkElement("GroundAnimals","Fox", 5, 5, true, 22, (whatItEats.FOX.toString()).split(","));
        addParkElement("Insects", "Caterpillar", 7, 7,true,1,(whatItEats.CATERPILLAR.toString()).split(","));
        addParkElement("EdibleObject", "Trees/Shrubs", 9, 9, 90);
        addParkElement("NonEdibleObject", "Rock", 10, 10, 1000);
    }
    void runPark()
    {
        // this is where park will tell the animals to move and perform actions.
    }
    void findParkElement(int xCoord, int yCoord)
    {
        for (int i = 0; i < inventory.size(); i++) 
        {
            if (inventory.get(i) instanceof AnimalsWithWings)
            {
                String temp = inventory.get(i).toString();
                int o = 0;
            }
        }
    }
    void printPark()
    {
        for (int j = 0; j < parkMap[j].length; j++)
        {
            for (int i = 0; i < parkMap.length; i++)
            {
                if (parkMap[j][i] != null)
                {
                    ParkElement printElement = parkMap[j][i].getParkElement();
                    printElement.getCoords();
                }
                else
                {
                    System.out.print("x");
                }
            }
        }
        
    }
}
