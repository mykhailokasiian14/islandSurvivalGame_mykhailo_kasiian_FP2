package org.javarush_final_projects.entity.animal.herbivore;

import org.javarush_final_projects.entity.animal.Animal;
import org.javarush_final_projects.simulation_pack.Location;

public abstract class Herbivore extends Animal {
    public void eat(Location location) {
        if (!isHungry()) return;
        if (location.getPlantCount() > 0) {
            location.consumePlants(foodNeed);
            currentFood += foodNeed;
        }
    }
}
