#  Binary Search Pattern

Binary Search is an efficient algorithm used on **sorted data** to reduce search space by half in every step.

---

##  When to Use Binary Search?

Use Binary Search when:

- Array is **sorted**
- You need to find:
  - Exact element
  - First/Last occurrence
  - Minimum/Maximum valid answer
- Search space can be reduced (divide & conquer)

---

##  Core Idea

Instead of checking every element:

1. Take **middle element**
2. Compare with target
3. Decide:
   - Go **left** OR
   - Go **right**

 This reduces time from **O(n) → O(log n)**

---

##  Basic Template

```java
int left = 0, right = n - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;

    if (arr[mid] == target) {
        return mid;
    }
    else if (arr[mid] < target) {
        left = mid + 1;
    }
    else {
        right = mid - 1;
    }
}

return -1;
```

---

##  Variations of Binary Search

### 1️ Lower Bound (First Position ≥ target)

```java
while (left < right) {
    int mid = (left + right) / 2;
    if (arr[mid] < target)
        left = mid + 1;
    else
        right = mid;
}
```

---

### 2️ Upper Bound (First Position > target)

```java
while (left < right) {
    int mid = (left + right) / 2;
    if (arr[mid] <= target)
        left = mid + 1;
    else
        right = mid;
}
```

---

### ️3 First Occurrence

 Move left even after finding target

---

### ️4 Last Occurrence

 Move right even after finding target

---

##  Advanced Pattern: Binary Search on Answer

Used when:
- Answer is not directly given
- You need to find **minimum/maximum valid value**

### Example:
- Minimum eating speed
- Capacity to ship packages
- Allocate books

### Template:

```java
int left = minPossible;
int right = maxPossible;

while (left <= right) {
    int mid = left + (right - left) / 2;

    if (isPossible(mid)) {
        right = mid - 1;   // try smaller
    } else {
        left = mid + 1;    // increase
    }
}

return left;
```

---

##  Important Points

- Always use:
  ```java
  int mid = left + (right - left) / 2;
  ```
  (Avoid overflow)

- Loop condition:
  - `left <= right` → exact search
  - `left < right` → bound problems

- Be careful with:
  - Infinite loops
  - Off-by-one errors

---

##  Interview Tips

- Always identify:
   Is array sorted?  
   Can I reduce search space?

- If confused:
   Try brute force → optimize with Binary Search

---

##  Time Complexity

 Binary Search  -> O(log n)  

---

##  Summary

- Works on sorted data
- Reduces search space by half
- Key for optimization problems
- Very common in interviews

---
