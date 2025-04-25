package org.javarush_final_projects.simulation_pack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Simulation {
    private final Island island;
    private final Config config;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

    public Simulation(Island island, Config config) {
        this.island = island;
        this.config = config;
    }

    public void start() {
        scheduler.scheduleAtFixedRate(this::growPlants, 0, config.tickDuration, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(this::animalLifeCycle, 0, config.tickDuration, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(this::printStats, 0, config.tickDuration, TimeUnit.MILLISECONDS);
    }

    private void growPlants() {
        island.growPlants();
    }

    private void animalLifeCycle() {
        ExecutorService animalPool = Executors.newWorkStealingPool();
        List<Callable<Void>> tasks = getCallables();

        try {
            animalPool.invokeAll(tasks);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        animalPool.shutdown();

        if (config.stopWhenAllAnimalsDie && island.allAnimalsDead()) {
            scheduler.shutdownNow();
            System.out.println("All animals have died. Simulation ended.");
        }
    }

    private List<Callable<Void>> getCallables() {
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int x = 0; x < config.width; x++) {
            for (int y = 0; y < config.height; y++) {
                final int fx = x;
                final int fy = y;
                tasks.add(() -> {
                    Location loc = island.getLocation(fx, fy);
                    synchronized (loc) {
                        loc.processAnimals();
                    }
                    return null;
                });
            }
        }
        return tasks;
    }

    private void printStats() {
        System.out.println("Island statistics: " + island.getStatistics());
    }
}
