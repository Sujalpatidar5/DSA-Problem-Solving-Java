/*
Problem: 202. Happy Number
Link: https://leetcode.com/problems/happy-number/

-----------------------------------------------------

Problem Statement

Write an algorithm to determine if a number n is a happy number.

A happy number is defined by the following process:

Starting with any positive integer,
replace the number by the sum of the squares of its digits.

Repeat the process until:
• the number equals 1 (happy number), or
• it loops endlessly in a cycle (not a happy number).

Return true if n is a happy number, otherwise false.

-----------------------------------------------------

Pattern Used & Why

Pattern: HashSet (Cycle Detection)

Why:
If the number starts repeating, it means we are stuck in a loop.
Using a HashSet allows us to detect repeated numbers quickly.

-----------------------------------------------------

Key Idea

1. Repeatedly compute the sum of squares of digits.
2. If the result becomes 1 → number is happy.
3. If the result repeats → we are in a cycle → return false.

We store previously seen numbers in a HashSet.

-----------------------------------------------------

Algorithm / Process

1. Create a HashSet to store visited numbers.
2. Loop indefinitely:
      compute sum of squares of digits.
3. If sum == 1 → return true.
4. If sum already exists in the set → return false.
5. Otherwise add sum to the set and continue.

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (true) {

            int num = getSum(n);

            if (num == 1)
                return true;

            if (set.contains(num))
                return false;

            set.add(num);
            n = num;
        }
    }

    private int getSum(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(log n)

Each iteration processes digits of the number.

-----------------------------------------------------

Space Complexity
O(log n)

For storing numbers in the HashSet.

-----------------------------------------------------

Example

Input:
n = 19

Process:
1² + 9² = 82
8² + 2² = 68
6² + 8² = 100
1² + 0² + 0² = 1

Output:
true

-----------------------------------------------------

Explanation :

Repeatedly replace the number with the sum of squares of its digits.
Use a HashSet to detect cycles. If we reach 1 the number is happy,
otherwise if a number repeats we are stuck in a loop.
*/
