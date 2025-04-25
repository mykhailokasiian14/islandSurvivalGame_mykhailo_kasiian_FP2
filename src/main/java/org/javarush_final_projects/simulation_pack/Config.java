package org.javarush_final_projects.simulation_pack;

import java.util.Map;

class Config {
    int width;
    int height;
    int tickDuration = 100; // в ms
    Map<String, Integer> initialAnimalCounts = Map.ofEntries(
            Map.entry("Wolf", 30),
            Map.entry("Boa", 20),
            Map.entry("Fox", 20),
            Map.entry("Bear", 10),
            Map.entry("Eagle", 20),
            Map.entry("Horse", 40),
            Map.entry("Deer", 30),
            Map.entry("Rabbit", 100),
            Map.entry("Mouse", 200),
            Map.entry("Goat", 40),
            Map.entry("Sheep", 50),
            Map.entry("Boar", 20),
            Map.entry("Buffalo", 10),
            Map.entry("Duck", 80),
            Map.entry("Caterpillar", 150)
    );

    boolean stopWhenAllAnimalsDie = true;

    public Config(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
