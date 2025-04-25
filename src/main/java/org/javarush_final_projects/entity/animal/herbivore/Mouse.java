package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;

public class Mouse extends Herbivore{
    public Mouse() {
        weight = 0.05;
        maxCountPerCell = 500;
        speed = 1;
        foodNeed = 1.11;
        currentFood = foodNeed;
    }

    public Animal reproduce() {
        return new Mouse();
    }
}
