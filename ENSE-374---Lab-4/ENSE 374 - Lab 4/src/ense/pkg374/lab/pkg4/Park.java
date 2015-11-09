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

    public void park()
    {
        inventory = new LinkedList();
    }
    public void addParkElement(String type, String animalName, int xStart, int yStart, boolean isMale, int age, String[] whatItEats)
    {
        if (type == "AnimalsWithWings")
        {
            AnimalsWithWings parkElement = new AnimalsWithWings(animalName, xStart, yStart, isMale, age, whatItEats);
            inventory.add(parkElement);
        }
        else if (type == "GroundAnimals")
        {
            GroundAnimals parkElement = new GroundAnimals(animalName, xStart, yStart, isMale, age, whatItEats);
            inventory.add(parkElement);
        }
        else if (type == "Insects")
        {
            Insects parkElement = new Insects(animalName, xStart, yStart, isMale, age, whatItEats);
            inventory.add(parkElement);         
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
            EdibleObject parkElement = new EdibleObject(organismName, xCo, yCo, age);
            inventory.add(parkElement);       
        }
        else if (type == "NonEdibleObject")
        {
            NonEdibleObject parkElement = new NonEdibleObject(organismName, xCo, yCo, age);
            inventory.add(parkElement);        
        }
        else
        {
            // error in addParkElement area
        }
    }
    ParkElement initializeParkElement()
    {
        
    }
}
