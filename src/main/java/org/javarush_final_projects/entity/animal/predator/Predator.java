package org.javarush_final_projects.entity.animal.predator;

import org.javarush_final_projects.entity.animal.Animal;
import org.javarush_final_projects.simulation_pack.Location;

import java.util.HashMap;
import java.util.Map;

public abstract class Predator extends Animal {
    protected Map<Class<? extends Animal>, Integer> diet = new HashMap<>();

    public void eat(Location location) {
        if (!isHungry()) return;
        for (Animal prey : location.getAnimals()) {
            if (diet.containsKey(prey.getClass())) {
                if (random.nextInt(100) < diet.get(prey.getClass())) {
                    currentFood += prey.weight;
                    location.removeAnimal(prey);
                    break;
                }
            }
        }
    }
}
