/*
========================================
Problem: 633. Sum of Square Numbers
========================================

Problem Statement:

Given a non-negative integer c,

Return true if there exist two integers a and b such that

a² + b² = c

Otherwise, return false.

----------------------------------------
Pattern Used & Why:
Two Pointers

Why:
- The smallest possible square is 0².
- The largest possible square is (√c)².
- We can search efficiently by moving two pointers instead of checking every pair.

----------------------------------------
Key Idea:

left -> starts from 0

right -> starts from √c

Calculate

left² + right²

If sum == c

Answer found.

If sum > c

Need a smaller sum.

Move right--

If sum < c

Need a larger sum.

Move left++

----------------------------------------
Algorithm / Process:

1. left = 0

2. right = √c

3. While left <= right

      sum = left² + right²

      If sum == c

            return true

      Else if sum > c

            right--

      Else

            left++

4. Return false

----------------------------------------
Code:
*/

class Solution {

    public boolean judgeSquareSum(int c) {

        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {

            long sum = (long) left * left +
                       (long) right * right;

            if (sum == c) {
                return true;
            }

            else if (sum > c) {
                right--;
            }

            else {
                left++;
            }
        }

        return false;
    }
}

/*
----------------------------------------
Time & Space Complexity

Time Complexity:
O(√c)

- left and right move at most √c times.

Space Complexity:
O(1)

- No extra space is used.

----------------------------------------
Example

Input:

c = 5

Output:

true

Because

1² + 2² = 1 + 4 = 5

----------------------------------------
Dry Run

Input:

c = 5

Initially

left = 0

right = 2

--------------------------------

left² + right²

0² + 2²

= 4

4 < 5

Need a larger sum.

left++

--------------------------------

left = 1

right = 2

1² + 2²

= 1 + 4

= 5

Found answer.

Return true.

----------------------------------------
Another Example

Input:

c = 3

left = 0

right = 1

0² + 1² = 1

Too small

left++

--------------------------------

left = 1

right = 1

1² + 1² = 2

Too small

left++

left > right

Loop ends.

Return false.

----------------------------------------
Explanation (Simple & Clear)

We need two numbers whose squares add up to c.

The smallest possible number is 0.

The largest possible number is √c because any larger number will have a square greater than c.

The left pointer starts from 0.

The right pointer starts from √c.

If the current sum is too large,
we decrease the right pointer to reduce the sum.

If the current sum is too small,
we increase the left pointer to increase the sum.

If the sum becomes equal to c,
we immediately return true.

If the pointers cross each other,
it means no valid pair exists.

----------------------------------------
Pointer Visualization

Example

c = 5

left          right

0               2

0² + 2² = 4

Too Small

Move left

------------------------

left          right

1               2

1² + 2² = 5

Found

Return true

----------------------------------------
Interview Explanation

I solve this problem using the Two Pointer technique.

The left pointer starts from 0 and the right pointer starts from √c.

At each step, I calculate left² + right².

If the sum is greater than c, I move the right pointer to reduce the sum.

If the sum is smaller than c, I move the left pointer to increase the sum.

If the sum becomes equal to c, I return true.

If the pointers cross each other, no valid pair exists.

Time Complexity is O(√c) and Space Complexity is O(1).

----------------------------------------
Short Comment (for code memory)

// left = 0
// right = √c
// sum > c -> right--
// sum < c -> left++
// sum == c -> true
*/
