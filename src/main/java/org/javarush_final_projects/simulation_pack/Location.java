package org.javarush_final_projects.simulation_pack;

import org.javarush_final_projects.entity.animal.Animal;
import org.javarush_final_projects.entity.plant.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private final List<Animal> animals = new CopyOnWriteArrayList<>();
    public final List<Plant> plants = new CopyOnWriteArrayList<>();
    private final int x, y;
    private final Island island;
    private int plantCount;

    public Location(int x, int y, Island island) {
        this.x = x;
        this.y = y;
        this.island = island;
    }

    public synchronized void processAnimals() {
        List<Animal> toRemove = new ArrayList<>();
        for (Animal animal : animals) {
            animal.decayHunger();
            if (animal.isStarving()) {
                toRemove.add(animal);
                continue;
            }
            animal.eat(this);
            animal.move(this);
            animal.tryReproduce(this);
        }
        animals.removeAll(toRemove);
        for (Animal dead : toRemove) {
            island.registerDeath();
        }
    }

    public synchronized void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void growPlants() {
        if (plantCount < 200)
            plantCount++;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public synchronized void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public synchronized void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public int getPlantCount() {
        return plants.size();
    }

    public synchronized void consumePlants(double amount) {
        int toRemove = (int) Math.ceil(amount);
        for (int i = 0; i < toRemove && !plants.isEmpty(); i++) {
            plants.remove(0);
        }
    }

    public Island getIsland() {
        return island;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
