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

## 3. Greedy Algorithms

FOR each of the three greedy strategies:

1. Create an empty manifest.
2. Rank experiments according to the strategy:
   - Highest rating first: descending science rating.
   - Lightest first: ascending baseline mass.
   - Best ratio first: descending rating / baseline mass.
3. Consider experiments in ranked order.
4. For each experiment:
   - Tentatively add it to the manifest.
   - Check all revised constraints and adjusted mass.
   - Keep it if the resulting manifest is valid.
   - Otherwise, skip it.
5. Display the selected experiments, adjusted mass, and total rating.

Special case:
If Experiment 11a is encountered before Experiment 11,
defer it until Experiment 11 has been considered, then
check whether 11a can be added.

## 4. Brute-Force Algorithm

1. Create an empty list to store valid manifests.
2. Generate all 8,192 possible subsets of the 13 experiments.
3. FOR each subset:
   - Calculate its baseline mass and total science rating.
   - Apply the 7 kg thermal mass credit when applicable.
   - Check the solar instrument limit.
   - Check Experiment 11a's prerequisite.
   - Check that adjusted mass does not exceed 700 kg.
   - IF all constraints are satisfied:
     - Add the subset to the list of valid manifests.
4. Sort valid manifests by total science rating (highest first).
5. Identify the three highest-rated valid subsets.
6. Mark the highest-rated subset as optimal.
7. Display each subset's experiments, adjusted mass, and rating.

## 5. Comparison Summary

1. Display the results of all three greedy strategies.
2. Display the optimal brute-force result.
3. Compare each greedy rating against the optimal rating.
4. Identify which greedy strategies matched the optimal.
5. Identify which strategies did not match the optimal.
