/*
Problem: 767. Reorganize String
Link: https://leetcode.com/problems/reorganize-string/

-----------------------------------------------------

Problem Statement

Given a string s, rearrange the characters so that
no two adjacent characters are the same.

If not possible, return an empty string.

-----------------------------------------------------

Pattern Used & Why

Pattern: HashMap + Max Heap (Greedy)

Why:
- Always pick the most frequent characters first
- Use max heap to get highest frequency
- Place characters in pairs to avoid adjacency

-----------------------------------------------------

Key Idea

1. Count frequency of characters
2. Use max heap based on frequency
3. Always pick top 2 characters
4. Append them and decrease frequency
5. Reinsert if still remaining
6. Handle last character carefully

-----------------------------------------------------

Algorithm / Process

1. Build frequency map
2. Create max heap
3. While heap size >= 2:
      take top 2 elements
      append both
      decrease freq
      reinsert if needed
4. If one element left:
      if freq > 1 → not possible
      else append it

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    class Pair {
        char ch;
        int freq;

        Pair(char c, int f) {
            this.ch = c;
            this.freq = f;
        }
    }

    public String reorganizeString(String s) {

        // Step 1: frequency map
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: max heap (based on freq)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (char c : map.keySet()) {
            pq.add(new Pair(c, map.get(c)));
        }

        StringBuilder res = new StringBuilder();

        // Step 3: take top 2
        while (pq.size() >= 2) {

            Pair first = pq.poll();
            Pair second = pq.poll();

            res.append(first.ch);
            res.append(second.ch);

            first.freq--;
            second.freq--;

            if (first.freq > 0) pq.add(first);
            if (second.freq > 0) pq.add(second);
        }

        // Step 4: last element
        if (!pq.isEmpty()) {
            Pair last = pq.poll();

            if (last.freq > 1) return ""; // not possible

            res.append(last.ch);
        }

        return res.toString();
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n log k)

-----------------------------------------------------

Space Complexity
O(n)

-----------------------------------------------------

Example

Input:
s = "aab"

Output:
"aba"

-----------------------------------------------------

Explanation :

Use max heap to always pick most frequent characters.
Pick two at a time to avoid adjacency.
If last character has freq > 1 → not possible.
*/
