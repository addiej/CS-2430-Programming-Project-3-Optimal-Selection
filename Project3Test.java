
/**
 * Programming Project 3 – Fall 2026
 * CS 2430, section 502
 * Test Class meant to test each algorithm,
 * Checks the 3 rules as per change request
 * Checks totals for mass and science ratings
 * 
 * @author Dylan Parry (Primary Author)
 * @author Anupa D
 * @author Addie H
 */




import java.util.Arrays;

public class Project3Test {

    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
    	
    	// Experiment array, declaration
        Experiment[] all = {
            new Experiment("1", "Cloud Patterns", 36, 5),
            new Experiment("2", "Solar Flares", 264, 9),
            new Experiment("3", "Solar Power", 188, 6),
            new Experiment("4", "Binary Stars", 203, 8),
            new Experiment("5", "Relativity", 104, 8),
            new Experiment("6", "Seed Viability", 7, 4),
            new Experiment("7", "Sun Spots", 90, 2),
            new Experiment("8", "Mice Tumors", 65, 8),
            new Experiment("9", "Microgravity Plant Growth", 75, 5),
            new Experiment("10", "Micrometeorites", 170, 9),
            new Experiment("11", "Cosmic Rays", 80, 7),
            new Experiment("11a", "Cosmic Rays Secondary", 10, 5),
            new Experiment("12", "Yeast Fermentation", 27, 4)
        };

        System.out.println("=== DATA TEST ===");
        check("Experiment count", all.length == 13);
        System.out.println("\n=== RULE TESTS ===");

        // Solar limit
        Experiment[] solar = getExperiments(all, new String[]{"2", "3", "7"});
        check("Solar rule", !ManifestEvaluator.isValid(solar));
        check("Solar mass", ManifestEvaluator.calculateMass(solar) == 542);

        // 11a prerequisite
        Experiment[] prereq = getExperiments(all, new String[]{"11a"});
        check("11a alone", !ManifestEvaluator.isValid(prereq));

        Experiment[] both = getExperiments(all, new String[]{"11", "11a"});
        check("11 and 11a", ManifestEvaluator.isValid(both));
        check("Combined mass", ManifestEvaluator.calculateAdjustedMass(both) == 90);
        check("Combined rating", ManifestEvaluator.calculateRating(both) == 12);

        // Thermal mass
        Experiment[] thermal = getExperiments(all, new String[]{"1", "2", "4", "6", "10", "12"});
        check("Thermal baseline mass", ManifestEvaluator.calculateMass(thermal) == 707);
        check("Thermal credit", ManifestEvaluator.calculateAdjustedMass(thermal) == 700);
        check("Thermal valid", ManifestEvaluator.isValid(thermal));

        // Overweight
        Experiment[] overweight = getExperiments(all, new String[]{"2", "3", "4", "5"});
        check("Overweight", !ManifestEvaluator.isValid(overweight));

        System.out.println("\n=== GREEDY TESTS ===");

        // Highest
        Experiment[] rating = GreedySolver.highestRatingFirst(all);
        check("Rating valid", ManifestEvaluator.isValid(rating));
        check("Rating mass", ManifestEvaluator.calculateAdjustedMass(rating) == 700);
        check("Rating score", ManifestEvaluator.calculateRating(rating) == 39);

        // Lightest 
        Experiment[] light = GreedySolver.lightestMassFirst(all);
        check("Lightest valid", ManifestEvaluator.isValid(light));
        check("Lightest mass", ManifestEvaluator.calculateAdjustedMass(light) == 657);
        check("Lightest score", ManifestEvaluator.calculateRating(light) == 57);

        // Best ratio
        Experiment[] ratio = GreedySolver.highestRatioFirst(all);
        check("Ratio valid", ManifestEvaluator.isValid(ratio));
        check("Ratio mass", ManifestEvaluator.calculateAdjustedMass(ratio) == 657);
        check("Ratio score", ManifestEvaluator.calculateRating(ratio) == 57);

        System.out.println("\n=== BRUTE FORCE TESTS ===");

        BruteForceSolver.findBestSolutions(all);

        int bestRating = 0;
        int bestMass = 0;
        int count = 0;
        for (int mask = 0; mask < (1 << all.length); mask++) {

            Experiment[] temp = new Experiment[all.length];
            int size = 0;

            for (int i = 0; i < all.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    temp[size] = all[i];
                    size++;
                }
            }

            Experiment[] selected = Arrays.copyOf(temp, size);
            count++;

            if (ManifestEvaluator.isValid(selected)) {
                int score = ManifestEvaluator.calculateRating(selected);

                if (score > bestRating) {
                    bestRating = score;
                    bestMass = ManifestEvaluator.calculateAdjustedMass(selected);
                }
            }
        }

        check("8192 combinations", count == 8192);
        check("Best rating", bestRating == 58);
        check("Best mass", bestMass == 695);

        System.out.println("\n======================");
        System.out.println("Tests passed: " + passed);
        System.out.println("Tests failed: " + failed);
        System.out.println("======================");
    }
    /**
     * A getter based on the experiment I'ds
     *
     * @param all Experiment Array Declared at the beginning.
     * @param ids Array of the given experiment I'd
     * @return Array of selected experiments
     */
    
    static Experiment[] getExperiments(Experiment[] all, String[] ids) {

        Experiment[] result = new Experiment[ids.length];

        for (int i = 0; i < ids.length; i++) {
            for (Experiment e : all) {
                if (e.id.equals(ids[i])) {
                    result[i] = e;
                    break;
                }
            }
        }

        return result;
    }
    /**
     * Checks if test passed or failed then increments failed or pass
     *
     * @param name Name of the test
     * @param result True Or false
     */
    static void check(String name, boolean result) {

        if (result) {
            passed++;
            System.out.println("PASS: " + name);
        } else {
            failed++;
            System.out.println("FAIL: " + name);
        }
    }
}
