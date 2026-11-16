// Finds the optimal science payload using brute-force search.
public class BruteForceSolver {
  // Evaluates all possible experiment combinations.
  public static void findBestSolutions(Experiment[] experiments) {
    int totalSubsets = 1 << experiments.length;
    java.util.ArrayList<Experiment[]> validSubsets = new java.util.ArrayList<>();
    for (int mask = 0; mask < totalSubsets; mask++) {
      Experiment[] selected = new Experiment[experiments.length];
      int selectedCount = 0;
      for (int i = 0; i < experiments.length; i++) {
        if ((mask & (1 << i)) != 0) {
            selected[selectedCount] = experiments[i];
            selectedCount++;
        }
      }
      Experiment[] subset = java.util.Arrays.copyOf(selected, selectedCount);
      if (ManifestEvaluator.isValid(subset)) {
        validSubsets.add(subset);
      }
    }
  
    validSubsets.sort((a, b) ->
      Integer.compare(ManifestEvaluator.calculateRating(b),
                      ManifestEvaluator.calculateRating(a)));
    System.out.println("Total subsets evaluated: " + totalSubsets);
    for (int i = 0; i < Math.min(3, validSubsets.size()); i++) {
      Experiment[] solution = validSubsets.get(i);
      System.out.println("Solution " + (i + 1) + (i == 0 ? " (OPTIMAL)" : ""));
      for (Experiment experiment : solution) {
          System.out.println("  " + experiment.id + ": " + experiment.name);
      }
      System.out.println("Adjusted mass: " +
          ManifestEvaluator.calculateAdjustedMass(solution) + " kg");
      
      System.out.println("Total science rating: " +
          ManifestEvaluator.calculateRating(solution));
    }
}
}
