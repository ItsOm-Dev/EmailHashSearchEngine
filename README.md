# Email Hash Search Engine
## Introduction

This project is a **demo implementation** of a custom email storage and search engine using 2-digit character encoding and a multi-level dynamic hashing strategy. It aims to experiment with alternatives to traditional data structures like `HashMap` and B+ Trees for handling searchable datasets, specifically emails in this case.

Currently, it is in the **early stage of development** and primarily serves educational and experimental purposes. The focus is on understanding how encoding and hashing can be customized for performance in specific use cases.

Everyone is welcome to explore, use, fork, and contribute to this project. Feedback, feature suggestions, and pull requests are highly appreciated!

This project implements a custom multi-level hash table combined with character-level 2-digit encoding for email addresses. It demonstrates an efficient search system alternative to B+ Trees in controlled scenarios.

## Features

- Encodes email characters into fixed-length 2-digit codes.
- Implements three levels of hash tables to reduce collision and improve performance.
- Uses separate chaining via linked lists.
- Prevents duplicate insertions.
- Demonstrates insertion, search, and print functionalities.

## How to Run

1. Compile the project:

    javac -d out src/emailsearchengine/*.java

2. Run the program:

    java -cp out emailsearchengine.Main

## Improvements to Add

- Accept input from user or file
- Compare performance against TreeMap and HashMap
- Add JUnit test cases
- Support deletion of emails
- Export stored emails to a file

## Future Scope

The current system serves as a proof-of-concept for custom email storage and search using multi-level dynamic hashing. Here are several directions this project could be extended toward:

---

### 1.Full-Scale Search Engine for Emails

- Scale the design to handle millions of email records.
- Replace in-memory storage with file-based or database-backed indexing.
- Add search features like prefix matching, domain filtering, etc.

---

### 2.Email Management System

- Enable CRUD operations (Create, Read, Update, Delete) with proper indexing.
- Integrate user authentication to allow personalized email lists.
- Add tags, folders, or labels for categorizing emails.

---

### 3.Performance Benchmarking

- Compare the current hashing model with standard structures like `HashMap`, `TreeMap`, or even B+ Trees.
- Add time/memory profiling tools for insert and search operations.
- Optimize the hash function for large-scale datasets.

---

### 4.Persistent Storage Layer

- Allow reading/writing encoded emails from a persistent medium (e.g., SQLite, CSV, JSON).
- Automatically load stored data on startup and save on shutdown.

---

### 5.GUI or Web Interface

- Build a Java Swing or JavaFX GUI for better interactivity.
- Optionally develop a RESTful API or full web app using Spring Boot or Flask (via Jython or Python rewrite).

---

### 6.Unit Testing and Validation

- Add unit tests using JUnit for all core functionalities.
- Include edge case validation for encoding/decoding and collision handling.

---

### 7.Network-Ready Version

- Convert into a microservice that supports email registration and search over HTTP.
- Add endpoints for email insertion, deletion, and real-time search.

---

### 8.Security & Validation

- Implement input sanitization and email format validation.
- Encrypt stored email data to ensure privacy.

---

### 9.Real-World Integration

- Use in applications like spam filtering, email directory systems, or quick-search tools for large datasets.
- Could be adapted to store usernames, phone numbers, or other short searchable identifiers with minor changes.

---

### 10.Machine Learning Add-ons

- Integrate basic ML models to cluster or categorize emails (e.g., personal, work, promotional).
- Use email frequency or domain patterns to provide usage insights.

---

This project has the potential to evolve into a fast, lightweight, and customizable alternative to traditional indexing systems in domain-specific applications.


## License

Open-source under the MIT License.
