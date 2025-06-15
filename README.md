# Email Hash Search Engine

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

## License

Open-source under the MIT License.
