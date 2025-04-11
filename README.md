# Meesho Machine Coding Round – Round 2

Welcome to the **Meesho Machine Coding Round – Round 2** repository. This repository contains a solution to a machine coding challenge encountered during a second-round interview process for the [Meesho Open Campus Recruitment 2025](https://www.hackerearth.com/challenges/hackathon/meesho-open-campus-recruitment-2025/) challenge on HackerEarth. The solution is implemented in Java.

---

## Table of Contents

- [Overview](#overview)
- [Problem Statement](#problem-statement)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Compilation & Execution](#compilation--execution)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## Overview

This project provides a simple, elegant, and well-documented Java solution to a coding problem from Meesho’s machine coding round. For ease of reference, the complete problem description—including requirements and sample test cases—is included directly in this README.

---

## Problem Statement

Design a vending machine that allows users to **view available items**, **register new items**, **select an item**, **insert money**, and **complete a purchase**. The system should handle inventory management and return appropriate change.

### Core Functionalities

- **VIEW ITEMS:**  
  Display all available items including:
  - Item code
  - Name
  - Price
  - Quantity

- **REGISTER ITEM `<name> <price> <initial_quantity>`:**  
  Add a new item to the inventory.

- **SELECT_ITEM `<item_code>`:**  
  Choose an item for purchase.

- **INSERT_MONEY `<amount>`:**  
  Insert money toward the selected item’s cost.

### Sample Test Cases

1. **Test Case 1:**
   - **Input:**  
     ```
     VIEW_ITEMS
     ```
   - **Output:**  
     ```
     No items available
     ```

2. **Test Case 2:**
   - **Input:**  
     ```
     REGISTER_ITEM Cola 35 5
     ```
   - **Output:**  
     ```
     Item added successfully, item_code: 1
     ```

3. **Test Case 3:**
   - **Input:**  
     ```
     SELECT_ITEM 1
     ```
   - **Output:**  
     ```
     You selected: Cola (235)
     ```

4. **Test Case 4:**
   - **Input:**  
     ```
     INSERT_MONEY 20
     ```
   - **Output:**  
     ```
     Payment received: 20. Remaining amount: 15
     ```

5. **Test Case 5:**
   - **Input:**  
     ```
     INSERT_MONEY 20
     ```
   - **Output:**  
     ```
     Payment received: ₹20. Dispensing Cola. Returning change: ₹5
     ```

---

## Project Structure

The repository is organized as follows:

```
.
├── Question.txt       # Contains the detailed problem description (see below)
└── Solution.java      # Java source file implementing the solution
```

*(Note: The full problem statement is also included directly in this README.)*

---

## Prerequisites

Before running the solution, ensure that you have installed:

- **Java JDK 8** (or a higher version)

---

## Compilation & Execution

To compile and run the solution, follow these steps:

1. **Compile the Java source code:**

   ```bash
   javac Solution.java
   ```

2. **Run the compiled program:**

   ```bash
   java Solution
   ```

---

## Contributing

Contributions are always welcome! If you have suggestions, improvements, or bug fixes, please:

1. Fork the repository.
2. Create a new branch for your changes.
3. Commit your changes.
4. Submit a pull request.

Alternatively, feel free to open an issue if you encounter any problems or have ideas for enhancements.

---

## License

This project is open source. If a license file is provided in the repository, please refer to that file for full details. Otherwise, feel free to use and modify the code as you see fit.

---

## Contact

For any questions, suggestions, or feedback:
- Open an issue in this repository.
- Contact me directly on GitHub.

---

*Happy Coding!*
