package org.javarush_final_projects.entity.plant;

public class Algae extends Plant{
    public Plant reproduce() {
        return new Algae();
    }
    public Algae() {
        weight = 0.5;
    }
}
