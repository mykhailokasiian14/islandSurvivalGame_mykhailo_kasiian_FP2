package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Sheep extends Herbivore {
    public Sheep() {
        weight = 70;
        maxCountPerCell = 140;
        speed = 3;
        foodNeed = 13;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Sheep();
    }
}
