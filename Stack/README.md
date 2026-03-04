# Stack Pattern

---------------------------------------

## Definition

Stack is a **Linear Data Structure** that follows the **LIFO principle**.

LIFO = **Last In First Out**

This means the element inserted last will be removed first.

Example:

Push operations:
1 → 2 → 3

Stack:

Top  
3  
2  
1  

Pop operation → 3 will be removed first.

---------------------------------------

## Basic Stack Operations

 push() - Insert element into stack 
 pop() - Remove top element 
 peek() - View top element without removing 
 isEmpty() - Check if stack is empty 

---------------------------------------

## Java Stack Syntax

```java
import java.util.*;

Stack<Integer> stack = new Stack<>();

stack.push(10);      // add element

stack.peek();        // see top element

stack.pop();         // remove top element

stack.isEmpty();     // check empty
```

---------------------------------------

# When To Use Stack

Stack is generally used when problems involve:

### 1. Reversing Order
When elements need to be processed in **reverse order**.

Example:
- Reverse a string
- Reverse linked list using stack

---

### 2. Parentheses / Bracket Problems
When we need to check **balanced expressions**.

Examples:
- Valid Parentheses
- Minimum Add to Make Parentheses Valid

---

### 3. Previous / Next Greater or Smaller Element

When the question asks for:

- Next Greater Element
- Next Smaller Element
- Previous Greater Element
- Previous Smaller Element

These problems are solved using **Monotonic Stack**.

---

### 4. Span Problems

Examples:

- Stock Span Problem
- Daily Temperatures

We use stack to find the **nearest greater element** efficiently.

---

### 5. Histogram / Rectangle Problems

Examples:

- Largest Rectangle in Histogram
- Maximal Rectangle

These problems use **monotonic stack**.

---

### 6. Expression Evaluation

Examples:

- Evaluate Reverse Polish Notation
- Infix to Postfix
- Prefix Evaluation

Stack helps manage **operator precedence and operands**.

---------------------------------------

# Important Observation

Stack is usually used when:

- We need to **process elements in reverse order**
- We need to **track previous elements**
- We need **nearest greater/smaller element**
- The problem involves **nested structures**

---------------------------------------

# Basic Stack Template

```java
Stack<Integer> stack = new Stack<>();

for(int i = 0; i < n; i++){

    while(!stack.isEmpty() && condition){
        stack.pop();
    }

    stack.push(arr[i]);
}
```

Explanation:

1. Traverse array
2. While condition fails → pop elements
3. Push current element
4. Stack maintains useful elements only

---------------------------------------


# Explanation :

"Stack is used when we need to process elements in reverse order or track previous elements.  
It follows LIFO order and helps efficiently solve problems like parentheses validation, next greater element, and monotonic stack problems."

---------------------------------------
