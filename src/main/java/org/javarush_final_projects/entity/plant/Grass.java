package org.javarush_final_projects.entity.plant;

import org.javarush_final_projects.entity.Organism;

public class Grass extends Plant {
    public Organism reproduce() {
        return new Grass();
    }
    public Grass() {
        weight = 1;
    }
}
