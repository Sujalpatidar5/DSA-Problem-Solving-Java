/*
===========================================================
🔹 Problem: Implement Trie (Prefix Tree) – LeetCode 208
===========================================================

Given:
Design a Trie with insert, search, and startsWith functions.

===========================================================
🔹 Pattern Used & Why
===========================================================

Pattern: Trie (Prefix Tree)

Why:
- Efficient string storage
- Fast prefix searching
- Each character stored as node

===========================================================
🔹 Key Idea
===========================================================

- Each node has 26 children (a–z)
- Traverse character by character
- Create nodes if not present
- Mark end of word using boolean flag

===========================================================
🔹 Algorithm / Process
===========================================================

Insert:
1. Start from root
2. For each character:
   - Find index (ch - 'a')
   - Create node if null
   - Move to next node
3. Mark last node as end of word

Search:
1. Traverse characters
2. If any node missing → return false
3. At end → check endOfWord

StartsWith:
1. Traverse characters
2. If path exists → return true

===========================================================
🔹 Code
===========================================================
*/

class Trie {

    class Node {
        Node[] children = new Node[26];
        boolean eow = false; // end of word
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public boolean search(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public boolean startsWith(String prefix) {

        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {

            int idx = prefix.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }
}

/*
===========================================================
🔹 Time & Space Complexity
===========================================================

Insert → O(L)
Search → O(L)
StartsWith → O(L)

Space → O(N * L)

===========================================================
🔹 Example
===========================================================

insert("cat")
insert("car")

search("cat") → true
search("ca") → false
startsWith("ca") → true

===========================================================
🔹 Explanation 
===========================================================

I use a Trie where each node stores links to next characters.

For insert:
- I go character by character
- If node doesn’t exist, I create it

For search:
- I follow the path
- At the end, I check if it is marked as a complete word

For prefix:
- I just check if path exists, no need to check end

===========================================================
*/
