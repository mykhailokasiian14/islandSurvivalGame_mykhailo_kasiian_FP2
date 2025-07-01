package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Duck extends Herbivore {

    public Duck() {
        weight = 1;
        maxCountPerCell = 200;
        speed = 4;
        foodNeed = 1.95;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Duck();
    }

}
