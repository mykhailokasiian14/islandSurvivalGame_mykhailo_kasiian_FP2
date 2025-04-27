package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Boar extends Herbivore {
    public Boar() {
        weight = 400;
        maxCountPerCell = 50;
        speed = 2;
        foodNeed = 35;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Boar();
    }
}
