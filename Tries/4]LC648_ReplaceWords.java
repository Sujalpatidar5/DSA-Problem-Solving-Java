/*
===========================================================
🔹 Problem: Replace Words – LeetCode 648
===========================================================

Given:
- A dictionary of root words
- A sentence

Replace every word in sentence with the SHORTEST root word
that is its prefix.

If no prefix found → keep original word

===========================================================
🔹 Pattern Used & Why
===========================================================

Pattern: Trie (Prefix Matching)

Why:
- Fast prefix search
- We need SHORTEST matching prefix → Trie best fits

===========================================================
🔹 Key Idea
===========================================================

- Insert all dictionary words into Trie
- For each word in sentence:
  → Traverse Trie
  → Stop at first eow (shortest prefix)
  → Replace word

===========================================================
🔹 Algorithm / Process (Step-by-Step)
===========================================================

Step 1: Build Trie
- Insert all dictionary words

Step 2: Process sentence
- Split sentence into words

Step 3: For each word:
- Traverse Trie character by character
- If path not found → return original word
- If eow found → return prefix immediately

Step 4: Join all processed words

===========================================================
🔹 Code
===========================================================
*/

class Solution {

    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    Node root = new Node();

    // insert in Trie
    public void insert(String word) {

        Node curr = root;

        for (char c : word.toCharArray()) {

            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    // find shortest prefix
    public String getPrefix(String word) {

        Node curr = root;
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {

            int idx = c - 'a';

            // no path → return original word
            if (curr.children[idx] == null) {
                return word;
            }

            prefix.append(c);
            curr = curr.children[idx];

            // first prefix found → return
            if (curr.eow) {
                return prefix.toString();
            }
        }

        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        // Step 1: build Trie
        for (String word : dictionary) {
            insert(word);
        }

        // Step 2: split sentence
        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        // Step 3: process each word
        for (String w : words) {
            result.append(getPrefix(w)).append(" ");
        }

        return result.toString().trim();
    }
}

/*
===========================================================
🔹 Time Complexity (Step-by-Step)
===========================================================

Let:
d = number of dictionary words
l = average length of dictionary word
s = total characters in sentence

1. Building Trie:
- Insert each word → O(l)
- Total → O(d * l)

2. Processing sentence:
- For each word → traverse at most its length
- Total → O(s)

--------------------------------------------
Total Time = O(d * l + s)
--------------------------------------------

===========================================================
🔹 Space Complexity
===========================================================

Trie:
- Each character stored once
→ O(d * l)

Extra space:
- result + recursion negligible

--------------------------------------------
Total Space = O(d * l)
--------------------------------------------

===========================================================
🔹 Example
===========================================================

dictionary = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"

Output:
"the cat was rat by the bat"

===========================================================
🔹 Explanation 
===========================================================

I build a Trie using all dictionary words.

Then for each word in sentence:
- I try to match prefix in Trie
- If path breaks → return original word
- If I hit eow → return that prefix immediately

So I always get shortest root word.

===========================================================
*/
