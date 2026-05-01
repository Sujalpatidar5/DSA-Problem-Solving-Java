/*
===========================================================
🔹 Problem: Map Sum Pairs – LeetCode 677
===========================================================

Given:
Design a data structure that supports:
1. insert(key, val)
2. sum(prefix) → return sum of all values of keys starting with prefix

===========================================================
🔹 Pattern Used & Why
===========================================================

Pattern: Trie + Prefix Sum

Why:
- Trie helps in prefix traversal
- Store cumulative sum at each node for fast queries

===========================================================
🔹 Key Idea
===========================================================

- Each Trie node stores:
  → sum of all keys passing through that node

- Handle updates using:
  diff = newVal - oldVal

===========================================================
🔹 Algorithm / Process (Step-by-Step)
===========================================================

Insert:
1. Calculate diff = val - oldValue
2. Update map (store latest value)
3. Traverse Trie:
   → create nodes if needed
   → add diff to sum at each node

Sum:
1. Traverse Trie using prefix
2. If path breaks → return 0
3. Otherwise → return node.sum

===========================================================
🔹 Code
===========================================================
*/

class MapSum {

    class Node {
        Node[] children = new Node[26];
        int sum = 0;
    }

    Node root;
    HashMap<String, Integer> map;

    public MapSum() {
        root = new Node();
        map = new HashMap<>();
    }

    // insert key with value
    public void insert(String key, int val) {

        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);

        Node curr = root;

        for (char c : key.toCharArray()) {

            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
            curr.sum += diff;
        }
    }

    // return sum of all values with given prefix
    public int sum(String prefix) {

        Node curr = root;

        for (char c : prefix.toCharArray()) {

            int idx = c - 'a';

            if (curr.children[idx] == null) {
                return 0;
            }

            curr = curr.children[idx];
        }

        return curr.sum;
    }
}

/*
===========================================================
🔹 Time Complexity
===========================================================

Let L = length of key/prefix

insert → O(L)
sum → O(L)

===========================================================
🔹 Space Complexity
===========================================================

Trie storage → O(N * L)
HashMap → O(N)

Total → O(N * L)

===========================================================
🔹 Example
===========================================================

insert("apple", 3)
sum("ap") → 3

insert("app", 2)
sum("ap") → 5

===========================================================
🔹 Explanation 
===========================================================

I use Trie where each node stores sum of all keys passing through it.

While inserting:
- I calculate diff (to handle updates)
- Then I add diff to every node in path

While finding sum:
- I just go to prefix node
- Return its stored sum

So query becomes very fast.

===========================================================
*/
