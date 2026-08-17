/*
========================================
Problem: 811. Subdomain Visit Count
========================================

Problem Statement:

You are given an array of strings.

Each string contains:

    count domain

For example:

    "9001 discuss.leetcode.com"

This means:

    discuss.leetcode.com -> 9001 visits

We need to calculate the total visits for:

    discuss.leetcode.com
    leetcode.com
    com

Because every visit to a subdomain is also a visit
to its parent domain.

----------------------------------------
Pattern Used:
HashMap + String Manipulation

Why:

- We need to store the total count of every domain.
- HashMap allows us to store:

      domain -> total visits

- We remove the first part of the domain one by one
  to get all its parent domains.

----------------------------------------
Key Idea:

For:

    "9001 discuss.leetcode.com"

First add:

    discuss.leetcode.com -> 9001

Then remove "discuss.":

    leetcode.com -> 9001

Then remove "leetcode.":

    com -> 9001

So every domain gets the same visit count.

----------------------------------------
Algorithm / Process:

For every string:

1. Split it into:

      count
      domain

2. Add count to the complete domain.

3. While the domain contains '.':

      Find the first '.'

      Remove everything before that '.'

      The remaining part is the parent domain.

4. Add the same count to every parent domain.

5. Finally, convert the HashMap entries into strings.

----------------------------------------
Code:
*/

import java.util.*;

class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cpdomains.length; i++) {

            String arr[] = cpdomains[i].split(" ");

            int count = Integer.parseInt(arr[0]);

            String domain = arr[1];

            // Add complete domain
            map.put(domain, map.getOrDefault(domain, 0) + count);

            // Add parent domains
            while (domain.indexOf('.') != -1) {

                int dot = domain.indexOf('.');

                domain = domain.substring(dot + 1);

                map.put(domain,
                        map.getOrDefault(domain, 0) + count);
            }
        }

        // Convert HashMap into required answer format
        for (String key : map.keySet()) {

            String ans = map.get(key) + " " + key;

            res.add(ans);
        }

        return res;
    }
}

/*
----------------------------------------
Time & Space Complexity

Let L be the total number of characters
in all domain strings.

Time Complexity:
O(L)

We process each domain and its parent domains.

HashMap operations are O(1) on average.

Space Complexity:
O(L)

The HashMap stores all unique domains and subdomains.

----------------------------------------
Example

Input:

cpdomains = [
    "9001 discuss.leetcode.com"
]

Output can be:

[
    "9001 discuss.leetcode.com",
    "9001 leetcode.com",
    "9001 com"
]

----------------------------------------
Dry Run

Input:

"9001 discuss.leetcode.com"

--------------------------------

Step 1:

Split the string:

arr[0] = "9001"
arr[1] = "discuss.leetcode.com"

Convert count:

count = 9001

domain:

discuss.leetcode.com

--------------------------------

Step 2:

Add complete domain:

map:

discuss.leetcode.com -> 9001

--------------------------------

Step 3:

Domain contains '.'.

Find first '.':

discuss.leetcode.com
       ^
       first dot

Remove everything before the dot:

domain = leetcode.com

Add:

leetcode.com -> 9001

--------------------------------

Step 4:

Again domain contains '.'.

leetcode.com
         ^
         dot

Remove everything before the dot:

domain = com

Add:

com -> 9001

--------------------------------

Step 5:

"com" does not contain '.'

Stop.

Final map:

discuss.leetcode.com -> 9001
leetcode.com         -> 9001
com                  -> 9001

----------------------------------------
Important Part

This line:

domain = domain.substring(dot + 1);

is the main string operation.

Suppose:

domain = "discuss.leetcode.com"

First dot is after:

"discuss"

So:

dot = 7

substring(dot + 1)

means:

substring(8)

Result:

"leetcode.com"

Then again:

"leetcode.com"

becomes:

"com"

So we keep removing the leftmost subdomain.

----------------------------------------
Why do we add the same count?

Suppose:

9001 users visit:

discuss.leetcode.com

Those 9001 visits are also visits to:

leetcode.com

and:

com

Therefore:

discuss.leetcode.com -> +9001

leetcode.com         -> +9001

com                   -> +9001

----------------------------------------
Example with Multiple Domains

Input:

[
    "900 google.mail.com",
    "50 yahoo.com",
    "1 intel.mail.com"
]

For:

900 google.mail.com

We add:

google.mail.com -> 900
mail.com        -> 900
com             -> 900

For:

50 yahoo.com

We add:

yahoo.com -> 50
com       -> 50

Now:

com = 900 + 50 = 950

For:

1 intel.mail.com

We add:

intel.mail.com -> 1
mail.com       -> 1
com            -> 1

Now:

mail.com = 900 + 1 = 901

and:

com = 950 + 1 = 951

So the HashMap automatically combines
the counts of the same domains.

----------------------------------------
Why getOrDefault()?

This line:

map.put(domain,
        map.getOrDefault(domain, 0) + count);

means:

If the domain already exists,
get its current count.

Otherwise,
consider its count as 0.

Then add the current count.

Example:

Current map:

com -> 900

New count:

50

Then:

map.getOrDefault("com", 0)

returns:

900

So:

900 + 50 = 950

Then:

com -> 950

----------------------------------------
Simple Understanding

Think of every domain as having a counter.

For:

"900 discuss.leetcode.com"

we increase three counters:

discuss.leetcode.com
leetcode.com
com

by 900.

For every new input,
we do the same thing.

If a domain already exists,
we add the new visits to its old visits.

HashMap is perfect for this because
it stores the domain as the key
and its total visit count as the value.

----------------------------------------
Interview Explanation

I use a HashMap to store the total visit count
for every domain and its parent domains.

For each input string, I first separate the count
and the complete domain.

I add the count to the complete domain.

Then I repeatedly remove the leftmost part of the domain
using the first dot.

This gives all the parent domains.

For example:

discuss.leetcode.com

becomes:

leetcode.com

and then:

com

I add the same visit count to all of them.

Finally, I convert all HashMap entries into the required
"count domain" format.

The time complexity is O(L), where L is the total
length of the domain strings, and the space complexity
is O(L).

----------------------------------------
Short Memory Trick

// HashMap: domain -> count
// Add complete domain
// Remove left part using first '.'
// Add every parent domain
// getOrDefault() combines repeated domains
*/
