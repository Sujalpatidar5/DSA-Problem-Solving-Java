/*
Problem: 692. Top K Frequent Words
Link: https://leetcode.com/problems/top-k-frequent-words/

-----------------------------------------------------

Problem Statement

Given an array of strings words and an integer k,
return the k most frequent strings.

Rules:
- Sort by frequency (highest first)
- If frequency is same → lexicographically smaller word first

-----------------------------------------------------

Pattern Used & Why

Pattern: HashMap + Heap (Min Heap of size k)

Why:
- HashMap → count frequency
- Min Heap → keep top k elements
- Custom comparator → handle frequency + lexicographical order

-----------------------------------------------------

Key Idea

1. Count frequency of words
2. Use min heap:
   - smaller freq first
   - if same freq → lexicographically larger first (so it gets removed)
3. Maintain size k
4. Reverse final result

-----------------------------------------------------

Algorithm / Process

1. Build frequency map
2. Create min heap with custom comparator
3. Traverse map:
      add Pair(word, freq)
      if size > k → remove weakest
4. Extract elements
5. Reverse result

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    class Pair {
        String word;
        int freq;

        Pair(String w, int f) {
            this.word = w;
            this.freq = f;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        // Step 1: frequency map
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        // Step 2: min heap (weakest on top)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.freq == b.freq) {
                    return b.word.compareTo(a.word); // reverse lexicographical
                }
                return a.freq - b.freq; // smaller freq first
            }
        );

        // Step 3: maintain size k
        for (String key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));

            if (pq.size() > k) {
                pq.remove(); // remove weakest
            }
        }

        // Step 4: build answer (reverse order)
        List<String> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(pq.remove().word);
        }

        Collections.reverse(res); // strongest first

        return res;
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
words = ["i","love","leetcode","i","love","coding"], k = 2

Output:
["i","love"]

-----------------------------------------------------

Explanation :

Use HashMap for frequency.
Use min heap of size k with custom comparator.
Handle tie using lexicographical order.
Reverse result at end.
*/
