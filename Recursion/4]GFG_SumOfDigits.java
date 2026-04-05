/*
Problem: Sum of Digits of a Number (GFG)

-----------------------------------------------------

Problem Statement

Given a number n, return the sum of its digits.

-----------------------------------------------------

Pattern Used & Why

Pattern: Recursion

Why:
- Break number into last digit and remaining number
- Solve smaller subproblem

-----------------------------------------------------

Key Idea

- Last digit = n % 10
- Remaining number = n / 10
- Sum = last digit + sum of remaining digits

-----------------------------------------------------

Algorithm / Process

1. If n == 0 → return 0
2. Get last digit → n % 10
3. Recursive call → n / 10
4. Add both

-----------------------------------------------------

Code
*/

class Solution {
    public int sumOfDigits(int n) {
        
        return cal(n, 0);
    }
    
    private int cal(int n, int sum) {
        //base case
         if (n == 0) {
             return sum;
         }
         
         //work
         sum += n % 10;
        
         return cal(n / 10,sum);
    }
}


/*
-----------------------------------------------------

Time Complexity
O(d)  (d = number of digits)

-----------------------------------------------------

Space Complexity
O(d) (recursion stack)

-----------------------------------------------------

Example

Input:
n = 1234

Output:
10

Explanation:
1 + 2 + 3 + 4 = 10

-----------------------------------------------------

Short Interview Explanation

Extract last digit using modulo.
Add it with recursive result of remaining number.
*/
