package org.javarush_final_projects.entity.plant;

public class Bush extends Plant{
    public Plant reproduce() {
        return new Bush();
    }
    public Bush() {
        weight = 3;
    }
}
