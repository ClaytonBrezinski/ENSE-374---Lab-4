/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ense.pkg374.lab.pkg4;
import java.util.Collection;

/**
 *
 * @author Clayton
 */
public interface ParkElement 
{
    public void create(String animalName, boolean isMale, int age, String[] whatItEats);
    public void create(String organismName, int age);
    public Collection getProperties();
    public Object getProperty(String propertyName);
    public void setProperty(String propertyName, String value);
    public void setProperty(String propertyName, int value);
    public String[] whatItEats();
    public int getMaxTravelDistance();
    public void beenEaten();
    public boolean isLivingThing();
}
