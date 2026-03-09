# Sliding Window Technique

Sliding Window is a technique used on arrays and strings to solve problems involving:

- Subarray
- Substring
- Continuous elements

Instead of using nested loops **O(n²)**,  
Sliding Window reduces time complexity to **O(n)**.

------------------------------------------------------------

# When to Use Sliding Window?

If the question contains:

- Subarray / Substring
- Longest / Shortest
- Maximum / Minimum
- Sum / Count / Average
- At most K / At least K / Exactly K
- Continuous elements

Then think about **Sliding Window**.

------------------------------------------------------------

# Types of Sliding Window

1) Fixed Size Sliding Window  
2) Variable Size Sliding Window  
3) Variable Size Sliding Window (Minimum Type)  
4) Variable Size Sliding Window (Exactly K / AtMost Trick)

------------------------------------------------------------

# 1) Fixed Size Sliding Window

## When to Use
- Window size **K is already given**
- Example: **Maximum sum subarray of size K**

## Idea
- Always maintain exactly **K elements** in the window
- Slide the window one step at a time

## Window Size Formula

```
windowSize = right - left + 1
```

------------------------------------------------------------

# Template: Fixed Size Sliding Window

### Edge Case
```
if (n < k) return something;
```

### Step 1: Build First Window

```java
int windowValue = 0;

for (int i = 0; i < k; i++) {
    windowValue += nums[i];
}
```

### Step 2: Initialize Answer

```java
int ans = windowValue;
```

### Step 3: Slide the Window

```java
for (int right = k; right < n; right++) {

    // Add new element
    windowValue += nums[right];

    // Remove old element
    windowValue -= nums[right - k];

    // Update answer
    ans = Math.max(ans, windowValue);
}

return ans;
```

------------------------------------------------------------

# 2) Variable Size Sliding Window

## When to Use
- Window size is **NOT fixed**
- Based on a condition

Examples:

- Longest substring without repeating characters
- Subarray with sum ≤ K
- At most K distinct characters

## Main Idea

- **For loop → expands the window**
- **While loop → shrinks / fixes the window**

------------------------------------------------------------

# Template: Variable Size Sliding Window

```java
int left = 0;
initialize required variables;
int ans = initial_value;

for (int right = 0; right < n; right++) {

    // Expand window
    include nums[right] into window

    // Fix window if condition breaks
    while (window is invalid) {

        remove nums[left] from window;
        left++;
    }

    // Window is valid here
    update answer using (right - left + 1);
}

return ans;
```

------------------------------------------------------------

# 3) Variable Size Sliding Window (Minimum Type)

## When to Use

- Minimum length subarray / substring
- Smallest window satisfying a condition

Example:

- Minimum length subarray with sum ≥ target

## Important Rule

- **For MAX problems → update answer after expanding**
- **For MIN problems → update answer while shrinking**

------------------------------------------------------------

# Template: Minimum Type

```java
int left = 0;
initialize required variables;
int ans = Integer.MAX_VALUE;

for (int right = 0; right < n; right++) {

    // Expand window
    include nums[right] into window;

    // When condition is satisfied
    while (window satisfies condition) {

        // Update minimum answer
        ans = Math.min(ans, right - left + 1);

        // Shrink window
        remove nums[left] from window;
        left++;
    }
}

if (ans == Integer.MAX_VALUE)
    return 0;
else
    return ans;
```

------------------------------------------------------------

# 4) Variable Size Sliding Window (Exactly K / AtMost Trick)

## When to Use

When the problem asks to **count subarrays or substrings with exactly K occurrences**.

Examples:

- Exactly K odd numbers
- Exactly K distinct numbers
- Exactly K ones
- Exactly K characters

Examples from LeetCode:

- 1248 — Count Number of Nice Subarrays  
- 930 — Binary Subarrays With Sum  
- 992 — Subarrays With K Distinct Integers  

------------------------------------------------------------

## Core Idea

Direct sliding window works easily for:

```
AtMost K
```

But problems ask for:

```
Exactly K
```

So we convert the problem:

```
Exactly K = AtMost(K) - AtMost(K - 1)
```

------------------------------------------------------------

## Why This Works

```
AtMost(K) includes:
0, 1, 2, ... , K
```

```
AtMost(K-1) includes:
0, 1, 2, ... , K-1
```

Subtract:

```
AtMost(K) - AtMost(K-1)
```

Remaining:

```
Exactly K
```

------------------------------------------------------------

# Template: AtMost(K)

```java
int left = 0;
int ans = 0;

initialize required variables;

for (int right = 0; right < n; right++) {

    // Expand window
    include nums[right] into window;

    // Shrink window if invalid
    while (condition > K) {

        remove nums[left] from window;
        left++;
    }

    // Count valid subarrays ending at right
    ans += (right - left + 1);
}

return ans;
```

------------------------------------------------------------

# Final Pattern for Exactly K

```java
return atMost(K) - atMost(K - 1);
```

------------------------------------------------------------

# Why `ans += (right - left + 1)` ?

Window:

```
[left ... right]
```

All subarrays ending at **right**:

```
[right, right]
[right-1, right]
[right-2, right]
...
[left, right]
```

Total:

```
right - left + 1
```

------------------------------------------------------------

# Time Complexity

```
O(n)
```

# Space Complexity

```
O(1) or O(n)
```

Depends on the data structure used (HashMap, Set, etc.)

------------------------------------------------------------

# Explanation

"I used Sliding Window because the problem involves continuous elements.  
Instead of checking all subarrays, I maintained a window using two pointers.  
The right pointer expands the window, and the left pointer shrinks it when needed.  
This reduces the time complexity from O(n²) to O(n)."
