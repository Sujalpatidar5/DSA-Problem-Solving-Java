#  Heap / Priority Queue Pattern

Heap is a data structure used to efficiently access the **smallest or largest element**.

In Java, Heap is implemented using **Priority Queue**.

---

##  What is a Heap?

A Heap is a **complete binary tree** that satisfies:

- **Min Heap** → smallest element at top
- **Max Heap** → largest element at top

---

##  Key Idea

Heap is used when:
- You need **Top K elements**
- You need **minimum / maximum quickly**
- You are dealing with **priority-based problems**

---

##  Java Implementation

###  Min Heap (default)

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

---

###  Max Heap

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
```

---

##  Basic Operations

```java
pq.add(x);     // insert → O(log n)
pq.poll();     // remove top → O(log n)
pq.peek();     // get top → O(1)
```

---

##  When to Use Heap?

Use Heap when you see:

- **Kth largest / smallest**
- **Top K frequent elements**
- **Merge K sorted lists**
- **Minimum / Maximum repeatedly needed**
- **Greedy + priority problems**

---

##  Summary

- Heap gives fast access to min/max
- Implemented using PriorityQueue
- Used for Top K and priority problems
- Core for many interview questions

---
