package org.javarush_final_projects.entity.animal;

import org.javarush_final_projects.entity.animal.herbivore.*;
import org.javarush_final_projects.entity.animal.predator.*;

public class AnimalFactory {
    public static Animal create(String type) {
        return switch (type) {
            case "Wolf" -> new Wolf();
            case "Boa" -> new Boa();
            case "Fox" -> new Fox();
            case "Bear" -> new Bear();
            case "Eagle" -> new Eagle();
            case "Horse" -> new Horse();
            case "Deer" -> new Deer();
            case "Rabbit" -> new Rabbit();
            case "Mouse" -> new Mouse();
            case "Goat" -> new Goat();
            case "Sheep" -> new Sheep();
            case "Boar" -> new Boar();
            case "Buffalo" -> new Buffalo();
            case "Duck" -> new Duck();
            case "Caterpillar" -> new Caterpillar();
            default -> null;
        };
    }
}
