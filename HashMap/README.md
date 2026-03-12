# HashMap Pattern

---------------------------------------

## Definition:

HashMap is a data structure that stores data in
(key → value) pairs and allows fast lookup,
insertion and update operations.

In DSA problems, HashMap is commonly used to
store frequency of elements, track previous values,
or check existence of elements in O(1) time.

---------------------------------------

## When To Use HashMap?

Use HashMap when the problem involves:

- Frequency counting
- Checking if an element already exists
- Finding pairs with a given condition
- Tracking previous occurrences
- Counting subarrays or substrings
- Mapping elements to indices
- Handling duplicates

Common keywords in questions:

- "frequency"
- "count occurrences"
- "distinct elements"
- "pairs with sum = k"
- "subarray sum"
- "anagram"
- "duplicates"

---------------------------------------

## Core Idea

HashMap stores:

key   → element
value → frequency / index / count

Example:

nums = [1,2,1,3]

HashMap:

1 → 2
2 → 1
3 → 1

---------------------------------------

## Basic HashMap Operations (Java)

Create HashMap:

HashMap<Integer, Integer> map = new HashMap<>();

Insert / Update value:

map.put(key, value);

Get value:

map.get(key);

Get value safely:

map.getOrDefault(key, 0);

Check if key exists:

map.containsKey(key);

Remove key:

map.remove(key);

Get number of keys:

map.size();

---------------------------------------

## Most Common HashMap Templates

---------------------------------------

1️. Frequency Counting

Used when we need to count occurrences.

Example problems:
- Majority Element
- Valid Anagram
- Maximum Number of Balloons

Template:

HashMap<Integer, Integer> map = new HashMap<>();

for (int num : nums) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}

---------------------------------------

2️. Prefix Sum + HashMap

Used when solving subarray sum problems.

Example problems:
- Subarray Sum Equals K
- Continuous Subarray Sum
- Count Subarrays With Given Sum

Template:

HashMap<Integer, Integer> map = new HashMap<>();
map.put(0, 1);

int prefix = 0;

for (int num : nums) {

    prefix += num;

    if (map.containsKey(prefix - k)) {
        // condition satisfied
    }

    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
}

---------------------------------------

3️. Sliding Window + HashMap

Used when tracking frequency in a window.

Example problems:
- Longest Substring Without Repeating Characters
- Subarrays With K Distinct Integers
- Minimum Window Substring

Template:

HashMap<Integer, Integer> map = new HashMap<>();

int left = 0;

for (int right = 0; right < n; right++) {

    map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

    while (condition breaks) {

        map.put(arr[left], map.get(arr[left]) - 1);

        if (map.get(arr[left]) == 0) {
            map.remove(arr[left]);
        }

        left++;
    }
}

---------------------------------------

Important Observation

HashMap is useful when:

- Order does NOT matter
- Fast lookup is required
- We need to store dynamic frequencies
- Duplicate elements exist

---------------------------------------

Time Complexity

Average case operations:

Insert → O(1)
Search → O(1)
Update → O(1)

---------------------------------------

Space Complexity

O(n)

In worst case, all elements may be stored in the map.

---------------------------------------

Explanation :

"I use a HashMap to store frequencies or
previous occurrences of elements so that
I can quickly check conditions in constant time
instead of scanning the array repeatedly."

---------------------------------------
