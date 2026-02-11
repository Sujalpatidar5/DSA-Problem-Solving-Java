/*
Linked List Reverse Pattern

Definition:
This pattern is used when we need to reverse the direction of links in a singly linked list.

Instead of changing node values, we change the `next` pointers.

---------------------------------------

When To Use This Pattern:

Use this pattern when question involves:
- Reverse a linked list
- Reverse in groups (k group)
- Reverse between positions
- Reorder list
- Palindrome linked list
- Swap nodes
- Any problem where link direction changes

Keywords in question:
reverse / swap / reorder / k-group / palindrome

---------------------------------------

Core Idea (Very Important):

We need 3 pointers:

1. prev   → initially null
2. curr   → initially head
3. next   → to store curr.next temporarily

Steps inside loop:
1. Save next node
2. Reverse link
3. Move prev forward
4. Move curr forward

---------------------------------------

Standard Template (Most Important Part):

ListNode prev = null;
ListNode curr = head;

while (curr != null) {

    ListNode next = curr.next;   // save next
    curr.next = prev;            // reverse link

    prev = curr;                 // move prev
    curr = next;                 // move curr
}

return prev;   // new head

---------------------------------------

Memory Trick (Easy Understanding):

Think like this:

Before:
A → B → C → D → null

After:
null ← A ← B ← C ← D

We break the link one by one
and attach it backward.

---------------------------------------

Time Complexity:
O(n)

Space Complexity:
O(1)

---------------------------------------

Explanation ):

"I use three pointers:
prev, curr, and next.
For each node, I reverse its next pointer,
then move forward.
Finally, prev becomes the new head."

---------------------------------------
*/
