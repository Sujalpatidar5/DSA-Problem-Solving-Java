/*
9.
Problem: Aggressive Cows (GFG)

-----------------------------------------------------

Problem Statement

You are given positions of stalls and k cows.

Place the cows in stalls such that the
minimum distance between any two cows is maximized.

Return that maximum possible minimum distance.
(Aisa maximum D find krna h jisme sab cows place ho jaye)

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search on Answer

Why:
We need to maximize minimum distance. (MAXIMIZE  the MINIMUM distance)
Search space = [1 → max distance between stalls]

-----------------------------------------------------

Key Idea

1. Guess a minimum distance (mid)
2. Try placing cows with this distance
3. If possible → try bigger distance
4. Else → reduce distance

-----------------------------------------------------

Algorithm / Process

1. Sort the stalls
2. low = 1, high = last - first
3. While low <= high:
      mid = guess distance
4. If can place cows:
      store answer and try bigger
5. Else:
      reduce distance
6. Return answer

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int n = stalls.length;
        int low = 1, high = stalls[n - 1] - stalls[0];
        int res = -1;

        while (low <= high) {

            int guessDist = (low + high) / 2;

            if (canPlace(stalls, k, guessDist)) {
                res = guessDist;
                low = guessDist + 1;
            } else {
                high = guessDist - 1;
            }
        }

        return res;
    }

    private boolean canPlace(int[] stalls, int k, int guessDist) {

        int cows = 1; // first cow at first stall
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if ((stalls[i] - lastPos) >= guessDist) {
                cows++;
                lastPos = stalls[i];
            }

            if (cows == k) return true;
        }

        return false;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n log (maxDistance)

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
stalls = [1,2,4,8,9], k = 3

Output:
3

-----------------------------------------------------

Explanation : 

Binary search on distance.
Check if k cows can be placed with at least mid distance.
If yes → increase distance, else decrease.
*/
