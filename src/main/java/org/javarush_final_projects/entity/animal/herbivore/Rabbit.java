package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Rabbit extends Herbivore{
    public Rabbit() {
        weight = 2;
        maxCountPerCell = 150;
        speed = 2;
        foodNeed = 1.75;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Rabbit();
    }
}
