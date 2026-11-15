# Pseudocode – Programming Project 3
**The Knapsack Problem (Java)**

## 1. Program Setup

Start Program

1. Create an array containing all 13 experiments from the revised payload manifest.
2. Each experiment stores its ID, name, baseline mass, and science rating.
3. Set the maximum payload capacity to 700 kg.
4. Use a shared ManifestEvaluator to calculate mass, rating, and feasibility.
5. Run three greedy strategies:
   - Highest rating first
   - Lightest mass first
   - Highest rating-to-mass ratio first
6. Run brute-force search to evaluate all 8,192 possible subsets.
7. Display the results of each strategy and compare them against the optimal solution.

End Program Setup

## 2. Manifest Evaluation

FOR each selected experiment:
- Add its baseline mass to the total.
- Add its science rating to the total.

IF Experiments 2, 3, and 7 are all selected:
- Mark the manifest invalid.

IF Experiments 6 and 12 are both selected:
- Subtract 7 kg from the total mass.

IF Experiment 11a is selected without Experiment 11:
- Mark the manifest invalid.

IF adjusted mass exceeds 700 kg:
- Mark the manifest invalid.

OTHERWISE:
- Mark the manifest valid.

RETURN validity, adjusted mass, and total science rating.
