package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Goat extends  Herbivore{
    public Goat() {
        weight = 60;
        maxCountPerCell = 140;
        speed = 3;
        foodNeed = 7;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Goat();
    }
}
