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
    public void initializeParkElements()
    {
        addParkElement("AnimalsWithWings", "BlueJay", 1, 1, true, 24, (whatItEats.BLUE_JAY.toString()).split(","));
        addParkElement("GroundAnimals","Fox", 5, 5, true, 22, (whatItEats.FOX.toString()).split(","));
        addParkElement("Insects", "Caterpillar", 7, 7,true,1,(whatItEats.CATERPILLAR.toString()).split(","));
        addParkElement("EdibleObject", "Trees/Shrubs", 9, 9, 90);
        addParkElement("NonEdibleObject", "Rock", 10, 10, 1000);
    }
    public void runPark()
    {
        // this is where park will tell the animals to move and perform actions.
    }
    private String findParkElementName(int xCoord, int yCoord)
    {
        String returnString = "x";
        for (int i = 0; i < inventory.size(); i++) 
        {
            if (inventory.get(i) instanceof AnimalsWithWings)
            {
                Object temp = inventory.get(i);
                AnimalsWithWings animalWithWings = (AnimalsWithWings) temp;
                if (animalWithWings.getXCoords() == xCoord && animalWithWings.getYCoords() == yCoord)
                {
                    temp = animalWithWings.getProperty("elementName");
                    returnString = temp.toString();
                    break;
                }
            }
            else if (inventory.get(i) instanceof GroundAnimals)
            {
                Object temp = inventory.get(i);
                GroundAnimals groundAnimal = (GroundAnimals) temp;
                if (groundAnimal.getXCoords() == xCoord && groundAnimal.getYCoords() == yCoord)
                {
                    temp = groundAnimal.getProperty("elementName");
                    returnString = temp.toString();
                    break;
                }
            }
            else if (inventory.get(i) instanceof Insects)
            {
                Object temp = inventory.get(i);
                Insects insect = (Insects) temp;
                if (insect.getXCoords() == xCoord && insect.getYCoords() == yCoord)
                {
                    temp = insect.getProperty("elementName");
                    returnString = temp.toString();
                }
                
            }
            else if (inventory.get(i) instanceof EdibleObject)
            {
                Object temp = inventory.get(i);
                EdibleObject edibleObject = (EdibleObject) temp;
                if (edibleObject.getXCoords() == xCoord && edibleObject.getYCoords() == yCoord)
                {
                    temp = edibleObject.getProperty("elementName");
                    returnString = temp.toString();
                    break;
                }
                
            }
            else if (inventory.get(i) instanceof NonEdibleObject)
            {
                Object temp = inventory.get(i);
                NonEdibleObject nonEdibleObject = (NonEdibleObject) temp;
                if (nonEdibleObject.getXCoords() == xCoord && nonEdibleObject.getYCoords() == yCoord)
                {
                    temp = nonEdibleObject.getProperty("elementName");
                returnString = temp.toString();
                }
            }   
        }
        return returnString;
    }
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
            default: return 'x';
        }
    }
    
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
    
        for (int i = 0; i < parkMap[i].length; i++)
        {
            for (int j = 0; j < parkMap.length; j++)
            {
                if (parkMap[i][j] != null)
                {
                    ParkElement printElement = parkMap[i][j].getParkElement();
                    System.out.print(elementNameToChar(findParkElementName(i,j)));
                }
                else
                {
                    System.out.print("x");
                }
            }
            System.out.print('\n');
        }
    }
}
