# CS-2430-510-Summer2026
Set Operations

Student Name : Andrew Long
Professor Name: Jon McGowan
Course Name : Discrete Structures
Couse Number : CS - 2430 501


## Overview:

This project demonstrates core concepts from discrete mathmatics by implement ordinary set operations using Boolean arrays and Multiset operations using Integer arrays. 

## Features:

Ordinary Set Operations
NOT(A) 
A ∪ B – union
A ∩ B – intersection
A − B – set difference
A ⊕ B – symmetric difference, defined as (A − B) ∪ (B − A)

Multiset
Multiset union (A ∪ B)
Multiset intersection (A ∩ B)
Multiset difference (A − B)
Multiset sum (A + B)


## How It Works:

Program is hard coded

A universal set is created, and used to create two subsets. 
The subsets are converted into Boolean Arrays so we can easily implement binary operators to perform set operations. 

The same universal set is then used to create Multisets with Integers arrays and basic arithmetic to perform Multiset operations.

## Link to Project Video:


## Build information
JavaSE-21
created using the Eclipse IDE

## How to Run

### Requirements
- Java JDK 8 or higher
- JUnit 4 or 5 (for testing)
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans)

### Steps
```bash
# Clone the repository
git clone <your-repo-url>

# Open the project in your IDE

# Run the main class
Run Main.java