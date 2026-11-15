//Addie H., Dylan P., Anupa D.
//CS 2430
//Project: Programming Project 3 - Fall 2026
//The Knapsack Problem
//Purpose: Compare greedy algorithms and brute-force search to optimize a science payload.

public class Main {
    public static void main(String[] args) {
        
            // Stores the 13 experiments from the revised payload manifest.
            Experiment[] experiments = new Experiment[13];
    
            experiments[0] = new Experiment("1", "Cloud Patterns", 36, 5);
            experiments[1] = new Experiment("2", "Solar Flares", 264, 9);
            experiments[2] = new Experiment("3", "Solar Power", 188, 6);
            experiments[3] = new Experiment("4", "Binary Stars", 203, 8);
            experiments[4] = new Experiment("5", "Relativity", 104, 8);
            experiments[5] = new Experiment("6", "Seed Viability", 7, 4);
            experiments[6] = new Experiment("7", "Sun Spots", 90, 2);
            experiments[7] = new Experiment("8", "Mice Tumors", 65, 8);
            experiments[8] = new Experiment("9", "Microgravity Plant Growth", 75, 5);   
            experiments[9] = new Experiment("10", "Micrometeorites", 170, 9);
            experiments[10] = new Experiment("11", "Cosmic Rays - Primary Band", 80, 7);
            experiments[11] = new Experiment("11a", "Cosmic Rays - Secondary Band", 10, 5);
            experiments[12] = new Experiment("12", "Yeast Fermentation", 27, 4);
            
    }
    
}
