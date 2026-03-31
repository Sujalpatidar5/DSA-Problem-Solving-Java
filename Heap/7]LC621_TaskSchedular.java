/*
Problem: 621. Task Scheduler
Link: https://leetcode.com/problems/task-scheduler/

-----------------------------------------------------

Problem Statement

You are given an array of tasks represented by characters
and a cooldown time n.

Each task takes 1 unit time.
Same tasks must have at least n intervals between them.

Return the minimum time required to complete all tasks.

-----------------------------------------------------

Pattern Used & Why

Pattern: HashMap + Max Heap + Greedy Scheduling

Why:
- Max heap → always pick highest frequency task
- HashMap → track next available time (cooldown)
- Greedy → schedule tasks as early as possible

-----------------------------------------------------

Key Idea

1. Count frequency of tasks
2. Track next free time for each task
3. Use max heap to pick highest freq task
4. If task is available → execute
5. Else → skip and check next
6. Increase time (seat) step by step

-----------------------------------------------------

Algorithm / Process

1. Build frequency map
2. Initialize free time for each task
3. Push all tasks into max heap
4. For each time unit:
      try to pick available task
      if found:
          reduce frequency
          update cooldown
      else:
          idle
5. Repeat until heap empty

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {
    class Pair {
        char c;
        int f;

        Pair(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> free = new HashMap<>();

        for (char t : tasks) {
            freq.put(t, freq.getOrDefault(t, 0) + 1);
            free.put(t, 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.f - a.f);

        for (char key : freq.keySet()) {
            pq.add(new Pair(key, freq.get(key)));
        }

        int seat = 1;

        while (!pq.isEmpty()) {

            ArrayList<Pair> corner = new ArrayList<>();

            while (!pq.isEmpty()) {
                Pair p = pq.poll();

                if (free.get(p.c) <= seat) {

                    if (p.f > 1) {
                        corner.add(new Pair(p.c, p.f - 1));
                        free.put(p.c, seat + n + 1);
                    }

                    break;
                } else {
                    corner.add(p);
                }
            }

            for (Pair p : corner) {
                pq.add(p);
            }

            seat++; // next time slot
        }

        return seat - 1;
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
tasks = ['A','A','A','B','B','B'], n = 2

Output:
8

-----------------------------------------------------

Explanation :

Use max heap for task selection.
Track cooldown using map.
Schedule tasks greedily at earliest available time.
*/
