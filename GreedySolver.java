// Implements the three greedy strategies for the knapsack problem.
public class GreedySolver {
    // Selects experiments by highest science rating first.
    public static Experiment[] highestRatingFirst(Experiment[] experiments) {
        Experiment[] selected = new Experiment[experiments.length];
        int selectedCount = 0;
        Experiment[] sorted = experiments.clone();
        java.util.Arrays.sort(sorted, (a, b) -> Integer.compare(b.rating, a.rating));
        
        for (Experiment experiment : sorted) {
            if (experiment.id.equals("11a") &&
                !ManifestEvaluator.containsExperiment(
                    java.util.Arrays.copyOf(selected, selectedCount), "11")) {
                continue;
            }
            Experiment[] tentative = java.util.Arrays.copyOf(selected, selectedCount + 1);
            tentative[selectedCount] = experiment;

            if (ManifestEvaluator.isValid(tentative)) {
                selected[selectedCount] = experiment;
                selectedCount++;
            }
        }
        
        return java.util.Arrays.copyOf(selected, selectedCount);
        
    }
    // Selects experiments by lowest mass first.
    public static Experiment[] lightestMassFirst(Experiment[] experiments) {
        Experiment[] selected = new Experiment[experiments.length];
        int selectedCount = 0;
        Experiment[] sorted = experiments.clone();
        java.util.Arrays.sort(sorted, (a, b) -> Integer.compare(a.mass, b.mass));
        for (Experiment experiment : sorted) {
            if (experiment.id.equals("11a") &&
                !ManifestEvaluator.containsExperiment(
                    java.util.Arrays.copyOf(selected, selectedCount), "11")) {
                continue;
            }

                Experiment[] tentative = java.util.Arrays.copyOf(selected, selectedCount + 1);
                tentative[selectedCount] = experiment;
                if (ManifestEvaluator.isValid(tentative)) {
                    selected[selectedCount] = experiment;
                    selectedCount++;
                }
            
        }
    // Reconsider Experiment 11a after Experiment 11.
    for (Experiment experiment : sorted) {
        if (experiment.id.equals("11a")) {
            if (ManifestEvaluator.containsExperiment(
                    java.util.Arrays.copyOf(selected, selectedCount), "11")) {
                Experiment[] tentative = java.util.Arrays.copyOf(selected, selectedCount + 1);
                tentative[selectedCount] = experiment;
                if (ManifestEvaluator.isValid(tentative)) {
                    selected[selectedCount] = experiment;
                    selectedCount++;
                }
            }
        }
    }
    }
    return java.util.Arrays.copyOf(selected, selectedCount);
    }
    // Selects experiments by highest rating-to-mass ratio first.
    public static Experiment[] highestRatioFirst(Experiment[] experiments) {
        Experiment[] selected = new Experiment[experiments.length];
        int selectedCount = 0;
        Experiment[] sorted = experiments.clone();
        java.util.Arrays.sort(sorted, (a, b) ->
            Double.compare((double) b.rating / b.mass,
                           (double) a.rating / a.mass));
        for (Experiment experiment : sorted) {
            if (experiment.id.equals("11a") &&
                !ManifestEvaluator.containsExperiment(
                    java.util.Arrays.copyOf(selected, selectedCount), "11")) {
                continue;
            }
            Experiment[] tentative = java.util.Arrays.copyOf(selected, selectedCount + 1);
            tentative[selectedCount] = experiment;
            if (ManifestEvaluator.isValid(tentative)) {
                selected[selectedCount] = experiment;
                selectedCount++;
            }
        }
        // Reconsider Experiment 11a after Experiment 11.
        for (Experiment experiment : sorted) {
            if (experiment.id.equals("11a")) {
                if (ManifestEvaluator.containsExperiment(
                        java.util.Arrays.copyOf(selected, selectedCount), "11")) {
                        Experiment[] tentative = java.util.Arrays.copyOf(selected, selectedCount + 1);
                        tentative[selectedCount] = experiment;
                    
                        if (ManifestEvaluator.isValid(tentative)) {
                            selected[selectedCount] = experiment;
                            selectedCount++;
                        }
                }
            }
        }
        return java.util.Arrays.copyOf(selected, selectedCount);
    }
}
