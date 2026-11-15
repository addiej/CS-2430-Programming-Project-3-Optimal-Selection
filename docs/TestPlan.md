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

Additional Verification
- Confirm no accepted solution exceeds 700 kg adjusted mass.
- Confirm brute force evaluates all 8,192 subsets.
- Confirm the three highest-rated valid subsets are displayed.
- Compare all three greedy results against the brute-force optimum.
