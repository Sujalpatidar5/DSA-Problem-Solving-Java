/*
LeetCode 141 - Linked List Cycle

Problem Statement:
Given the head of a linked list, determine if the linked list has a cycle in it.

Return true if there is a cycle.
Otherwise, return false.

---------------------------------------

Pattern Used:
Slow Fast Pointer (Floyd’s Cycle Detection)

Why this pattern?
- We must detect a cycle.
- We are not allowed to modify the list.
- We should not use extra space like HashSet.
- Slow Fast gives O(1) space solution.

---------------------------------------

Key Observation:
If a cycle exists:

- slow moves one step at a time
- fast moves two steps at a time

If there is a loop,
fast will eventually catch slow inside the cycle.

If no cycle exists,
fast will reach null.

---------------------------------------

Approach:
1. Initialize:
   slow = head
   fast = head
2. Traverse while:
   fast != null AND fast.next != null
3. Move:
   slow = slow.next
   fast = fast.next.next
4. If slow == fast:
   cycle exists → return true
5. If loop ends:
   return false

---------------------------------------

Algorithm:
1. If head is null → return false
2. Set slow = head, fast = head
3. While fast and fast.next are not null:
   - Move slow by 1 step
   - Move fast by 2 steps
   - If they meet → return true
4. Return false

---------------------------------------

Code:
*/

class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

/*
---------------------------------------

Example:

Input:
3 → 2 → 0 → -4
      ↑       ↓
      ← ← ← ← ←

There is a cycle.

Output:
true

---------------------------------------

If no cycle:

1 → 2 → 3 → 4 → null

Output:
false

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------

Explanation :
"I used the Slow Fast Pointer technique.
One pointer moves one step,
the other moves two steps.
If a cycle exists,
they must meet inside the loop.
If fast reaches null,
then no cycle exists."

---------------------------------------
*/
