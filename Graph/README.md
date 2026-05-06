#  Graph Data Structure 
---

## 🔹 What is a Graph?

A **Graph** is a non-linear data structure consisting of:

- **Vertices (Nodes)** → represent entities
- **Edges** → represent connections between nodes

 Example:
- Cities = Nodes
- Roads = Edges

---

## 🔹 Basic Terminology

- Vertex (Node)
- Edge (Connection)
- Degree = number of edges connected to a node
- Path = sequence of nodes
- Cycle = path that starts and ends at same node

---

## 🔹 Types of Graphs

### 1. Based on Direction

#### 🔸 Undirected Graph
- Edges have **no direction**
- Connection is **bidirectional**

 Example:
A — B means A ↔ B

#### 🔸 Directed Graph (Digraph)
- Edges have **direction**
- One-way connection

 Example:
A → B

---

### 2. Based on Weight

#### 🔸 Weighted Graph
- Each edge has a **weight**
- Represents cost, distance, time

 Example:
A --(5)--> B

#### 🔸 Unweighted Graph
- All edges are treated equally
- No cost associated

---

### 3. Based on Cycles

#### 🔸 Cyclic Graph
- Contains at least one cycle

#### 🔸 Acyclic Graph
- No cycle exists

#### 🔸 DAG (Directed Acyclic Graph)
- Directed graph with no cycles

---

## 🔹 Graph Representation

---

### 1. Adjacency Matrix

- 2D array used to represent graph

 matrix[i][j] = 1 → edge exists  
 matrix[i][j] = 0 → no edge  

#### 🔹 For Weighted Graph:
 matrix[i][j] = weight

---

###  Complexity

- Space → O(V²)
- Edge check → O(1)

---

###  Advantages

- Simple to implement
- Fast edge lookup

---

###  Disadvantages

- High space usage
- Not good for sparse graphs
- Traversal takes O(V)

---

###  When to Use

- Dense graphs (more edges)
- Small number of vertices

---

---

### 2. Adjacency List

- Array/List of lists
- Each index stores its neighbors

 graph[i] → list of neighbors of node i

---

###  Complexity

- Space → O(V + E)
- Traversal → O(degree of node)

---

###  Advantages

- Space efficient
- Best for sparse graphs
- BFS/DFS easy

---

###  Disadvantages

- Edge check slower than matrix
- Slightly complex implementation

---

###  When to Use

- Sparse graphs
- Real-world applications
- Traversal problems

---

## 🔹 Real-Life Applications of Graph

---

### 1. Google Maps / Navigation
- Nodes → Locations
- Edges → Roads  
- Algorithms like **Dijkstra** find shortest path

---

### 2. Social Networks
- Users → Nodes  
- Friendships → Edges  
- Used for:
  - Friend suggestions
  - Community detection

---

### 3. Recommendation Systems
- Users + Products = Graph  
- Used in:
  - Netflix
  - Amazon  
- Recommend based on connections

---

### 4. Computer Networks
- Computers/Routers → Nodes  
- Connections → Edges  
- Helps in routing & optimization

---

### 5. Web Page Ranking (Google Search)
- Pages → Nodes  
- Links → Edges  
- Uses **PageRank Algorithm**

---

## 🔹 Key Observations (Important)

- Graph is everywhere in real world
- Two main representations:
   Adjacency Matrix  
   Adjacency List  

- Choice depends on:
   Dense vs Sparse graph

---

## 🔹 Summary

| Feature | Matrix | List |
|--------|--------|------|
| Space | O(V²) | O(V+E) |
| Edge Check | O(1) | O(V) |
| Best For | Dense | Sparse |

---

## 🔹 Explanation

I understand graph as:

- Nodes = entities
- Edges = connections

Depending on problem:
- If graph is dense → I use matrix
- If graph is sparse → I use adjacency list

For traversal problems:
- BFS / DFS works best with adjacency list

Graph is mainly used to model real-world connections like maps, social networks, etc.

---
