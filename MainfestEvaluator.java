// Evaluates experiment selections for the revised knapsack problem.
// Checks payload constraints, adjusted mass, and total science rating.
public class ManifestEvaluator {
  // Calculates the total baseline mass of selected experiments.
  public static int calculateMass(Experiment[] selected) {
      int totalMass = 0;
  
      for (Experiment experiment : selected) {
          totalMass += experiment.mass;
      }
  
      return totalMass;
  }

  // Calculates the combined science rating of selected experiments.
  public static int calculateRating(Experiment[] selected) {
      int totalRating = 0;
  
      for (Experiment experiment : selected) {
          totalRating += experiment.rating;
      }
  
      return totalRating;
  }


  // Checks whether a selected manifest contains a specific experiment.
  public static boolean containsExperiment(Experiment[] selected, String id) {
      for (Experiment experiment : selected) {
          if (experiment.id.equals(id)) {
              return true;
          }
      }
  
      return false;
  }

  // Checks that no more than two solar instruments are selected.
  public static boolean validSolarLimit(Experiment[] selected) {
      boolean has2 = containsExperiment(selected, "2");
      boolean has3 = containsExperiment(selected, "3");
      boolean has7 = containsExperiment(selected, "7");
  
      return !(has2 && has3 && has7);
  }  

  // Calculates adjusted mass after applying the thermal credit.
  public static int calculateAdjustedMass(Experiment[] selected) {
      int adjustedMass = calculateMass(selected);
  
      if (containsExperiment(selected, "6") &&
          containsExperiment(selected, "12")) {
          adjustedMass -= 7;
      }
  
      return adjustedMass;
  }


  // Checks that Experiment 11a is only selected with Experiment 11.
  public static boolean validPrerequisite(Experiment[] selected) {
      boolean has11 = containsExperiment(selected, "11");
      boolean has11a = containsExperiment(selected, "11a");
  
      return !has11a || has11;
  }

  // Checks whether a manifest satisfies all revised payload rules.
  public static boolean isValid(Experiment[] selected) {
      return validSolarLimit(selected)
          && validPrerequisite(selected)
          && calculateAdjustedMass(selected) <= 700;
  }
  
    
}
