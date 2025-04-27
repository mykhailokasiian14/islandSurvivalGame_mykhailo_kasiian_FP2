package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Caterpillar extends Herbivore{
    public Caterpillar() {
        weight = 0.01;
        maxCountPerCell = 1000;
        speed = 1;
        foodNeed = 0.81;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Caterpillar();
    }
}
