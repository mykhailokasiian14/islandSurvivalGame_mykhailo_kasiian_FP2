package org.javarush_final_projects.simulation_pack;

import java.util.Scanner;

public class IslandSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter island width: ");
        int width = scanner.nextInt();
        System.out.print("Enter island height: ");
        int height = scanner.nextInt();
        Config config = new Config(width, height);
        Island island = new Island(config);
        Simulation simulation = new Simulation(island, config);
        simulation.start();
    }
}