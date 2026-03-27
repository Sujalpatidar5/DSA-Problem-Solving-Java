/*
Problem: Allocate Minimum Pages (GFG)

-----------------------------------------------------

Problem Statement

Given an array arr[] where arr[i] represents number of pages in i-th book,
and k students, allocate books such that:

- Each student gets at least one book
- Books are allocated in contiguous manner
- Minimize the maximum pages assigned to a student

-----------------------------------------------------

Pattern Used & Why

Pattern: Binary Search on Answer

Why:
We are minimizing the maximum pages → search space = [max(arr), sum(arr)]

-----------------------------------------------------

Key Idea

- Minimum possible answer = max(arr)
- Maximum possible answer = sum(arr)
- Binary search on this range
- Check if allocation possible for k students

-----------------------------------------------------

Algorithm / Process

1. If n < k → return -1
2. Find:
   low = max(arr)
   high = sum(arr)
3. Binary search:
   - mid = possible max pages
   - If allocation possible:
        store answer
        search left (minimize)
   - Else:
        search right

-----------------------------------------------------

Code
*/

class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        if (n < k) return -1;
        
        int low = 0, high = 0;
        for (int i = 0 ; i < n ; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        
        int ans = -1;
        
        while (low <= high) {
            int guess = (low + high) / 2;
            
            if (countStud(arr,guess,k)) {
                ans = guess;
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }
        return ans;
    }
    
    private boolean countStud (int books[], int guess, int k) {
        int stu = 1, pages = 0;
        
        for (int i = 0 ; i < books.length; i++) {
            if (pages + books[i] <= guess) {
                pages += books[i];
            } else {
                stu++;
                pages = books[i];
                
                if (stu > k) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
-----------------------------------------------------

Time Complexity
O(n * log(sum))

-----------------------------------------------------

Space Complexity
O(1)

-----------------------------------------------------

Example

Input:
arr = [12,34,67,90], k = 2

Output:
113

-----------------------------------------------------

Explanation :

Binary search on answer.
Check karo ki given max pages me allocation possible hai ya nahi.
Possible → answer store + left search
Not possible → right search

*/
