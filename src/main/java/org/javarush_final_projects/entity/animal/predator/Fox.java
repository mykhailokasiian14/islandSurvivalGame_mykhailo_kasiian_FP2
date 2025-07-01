package org.javarush_final_projects.entity.animal.predator;

import org.javarush_final_projects.entity.animal.Animal;
import org.javarush_final_projects.entity.animal.herbivore.Caterpillar;
import org.javarush_final_projects.entity.animal.herbivore.Duck;
import org.javarush_final_projects.entity.animal.herbivore.Mouse;
import org.javarush_final_projects.entity.animal.herbivore.Rabbit;

public class Fox extends Predator{
    public Fox() {
        weight = 8;
        maxCountPerCell = 30;
        speed = 2;
        foodNeed = 2;
        currentFood = foodNeed;
        diet.put(Rabbit.class, 70);
        diet.put(Mouse.class, 90);
        diet.put(Duck.class, 60);
        diet.put(Caterpillar.class, 40);
    }

    public Animal reproduce() {
        return new Fox();
    }
}
