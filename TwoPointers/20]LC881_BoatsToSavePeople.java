/*
========================================
Problem: 881. Boats to Save People
========================================

Problem Statement:

You are given an array people where people[i] represents the weight of the ith person.

Each boat can carry at most two people.

The total weight on a boat cannot exceed limit.

Return the minimum number of boats needed to carry everyone.

----------------------------------------
Pattern Used & Why:
Two Pointers + Sorting (Greedy)

Why:
- Sort the weights first.
- Pair the lightest person with the heaviest person whenever possible.
- If they cannot fit together, the heaviest person must go alone.
- This greedy approach gives the minimum number of boats.

----------------------------------------
Key Idea:

Sort the array.

i -> Lightest person.

j -> Heaviest person.

If

people[i] + people[j] <= limit

Both can share one boat.

Move i++

Always move j--

One boat is used in every iteration.

----------------------------------------
Algorithm / Process:

1. Sort the array.

2. i = 0

3. j = n - 1

4. boats = 0

5. While i <= j

      If people[i] + people[j] <= limit

            i++

      j--

      boats++

6. Return boats.

----------------------------------------
Code:
*/

import java.util.*;

class Solution {

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int i = 0;
        int j = people.length - 1;

        int boats = 0;

        while (i <= j) {

            if (people[i] + people[j] <= limit) {
                i++;
            }

            j--;
            boats++;
        }

        return boats;
    }
}

/*
----------------------------------------
Time & Space Complexity

Time Complexity:
O(n log n)

- Sorting takes O(n log n).
- Two pointers take O(n).

Overall = O(n log n)

Space Complexity:
O(1)

(ignoring the sorting algorithm's internal space)

----------------------------------------
Example

Input:

people = [3,2,2,1]

limit = 3

Output:

3

----------------------------------------
Dry Run

Input

people = [3,2,2,1]

limit = 3

After Sorting

[1,2,2,3]

i = 0

j = 3

boats = 0

--------------------------------

1 + 3 = 4

Greater than limit

3 goes alone.

j--

boats = 1

--------------------------------

i = 0

j = 2

1 + 2 = 3

Within limit

Both share one boat.

i++

j--

boats = 2

--------------------------------

i = 1

j = 1

Only one person left.

2 goes alone.

j--

boats = 3

Loop ends.

Answer = 3

----------------------------------------
Another Example

people = [1,2]

limit = 3

Sorted

[1,2]

1 + 2 = 3

Both share one boat.

Answer = 1

----------------------------------------
Explanation (Simple & Clear)

We first sort the people according to their weights.

The lightest person is at the beginning.

The heaviest person is at the end.

If the lightest and heaviest together fit into one boat,

we send them together because this saves one boat.

If they cannot fit together,

the heaviest person cannot be paired with anyone else because everyone else is heavier than the lightest.

So the heaviest person must go alone.

We repeat this process until everyone is placed in a boat.

This greedy strategy always gives the minimum number of boats.

----------------------------------------
Pointer Visualization

Sorted Array

[1,2,2,3]

 i       j

1 + 3 = 4

Too heavy

3 goes alone

-----------------------

[1,2,2,3]

 i     j

1 + 2 = 3

Both go together

-----------------------

[1,2,2,3]

   i
   j

Only one person left

One boat

Finished

Answer = 3

----------------------------------------
Interview Explanation

I solve this problem using Greedy and Two Pointers.

First, I sort the array.

Then I use one pointer at the lightest person and another at the heaviest person.

If both can fit in one boat, I send them together by moving both pointers.

Otherwise, the heaviest person must go alone, so I move only the right pointer.

Every iteration uses exactly one boat.

Sorting takes O(n log n), and the two-pointer traversal takes O(n), so the overall time complexity is O(n log n).

Space complexity is O(1).

----------------------------------------
Short Comment (for code memory)

// Sort weights
// i -> lightest
// j -> heaviest
// If both fit -> i++
// Always j--
// One boat per iteration
*/
