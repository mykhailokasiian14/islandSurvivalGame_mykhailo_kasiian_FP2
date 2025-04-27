package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Deer extends Herbivore{
    public Deer() {
        weight = 300;
        maxCountPerCell = 20;
        speed = 4;
        foodNeed = 40;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Deer();
    }
}
