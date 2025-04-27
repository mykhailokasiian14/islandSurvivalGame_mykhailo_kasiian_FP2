package org.javarush_final_projects.entity.animal.predator;

import org.javarush_final_projects.entity.animal.Animal;
import org.javarush_final_projects.entity.animal.herbivore.Duck;
import org.javarush_final_projects.entity.animal.herbivore.Mouse;
import org.javarush_final_projects.entity.animal.herbivore.Rabbit;

public class Eagle extends Predator{
    public Eagle() {
        weight = 6;
        maxCountPerCell = 20;
        speed = 3;
        foodNeed = 1;
        currentFood = foodNeed;
        diet.put(Rabbit.class, 90);
        diet.put(Mouse.class, 90);
        diet.put(Duck.class, 80);
    }
    public Animal reproduce() {
        return new Eagle();
    }
}
