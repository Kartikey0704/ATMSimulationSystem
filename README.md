# ATM Simulation System

A desktop-based ATM simulation project built using Java and Swing, with MySQL as the backend database. The system replicates essential ATM functionalities including user authentication, balance inquiry, deposits, withdrawals, PIN change, and transaction history.

## Technologies Used

- Java (Core)
- Java Swing (GUI)
- JDBC (Database Connectivity)
- MySQL

## Features

- User registration and login with secure authentication
- Deposit and withdrawal functionalities with real-time balance updates
- Fast cash feature for quick withdrawals
- PIN change functionality
- Mini statement to view recent transactions
- Balance inquiry display
- Modular codebase with clear separation of UI, logic, and database layers

## Java Concepts Applied

- Object-Oriented Programming (OOP)
- Inheritance (extending JFrame for custom GUIs)
- Interface implementation (`ActionListener`) for event handling
- Exception handling
- JDBC with prepared statements for secure database operations

## Setup Instructions

1. Clone the repository:

2. Set up MySQL:
- Create a database (e.g., `bankmanagement`)
- Create necessary tables based on schema

3. Configure database credentials:
- Edit `Conn.java` with your MySQL username and password

4. Compile and run:

## Version History

- **v1.0** – Initial version with core ATM functionalities
- **v1.1** – Upcoming improvements (UI refinement, validations, error handling)
