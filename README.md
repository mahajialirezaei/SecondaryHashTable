## **Secondary Hash Table**  
### **A Java-Based University Project (KNTU)**  

This project is an implementation of a **Secondary Hash Table** in Java, developed as part of an academic project at **Khajeh Nasir Toosi University of Technology (KNTU)**. The project aims to enhance the efficiency of hash tables by minimizing collisions and optimizing data retrieval.

---

## **Features**  
✅ **Efficient Hashing Technique** – Uses a **secondary hashing method** to reduce collisions and improve performance.  
✅ **Optimized Lookup & Storage** – Implements a structured approach to storing and retrieving data.  
✅ **Collision Resolution** – Reduces hash conflicts effectively using secondary hash functions.  
✅ **Java-Based Implementation** – Developed entirely in **Java**, making it portable and easy to integrate into other Java projects.  
✅ **Academic Project** – Designed for educational purposes, demonstrating the principles of hash table optimizations.  

---

## **Installation & Usage**  

### **Prerequisites**  
- **Java Development Kit (JDK) 8 or later**  
- Any Java-compatible **IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)**  

### **Clone the Repository**  
```sh
git clone https://github.com/mahajialirezaei/SecondaryHashTable.git
cd SecondaryHashTable
```

### **Compile and Run the Project**  
```sh
javac -d bin src/*.java
java -cp bin Main
```

---

## **Project Structure**  
```
SecondaryHashTable/
│── src/                    # Source code directory  
│   ├── Main.java           # Main execution class  
│   ├── SecondaryHashTable.java # Core class implementing secondary hashing  
│   ├── HashNode.java       # Node structure for the hash table  
│   └── Utils.java          # Utility functions for hash computation  
│── bin/                    # Compiled class files  
│── README.md               # Project documentation  
│── LICENSE                 # License information  
```

---

## **How It Works**  
1. **Primary Hashing**: Computes an initial hash index using a primary hash function.  
2. **Collision Handling**: If a collision occurs, a **secondary hash function** is used to determine an alternative index.  
3. **Data Storage**: Elements are placed in the table at the computed index, ensuring efficient retrieval.  
4. **Search & Retrieval**: The lookup function first checks the primary index and, if necessary, applies secondary hashing for precise retrieval.  

---

## **Example Usage**  
Here’s a simple example of inserting and searching elements in the Secondary Hash Table:  

```java
public class Main {
    public static void main(String[] args) {
        SecondaryHashTable<Integer, String> hashTable = new SecondaryHashTable<>(10);

        hashTable.put(1, "Alice");
        hashTable.put(2, "Bob");
        hashTable.put(15, "Charlie"); // Collides with index 5, uses secondary hash

        System.out.println("Value for key 2: " + hashTable.get(2)); // Output: Bob
        System.out.println("Value for key 15: " + hashTable.get(15)); // Output: Charlie
    }
}
```

---

## **Contributing**  
Contributions are welcome! If you’d like to improve the project, follow these steps:  
1. **Fork** the repository.  
2. **Create** a feature branch (`git checkout -b feature-branch`).  
3. **Commit** your changes (`git commit -m "Add new feature"`).  
4. **Push** to the branch (`git push origin feature-branch`).  
5. **Open a Pull Request** and describe your changes.  

---

## **License**  
This project is licensed under the **MIT License** – feel free to use, modify, and distribute it.  

---

## **Contact**  
For any questions or suggestions, feel free to contact the author:  
📧 **Email:** m.a.hajialirezaei05@gmail.com
🔗 **GitHub:** (https://github.com/mahajialirezaei)  

---
