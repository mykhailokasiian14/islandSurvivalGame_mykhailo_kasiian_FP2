package org.javarush_final_projects.entity.animal.predator;

import org.javarush_final_projects.entity.animal.Animal;
import org.javarush_final_projects.entity.animal.herbivore.*;

public class Bear extends Predator {
    public Bear() {
        weight = 500;
        maxCountPerCell = 5;
        speed = 2;
        foodNeed = 70;
        currentFood = foodNeed;
        diet.put(Rabbit.class, 80);
        diet.put(Mouse.class, 90);
        diet.put(Boa.class, 80);
        diet.put(Horse.class, 40);
        diet.put(Deer.class, 80);
        diet.put(Goat.class, 70);
        diet.put(Sheep.class, 70);
        diet.put(Boar.class, 50);
        diet.put(Buffalo.class, 20);
        diet.put(Duck.class, 10);
    }

    public Animal reproduce() {
        return new Bear();
    }

}
