# Project Plan
**CS 2430 – Programming Project 3: The Knapsack Problem**

## Responsibility Breakdown
- Addie – Communications Lead
- Dylan – Verification Lead
- Anupa – Implementation Lead

## Project Milestones

| Task | Status | Responsible | Commit Evidence |
|---|---|---|---|
| Create repository and invite collaborators | Done | Addie | |
| Create `/docs` folder and planning documents | Done | Addie | 10d6f21, b88ad4f, bd8a94b |
| Review revised Change Request | Done | Addie | |
| Create `Experiment.java` class | Written (not tested) | Addie | ee4b31d |
| Enter 13 revised experiments in `Main.java` | Written (not tested) | Addie | 75cde8e |
| Implement `ManifestEvaluator.java` | Written (not tested) | Addie | d89df61 |
| Implement three greedy strategies in `GreedySolver.java` | Written (not tested) | Addie | 41ab49f |
| Implement brute-force search (8,192 subsets) in `BruteForceSolver.java` | Written (not tested) | Addie | 30da73d, a8c369c |
| Connect algorithms in `Main.java` | Written (not tested) | Addie | |
| Display greedy results and top three brute-force solutions | Written (not tested) | Addie | |
| Compare greedy results against brute-force optimum | Not started | TBD | |
| Verify algorithms and revised constraints | Not started | Dylan / Team | |
| Record actual test results in `TestPlan.md` | Not started | Dylan / Team | |
| Add required dynamic programming pseudocode comments to Java source | Not started | TBD | |
| Complete README and CONTRIBUTIONS.md | Not started | Addie / Team | |
| Write formal team report | Not started | Addie / Team | |
| Record team screencast | Not started | Team | |
| Package and submit deliverables | Not started | Team | |

## Remaining Priorities

1. Compile and run the Java program to verify that all classes work together.
2. Test the three greedy strategies and brute-force algorithm.
3. Implement the direct comparison between greedy results and the brute-force optimum.
4. Verify all revised payload constraints and record actual results in `TestPlan.md`.
5. Add required dynamic programming pseudocode comments to the Java source.
6. Complete README, CONTRIBUTIONS.md, formal report, and screencast.
7. Package and submit all required deliverables.

## Current Development Notes

The initial Java implementation has been written for all three greedy strategies and the brute-force search. All 13 revised experiments have been entered, and the shared `ManifestEvaluator` handles the revised payload constraints.

The greedy algorithms include handling for Experiment 11a's prerequisite. The brute-force algorithm generates all 8,192 possible subsets and is designed to display the three highest-rated valid combinations.

**Important:** The code has not yet been compiled or tested. Algorithm correctness, constraint handling, and output accuracy still require verification.

The direct comparison between greedy results and the brute-force optimum has not yet been implemented.

The project documentation includes `ProjectPlan.md`, `Pseudocode.md`, and `TestPlan.md`. Actual test results remain pending.
