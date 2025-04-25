package org.javarush_final_projects.entity.animal;

import org.javarush_final_projects.entity.Organism;
import org.javarush_final_projects.interfaces.Eatable;
import org.javarush_final_projects.interfaces.Movable;
import org.javarush_final_projects.interfaces.Reproducible;
import org.javarush_final_projects.simulation_pack.Location;

import java.util.Random;

public abstract class Animal extends Organism implements Movable, Eatable, Reproducible {
    public double weight;
    protected int maxCountPerCell;
    protected int speed;
    protected double foodNeed;
    protected double currentFood;
    protected Random random = new Random();

    public abstract Animal reproduce();

    public void move(Location current) {
        int dx, dy;
        do {
            dx = random.nextInt(2 * speed + 1) - speed;
            dy = random.nextInt(2 * speed + 1) - speed;
        } while (dx == 0 && dy == 0);
        Location next = current.getIsland().getLocation(current.getX() + dx, current.getY() + dy);
        if (next != null && next.getAnimals().size() < maxCountPerCell) {
            current.removeAnimal(this);
            next.addAnimal(this);
        }
    }

    public void tryReproduce(Location location) {
        long sameSpeciesCount = location.getAnimals().stream()
                .filter(a -> a.getClass() == this.getClass()).count();
        if (sameSpeciesCount > 1) {
            Animal offspring = reproduce();
            location.addAnimal(offspring);
            location.getIsland().registerBirth();
        }
    }

    protected double foodDecayRate = 0.59;

    public boolean isHungry() {
        return currentFood < foodNeed;
    }

    public boolean isStarving() {
        return currentFood <= 0;
    }

    public void decayHunger() {
        currentFood -= foodDecayRate;
        if (currentFood < 0) {
            currentFood = 0;
        }
    }

}
