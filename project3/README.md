Optimal Selection 

Student Name : Andrew Long
Professor Name: Jon McGowan
Course Name : Discrete Structures
Couse Number : CS - 2430 501


## Overview:

This project tackles the knapsack problem, and shows how algorithmic designcan transform abstract mathmatical reasoning into practical decision making tools. 
In this project instead of items being loaded into a knapsack, we are deciding what expirements to bring into a space shuttle.

## Features:

Greedy Approach : sorts by a feature of the expirment (weight, rating, ratio of weight and rating) and loads the expirments in order one by one (assuming the addition does not put us over weight limit)

Brute Force Approach : Test all items of the superset of expirements. 

Dynamic Programming Approach: It builds a table where dp[i][w] represents the total rating using experiments i with the weight limit w.  
Considers each experiment one at a time and decides whether to include it or exclude it based on the choice that results in a higher rating without going over weight limit.
After table is filled, the method tracks back through the table to determine which experiments are optimal to include


## How It Works:

Program is hard coded

A class is created called Experiment, which we use to hard code all 12 expirments as indicated by the assigment inside an array called expirements. 

There are three methods to sort the array, one by highest rating, one by lowest weight, and the last one is sorted by the highest ration of weight and points. We plug each sorted array into our greedyKnapsack method to load our shuttle. 

For the brute force approach, we need to iterate through all 4096 possible subsets of the superset expirement. To assist with this I use a bitmask, go through each subset, confirm if it is below our weight limit, than compare it to the current top three subsets by rating. If the current subset is better than any of the top three, it takes its place and shifts it down (along with anythin else downstream). 

The program than compares the results of the greedy approaches to the optimal solution found by the brute force to see if we by chance found an optimal solution. 

As extra credit I include a dynamic programming approach, which as stated above uses a table to help determine the optimal solution, a method with a much larger scalability. 

## Link to Project Video:
https://www.youtube.com/watch?v=T5zuMJS2SXs&feature=youtu.be

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