package org.javarush_final_projects.entity.animal.predator;

import org.javarush_final_projects.entity.animal.Animal;
import org.javarush_final_projects.entity.animal.herbivore.*;

public class Wolf extends Predator{

    public Wolf() {
        weight = 50;
        maxCountPerCell = 30;
        speed = 3;
        foodNeed = 6;
        currentFood = foodNeed;
        diet.put(Rabbit.class, 60);
        diet.put(Mouse.class, 80);
        diet.put(Deer.class, 15);
        diet.put(Horse.class, 10);
        diet.put(Goat.class, 60);
        diet.put(Sheep.class, 70);
        diet.put(Boar.class, 15);
        diet.put(Buffalo.class, 10);
        diet.put(Duck.class, 40);
    }

    public Animal reproduce() {
        return new Wolf();
    }
}
