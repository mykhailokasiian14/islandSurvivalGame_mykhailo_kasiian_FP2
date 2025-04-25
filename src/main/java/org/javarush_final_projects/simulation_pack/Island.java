package org.javarush_final_projects.simulation_pack;

import org.javarush_final_projects.entity.animal.AnimalFactory;
import org.javarush_final_projects.entity.plant.Grass;

import java.util.Map;
import java.util.Random;

public class Island {
    private final Location[][] map;
    private final Config config;
    private final Random random = new Random();


    public Island(Config config) {
        this.config = config;
        map = new Location[config.width][config.height];
        for (int x = 0; x < config.width; x++) {
            for (int y = 0; y < config.height; y++) {
                map[x][y] = new Location(x, y, this);
            }
        }
        populateAnimals();
    }

    public Location getLocation(int x, int y) {
        if (x >= 0 && y >= 0 && x < config.width && y < config.height) {
            return map[x][y];
        }
        return null;
    }

    public void growPlants() {
        for (Location[] row : map) {
            for (Location loc : row) {
                loc.growPlants();
            }
        }
    }

    public boolean allAnimalsDead() {
        for (Location[] row : map) {
            for (Location loc : row) {
                if (!loc.getAnimals().isEmpty())
                    return false;
            }
        }
        return true;
    }

    private int bornLastTick = 0;
    private int diedLastTick = 0;
    public void resetTickStats() {
        bornLastTick = 0;
        diedLastTick = 0;
    }

    public void registerBirth() {
        bornLastTick++;
    }

    public void registerDeath() {
        diedLastTick++;
    }

    public String getStatistics() {
        int totalAnimals = 0;
        for (Location[] row : map) {
            for (Location loc : row) {
                totalAnimals += loc.getAnimals().size();
            }
        }
        String stats = "Total animals: " + totalAnimals +
                ", Born last tick: " + bornLastTick +
                ", Died last tick: " + diedLastTick;
        resetTickStats();
        return stats;
    }

    private void populateAnimals() {
        for (Map.Entry<String, Integer> entry : config.initialAnimalCounts.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                int x = random.nextInt(config.width);
                int y = random.nextInt(config.height);
                Location loc = getLocation(x, y);
                loc.addAnimal(AnimalFactory.create(entry.getKey()));
            }
        }
    }
}