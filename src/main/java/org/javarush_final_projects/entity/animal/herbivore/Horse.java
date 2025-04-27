package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Horse extends Herbivore{
    public Horse() {
        weight = 400;
        maxCountPerCell = 20;
        speed = 4;
        foodNeed = 50;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Horse();
    }
}
