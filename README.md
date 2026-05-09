# COMPX201 Assignment 3 – Hash Table Project

## Overview
This project is part of COMPX201 (Data Structures & Algorithms).  
It implements a hash table to store and manage music records. The system allows fast searching, adding, and removing of records using hashing with linear probing.

---

## Features
- Store records using a hash table
- Uses **folding hash function** based on record title
- Collision handling using **linear probing**
- Automatic resizing using **rehashing (double size at 80% load)**
- Search records by title
- Add new records
- Remove records
- Print full table contents
- Check if table is empty
- Get number of records stored

---

## Classes

### Record.java
Stores details of a music record:
- genre
- year
- artist
- title

Includes getters and a `toString()` method.

---

### RecordHashTable.java
Main hash table implementation:
- put()
- remove()
- get()
- contains()
- hashFunction()
- rehash()
- size()
- isEmpty()
- dump()

Uses an array and linear probing for collisions.

---

### RecordLookup.java
Main program that:
- Loads data from a CSV file
- Provides a simple menu system
- Lets user search, add, remove, and view records

---

### HashTableTest.java
JUnit tests written manually to check:
- basic functionality
- correct behaviour of all methods
- expected outputs

---

### HashTableAITest.java
Extra tests generated with AI and improved manually:
- edge cases
- duplicate values
- rehashing tests
- empty table cases

---

## Input File
The program uses a CSV file: