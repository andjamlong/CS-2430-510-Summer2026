# CS-2430-510-Summer2026
Sorting Algorithm Comparison Project

Student Name : Andrew Long
Professor Name: Jon McGowan
Course Name : Discrete Structures
Couse Number : CS - 2430 501


## Overview:

This project compares the performance of four sorting algorithms: Merge Sort, Quick Sort, Heap Sort, and Shaker Sort. The program generates random integer arrays of different sizes, sorts them using each algorithm, and tracks the number of comparisons made to evaluate efficiency.

The goal of this project is to better understand algorithm performance, especially how efficiency changes as input size increases.


## Features:

Random array generation using Java Random
Multiple input sizes (defined in sizes array)
Comparison counter for each algorithm
JUnit test cases for correctness verification
Output table showing performance results


## How It Works:

Program generates arrays of integers using random values.
Each array is copied and passed into all four sorting algorithms.
Each algorithm sorts the array while tracking comparisons.
Results are printed showing:
Sorted arrays
Number of comparisons per algorithm
JUnit tests validate correctness of sorting implementations.

Testing:

The project includes JUnit tests that check:

Small arrays (basic correctness)
Larger arrays (scalability)
Arrays with duplicate values (edge cases)

## Link to Project Video:
https://youtu.be/64ZeFRgfGGs


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
Run Project1.java