/*
Problem: 509. Fibonacci Number

-----------------------------------------------------

Problem Statement

The Fibonacci numbers are defined as:

F(0) = 0  
F(1) = 1  

F(n) = F(n-1) + F(n-2)

Given n, return F(n).

-----------------------------------------------------

Pattern Used & Why

Pattern: Recursion

Why:
- Problem naturally breaks into smaller subproblems
- F(n) depends on F(n-1) and F(n-2)

-----------------------------------------------------

Key Idea

- Base case:
  F(0) = 0
  F(1) = 1

- Recursive case:
  F(n) = F(n-1) + F(n-2)

-----------------------------------------------------

Algorithm / Process

1. If n == 0 → return 0
2. If n == 1 → return 1
3. Otherwise:
      return fib(n-1) + fib(n-2)

-----------------------------------------------------

Code
*/

class Solution {

    public int fib(int n) {

        // base case
        if (n == 0 || n == 1) return n;

        // recursive call
        int ans = fib(n - 1) + fib(n - 2);
        return ans;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(2^n)

-----------------------------------------------------

Space Complexity
O(n) (recursion stack)

-----------------------------------------------------

Example

Input:
n = 5

Output:
5

Explanation:
0, 1, 1, 2, 3, 5

-----------------------------------------------------

Short Interview Explanation

Use recursion.
Each Fibonacci number is sum of previous two numbers.
*/
