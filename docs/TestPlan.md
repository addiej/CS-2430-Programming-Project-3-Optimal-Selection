Test Plan – Programming Project 3

Required Tests
Test 1: Solar Instrument Limit
- Input: Experiments 2, 3, and 7
- Expected: Invalid because all three solar instruments are selected.
- Actual: Pending implementation.

Test 2: Thermal Mass Credit
- Input: Experiments 6 and 12
- Expected: Adjusted mass = 27 kg; total rating = 8.
- Actual: Pending implementation.

Test 3: Experiment 11a Prerequisite
- Input: Experiment 11a without Experiment 11
- Expected: Invalid because Experiment 11 is required.
- Actual: Pending implementation.

Test 4: Experiment 11 and 11a Together
- Input: Experiments 11 and 11a
- Expected: Valid; adjusted mass = 90 kg; total rating = 12.
- Actual: Pending implementation.

Test 5: Thermal Credit Applied Once
- Input: Experiments 6 and 12 together
- Expected: Baseline mass = 34 kg; adjusted mass = 27 kg. The 7 kg credit is applied exactly once.
- Actual: Pending implementation.

Test 6: Empty Manifest
- Input: No experiments selected
- Expected: Valid; adjusted mass = 0 kg; total rating = 0.
- Actual: Pending implementation.

Test 7: Greedy Strategies
- Input: All 13 experiments
- Expected: All three greedy strategies produce valid manifests using their specified sorting rules. Each displays selected experiments, adjusted mass, and total rating.
- Actual: Pending implementation.

Test 8: Brute-Force Search
- Input: All 13 experiments
- Expected: Exactly 8,192 subsets evaluated, including invalid subsets. The three highest-rated valid subsets are displayed, with an optimal solution identified.
- Actual: Pending implementation.

Additional Verification
- Confirm no accepted solution exceeds 700 kg adjusted mass.
- Confirm brute force evaluates all 8,192 subsets.
- Confirm the three highest-rated valid subsets are displayed.
- Compare all three greedy results against the brute-force optimum.
