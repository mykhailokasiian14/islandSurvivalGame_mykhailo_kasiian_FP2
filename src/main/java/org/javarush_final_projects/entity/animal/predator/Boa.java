package org.javarush_final_projects.entity.animal.predator;

import org.javarush_final_projects.entity.animal.Animal;
import org.javarush_final_projects.entity.animal.herbivore.Duck;
import org.javarush_final_projects.entity.animal.herbivore.Mouse;
import org.javarush_final_projects.entity.animal.herbivore.Rabbit;

public class Boa extends Predator {
    public Boa() {
        weight = 15;
        maxCountPerCell = 30;
        speed = 1;
        foodNeed = 2;
        currentFood = foodNeed;
        diet.put(Rabbit.class, 20);
        diet.put(Mouse.class, 40);
        diet.put(Fox.class, 15);
        diet.put(Duck.class, 10);
    }

    public Animal reproduce() {
        return new Boa();
    }
}
