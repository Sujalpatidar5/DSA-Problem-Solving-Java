/*
Problem: 50. Pow(x, n)

-----------------------------------------------------

Problem Statement

Implement pow(x, n), which calculates x raised to the power n (x^n).

-----------------------------------------------------

Pattern Used & Why

Pattern: Recursion + Divide & Conquer (Fast Exponentiation)

Why:
- Reduce problem size by half each time
- Instead of O(n), achieve O(log n)

-----------------------------------------------------

Key Idea

x^n =
- if n is even → (x^(n/2)) * (x^(n/2))
- if n is odd → x * (x^(n/2)) * (x^(n/2))

-----------------------------------------------------

Algorithm / Process

1. Handle negative power:
   - x = 1/x
   - n = -n

2. Recursive function:
   - Base case: n == 0 → return 1
   - Compute half power
   - If even → square it
   - If odd → multiply extra x

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public double myPow(double x, int n) {

        long N = n;  // handle overflow case

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    private double power(double x, long N) {

        // base case
        if (N == 0) {
            return 1;
        }

        double halfPower = power(x, N / 2);

        if (N % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return x * halfPower * halfPower;
        }
    }
}

/*
-----------------------------------------------------

Time Complexity
O(log n)

-----------------------------------------------------

Space Complexity
O(log n) (recursion stack)

-----------------------------------------------------

Example

Input:
x = 2, n = 10

Output:
1024

-----------------------------------------------------

ShortExplanation

Use divide & conquer.
Compute power(x, n/2).
Square result.
If n is odd - multiply by x.
Handle negative power separately.
*/
