package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Buffalo extends Herbivore{
    public Buffalo() {
        weight = 700;
        maxCountPerCell = 10;
        speed = 3;
        foodNeed = 80;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Buffalo();
    }
}
