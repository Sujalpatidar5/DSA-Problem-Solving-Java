/*
Problem: 49. Group Anagrams
Link: https://leetcode.com/problems/group-anagrams/

-----------------------------------------------------

Problem Statement

Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters
of another word using exactly the same letters.

Example:
"eat", "tea", and "ate" are anagrams.

-----------------------------------------------------

Pattern Used & Why

Pattern: HashMap + Frequency Encoding

Why:
All anagrams have the same character frequency.
If we encode each word's frequency as a unique key,
all anagrams will share the same key in the HashMap.

-----------------------------------------------------

Key Idea

For each word:

1. Count frequency of characters (26 letters).
2. Convert the frequency array into a string key.
3. Store the word inside a HashMap using this key.

All words with the same key are grouped together.

-----------------------------------------------------

Algorithm / Process

1. Create a HashMap<String, List<String>>.
2. For each word in the array:
   - Create frequency array of size 26.
   - Count characters of the word.
3. Convert frequency array to a string key.
4. If key not present → create new list.
5. Add word into the list corresponding to the key.
6. Return all values of the HashMap.

-----------------------------------------------------

Code
*/

import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] freq = new int[26];

            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}

/*
-----------------------------------------------------

Time Complexity

O(n * k)

n = number of strings
k = average length of each string

-----------------------------------------------------

Space Complexity

O(n)

For storing grouped anagrams in the HashMap.

-----------------------------------------------------

Example

Input:
strs = ["eat","tea","tan","ate","nat","bat"]

Output:
[
 ["eat","tea","ate"],
 ["tan","nat"],
 ["bat"]
]

Explanation:
All words with identical character frequency are grouped together.

-----------------------------------------------------

Explanation :

For each string, compute its character frequency (26 letters).
Use this frequency representation as a key in a HashMap.
All anagrams will generate the same key and therefore
will be grouped together.
*/
