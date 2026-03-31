/*
Problem: 1337. The K Weakest Rows in a Matrix

-----------------------------------------------------

Problem Statement

You are given a matrix of 1's (soldiers) and 0's (civilians).
Each row is sorted → all 1's come before 0's.

Return the indices of the k weakest rows.

Weakness rule:
1. Row with fewer soldiers is weaker
2. If equal soldiers → smaller index is weaker

-----------------------------------------------------

Pattern Used & Why

Pattern: Max Heap (Top K)

Why:
- We need k smallest (weakest rows)
- Use max heap to remove strongest when size > k

-----------------------------------------------------

Key Idea

1. Count soldiers in each row
2. Store (soldiers, rowIndex) in max heap
3. Keep heap size = k
4. Remove strongest row if size exceeds k
5. Extract result in reverse order

-----------------------------------------------------

Algorithm / Process

1. Create max heap:
   - More soldiers → higher priority (remove first)
   - If equal → larger index removed first

2. Traverse matrix:
   - Count soldiers
   - Push into heap
   - If size > k → remove

3. Extract result (reverse order)

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    class Row {
        int soldiers;
        int idx;

        Row(int s, int i) {
            this.soldiers = s;
            this.idx = i;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<Row> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.soldiers != b.soldiers) {
                    return b.soldiers - a.soldiers; // max heap by soldiers
                }
                return b.idx - a.idx; // larger index removed first
            }
        );

        // push rows into heap
        for (int i = 0; i < mat.length; i++) {
            int count = countSoldiers(mat[i]);

            pq.add(new Row(count, i));

            if (pq.size() > k) {
                pq.remove();
            }
        }

        // prepare answer
        int[] ans = new int[k];
        int i = k - 1;

        while (!pq.isEmpty()) {
            Row r = pq.remove();
            ans[i] = r.idx;
            i--;
        }

        return ans;
    }

    // count soldiers (1s)
    private int countSoldiers(int[] row) {
        int count = 0;

        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n * m + n log k)

-----------------------------------------------------

Space Complexity
O(k)

-----------------------------------------------------

Example

Input:
mat = [
 [1,1,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,1,0,0]
], k = 2

Output:
[2, 0]

-----------------------------------------------------

Explanation :

Count soldiers per row.
Use max heap of size k.
Remove strongest rows.
Return weakest k rows.
*/
