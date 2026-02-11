# Slow Fast Pointer Pattern

---------------------------------------

Definition:

Slow Fast Pointer (also called Floyd’s Cycle Detection Algorithm) is a technique where two pointers move at different speeds to detect cycles or find middle points in linked lists or arrays.
It is a type of 2 pointers.

---------------------------------------

When to Use This Pattern:

Use this pattern when:

- You need to detect a cycle in a linked list
- You need to find the starting node of a cycle
- You need to find the middle of a linked list
- You need to check if a number enters a cycle 
- array / String / LL
- You need O(1) space solution instead of using HashSet

---------------------------------------

How to Identify Slow Fast Problems:

Look for keywords like:

- Cycle in linked list
- Detect loop
- Find duplicate number (without extra space)
- Repeatation
- Middle of linked list

If problem says:
“Do it without extra space”
- Slow Fast is expected.

---------------------------------------

Core Idea:

- slow moves one step at a time
- fast moves two steps at a time

If a cycle exists:
slow and fast will eventually meet.

---------------------------------------

Basic Template (Cycle Detection in Linked List):

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast) {
       // cycle exists
    }
}
