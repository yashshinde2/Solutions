# Java OOP Complete Question Bank 🎯
## Comprehensive Practice Guide for Placements

---

## **PHASE 1: FUNDAMENTALS (Classes, Objects, Constructors)**

### EASY LEVEL

**Q1: Basic Class & Object**
Create a `Student` class with:
- Properties: name, rollNumber, gpa
- A method to display student details
- Create 3 student objects and display their information

**Q2: Constructor Basics**
Create a `BankAccount` class with:
- Properties: accountNumber, balance, accountHolder
- A parameterized constructor to initialize all properties
- A method to display account details

**Q3: Constructor Overloading**
Create a `Rectangle` class with:
- Properties: length, width
- Three constructors: 
  - No-arg (default: 1x1)
  - One parameter (square: same length and width)
  - Two parameters (custom length and width)
- Method: `calculateArea()`

**Q4: Default Constructor Behavior**
What will be the output? Explain why.
```java
public class Test {
    int x;
    String name;
    boolean flag;
    
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(x + " " + name + " " + flag);
    }
}
```

**Q5: this() Constructor Call**
Create a `Person` class where:
- Constructor 1 takes only name, calls Constructor 2
- Constructor 2 takes name and age
- Both initialize respective fields
- Demonstrate with objects

### MEDIUM LEVEL

**Q6: Copy Constructor**
Create a `Book` class with:
- Properties: title, author, pages
- Parameterized constructor
- Copy constructor
- Create an original and copied book, modify one and show they're independent

**Q7: Constructor Chaining**
Create a `Employee` class with:
- 3 constructors of increasing complexity (1 param → 2 params → 3 params)
- Each constructor chains to the next using `this()`
- All constructors call a common initialization method

**Q8: Object Reference & Aliasing**
```java
Employee e1 = new Employee("John");
Employee e2 = e1;
e2.setName("Jane");
System.out.println(e1.getName());  // Output?
```
Explain what happens and why.

**Q9: Anonymous Objects**
Create a method that takes a Student object and prints details. Call this method using an anonymous object (without storing in a variable).

**Q10: Garbage Collection & Nulling**
```java
Student s1 = new Student();
Student s2 = new Student();
s1 = null;
s2 = s1;
System.out.println(s2);  // Output?
```
What objects are eligible for garbage collection?

---

## **PHASE 2: STATIC & FINAL KEYWORDS**

### EASY LEVEL

**Q11: Static Variables**
Create a `Counter` class with:
- A static variable `count` starting at 0
- Each time an object is created, `count` increments
- A static method to display `count`
- Create 5 objects and print count after each creation

**Q12: Static Method Usage**
Create a `MathUtils` class with static methods:
- `add(int a, int b)` - returns sum
- `multiply(int a, int b)` - returns product
- `isEven(int n)` - returns boolean
- Call these without creating an object

**Q13: Static Block**
```java
public class Demo {
    static {
        System.out.println("Static block executed");
    }
    public static void main(String[] args) {
        System.out.println("Main method executed");
    }
}
```
What's the output? When does static block execute?

**Q14: Final Variables**
Create a `Circle` class with:
- A final variable `PI = 3.14159`
- Try to modify PI (what happens?)
- Use final variable in methods

**Q15: Final Methods**
Create a parent class with:
- A final method that shouldn't be overridden
- Try to override it in child class
- Explain the error

### MEDIUM LEVEL

**Q16: Static + Instance Variable Conflict**
```java
public class Test {
    static int x = 10;
    int x = 20;  // Does this compile?
    
    public static void main(String[] args) {
        System.out.println(x);  // Which x?
    }
}
```

**Q17: Static Initialization Order**
```java
public class Order {
    static int a = getValue();
    static int b = 20;
    static int c;
    
    static {
        c = 30;
    }
    
    static int getValue() {
        System.out.println("Getting value");
        return 10;
    }
    
    public static void main(String[] args) {
        System.out.println(a + " " + b + " " + c);
    }
}
```
What's the execution order and output?

**Q18: Static Reference in Instance Method**
Can an instance method access static variables? Can a static method access instance variables? Explain with examples.

**Q19: Final Objects**
```java
final Student s = new Student();
s = new Student();  // Is this allowed?
s.setName("John");  // Is this allowed?
```
Explain what final means for objects.

**Q20: Static Factory Method**
Create a `DatabaseConnection` class with:
- Private constructor
- Static method `getInstance()` that returns a connection object
- Show how this pattern is useful

---

## **PHASE 3: METHODS & OVERLOADING**

### EASY LEVEL

**Q21: Method Overloading - Primitives**
Create a `Printer` class with overloaded `print()` methods for:
- `int`, `double`, `String`, `boolean`
- Call each with different data types

**Q22: Method Overloading - Different Number of Parameters**
Create a `Calculator` class with overloaded `add()` methods:
- 2 parameters: `add(int a, int b)`
- 3 parameters: `add(int a, int b, int c)`
- Variable parameters: `add(int... numbers)`

**Q23: Return Type Not Enough**
Explain why this won't work:
```java
public int getValue() { return 10; }
public double getValue() { return 10.5; }
```
Why can't you overload based on return type alone?

**Q24: Parameter Order Matters**
Create a class with:
```java
public void method(String s, int i) { }
public void method(int i, String s) { }
```
Show how Java distinguishes these.

**Q25: Method Overloading - Objects**
Create overloaded `display()` methods for:
- `Student` object
- `Employee` object
- `Teacher` object (extends Employee)
- Which version is called for each?

### MEDIUM LEVEL

**Q26: Widening vs Overloading**
```java
void test(int x) { System.out.println("int"); }
void test(long x) { System.out.println("long"); }

test(5);  // Output?
test(5L); // Output?
```

**Q27: Constructor Overloading Complex**
Create a `Date` class with:
- `Date()` - current date
- `Date(String dateString)` - parse "DD-MM-YYYY"
- `Date(int day, int month, int year)` - individual parameters
- `Date(LocalDate date)` - from LocalDate
- Implement all with proper validation

**Q28: Overloading with Varargs**
```java
void method(int... nums) { }
void method(int x, int... nums) { }
void method(int x, int y, int... nums) { }

method(1);          // Which is called?
method(1, 2);       // Which is called?
method(1, 2, 3);    // Which is called?
```

**Q29: Auto-boxing & Overloading**
```java
void method(int x) { System.out.println("int"); }
void method(Integer x) { System.out.println("Integer"); }

method(5);      // Output?
Integer i = 5;
method(i);      // Output?
```

**Q30: Performance Impact**
Create a method that calculates factorial. Overload it for:
- Iterative approach
- Recursive approach
- Which is better? Measure with simple timing

---

## **PHASE 4: INHERITANCE (Single & Multilevel)**

### EASY LEVEL

**Q31: Basic Inheritance**
Create:
- `Animal` class with: `name`, `age`, methods: `eat()`, `sleep()`
- `Dog` class extends `Animal` with: `breed`, method: `bark()`
- Create Dog object and call all methods

**Q32: super Keyword**
Create:
- `Vehicle` class with parameterized constructor
- `Car` class extends `Vehicle`, uses `super()` in constructor
- Initialize and display both

**Q33: Method Overriding Basics**
Create:
- `Shape` class with method `calculateArea()`
- `Circle` class overrides it
- `Rectangle` class overrides it
- Show polymorphism with array of shapes

**Q34: Multilevel Inheritance**
Create:
- `Animal` → `Mammal` → `Dog`
- Each class adds one property
- Show the hierarchy working

**Q35: Is-A Relationship**
Identify is-a relationships for:
- Vehicle, Car, Truck, Motorcycle, Bicycle
- Create the hierarchy

### MEDIUM LEVEL

**Q36: Method Overriding with super**
```java
class Parent {
    public void show() { System.out.println("Parent"); }
}

class Child extends Parent {
    public void show() { 
        super.show();
        System.out.println("Child"); 
    }
}

new Child().show();  // Output?
```

**Q37: Constructor in Inheritance**
```java
class Parent {
    Parent() { System.out.println("Parent Constructor"); }
}

class Child extends Parent {
    Child() { System.out.println("Child Constructor"); }
}

new Child();  // Output? Explain order.
```

**Q38: Access Modifiers in Inheritance**
Create:
- `Parent` class with `public`, `protected`, `private` members
- `Child` class, try accessing each
- Show what's accessible and what's not

**Q39: Inheritance Chain Problem**
```java
class A { int x = 10; }
class B extends A { int x = 20; }
class C extends B { int x = 30; }

C c = new C();
System.out.println(c.x);  // Output? All three x's exist?
```

**Q40: Preventing Inheritance**
Create a final class and try to extend it. What happens? Why would you make a class final?

---

## **PHASE 5: POLYMORPHISM (Runtime)**

### EASY LEVEL

**Q41: Runtime Polymorphism Basic**
Create:
- `Employee` (base) with `salary()`
- `Manager` (extends), `Developer` (extends), `Intern` (extends)
- Each overrides `salary()` differently
- Array of employees, print all salaries

**Q42: Upcasting & Downcasting**
```java
Animal a = new Dog();  // Upcasting (automatic)
Dog d = (Dog) a;       // Downcasting (explicit)
Cat c = (Cat) a;       // Runtime error?
```
Explain each scenario.

**Q43: instanceof Check**
Create a method that takes `Animal` object and performs different actions based on actual type using `instanceof`.

**Q44: Late Binding**
```java
Parent p = new Child();
p.method();  // Which version is called - Parent's or Child's?
```
Explain late binding vs early binding.

**Q45: Polymorphism with Collections**
Create a `List<Shape>` with various shape objects, iterate and call overridden method on each.

### MEDIUM LEVEL

**Q46: Polymorphism + Abstract Methods**
Create:
- Abstract `PaymentMethod` class with abstract `pay(double amount)`
- `CreditCard`, `DebitCard`, `UPI` implement it
- Array of payment methods, process various payments

**Q47: Method Resolution Order**
```java
class A { public void test() { System.out.println("A"); } }
class B extends A { }
class C extends B { public void test() { System.out.println("C"); } }

B b = new C();
b.test();  // Output?
```

**Q48: Polymorphic Return Types**
Create:
- `Vehicle` class with method `getDetails(): Vehicle`
- `Car` extends it, overrides to return `Car` type
- Demonstrate covariant return types

**Q49: Polymorphism Problem Solving**
Create a simple shopping system:
- `Item` (abstract) with `getPrice()`
- `Electronics`, `Clothing`, `Food` items
- Calculate total price of mixed items
- Apply discounts based on item type

**Q50: Diamond Problem Simulation**
Explain why multiple inheritance isn't supported in Java, and show how interfaces solve this.

---

## **PHASE 6: ENCAPSULATION & ACCESS MODIFIERS**

### EASY LEVEL

**Q51: Getter & Setter Pattern**
Create a `BankAccount` class with:
- Private `balance`
- Public getter and setter with validation
- Prevent negative balance

**Q52: Access Modifiers**
Create a `Person` class with:
- `public name`
- `protected age`
- `private ssn`
- `default` address
- Try accessing from same class, same package, different package, child class

**Q53: Encapsulation Benefits**
Show why encapsulation is important by:
- Creating a class without encapsulation - show problems
- Rewrite with proper encapsulation - show benefits

**Q54: Validation in Setter**
Create a `Student` class:
- Private `gpa` (0-4)
- Setter validates range
- Show error handling for invalid values

**Q55: Read-Only Object**
Create a `Point` immutable class:
- Final class
- Private final fields
- Only getter, no setter
- Show it can't be modified

### MEDIUM LEVEL

**Q56: Encapsulation + Inheritance**
```java
class Parent {
    private int x = 10;
    public int getX() { return x; }
}

class Child extends Parent {
    void test() {
        System.out.println(x);  // Accessible?
        System.out.println(getX());  // Accessible?
    }
}
```

**Q57: Package Private (Default) Access**
Create two classes in same package and different package:
- Show what's accessible with default access
- Difference from private and protected

**Q58: Defensive Copying**
```java
public class Container {
    private int[] arr;
    
    public Container(int[] arr) {
        this.arr = arr;  // Problem?
    }
    
    public int[] getArr() {
        return arr;  // Problem?
    }
}
```
Show the issues and fix them.

**Q59: Immutable Class Creation**
Create a fully immutable `Color` class:
- Final class, final fields
- Private constructor
- Proper copying of mutable fields
- Demonstration

**Q60: Builder Pattern**
Create a `User` class using Builder pattern:
- Many optional properties
- Fluent API with `.build()`
- Show how it simplifies object creation

---

## **PHASE 7: ABSTRACTION**

### EASY LEVEL

**Q61: Abstract Class Basics**
Create:
- Abstract `Vehicle` class with abstract method `drive()`
- `Car` and `Bike` implement it
- Show you can't instantiate `Vehicle`

**Q62: Abstract Methods vs Concrete**
Create:
- Abstract `Bird` class
- Abstract `fly()` method
- Concrete `eat()` method
- Child classes inherit and override

**Q63: Template Method Pattern**
Create abstract `CoffeMaker`:
- Abstract method `addIngredients()`
- Concrete method `brew()` that calls abstract method

**Q64: Hiding Complexity**
Create:
- Abstract `PaymentProcessor` hiding payment API complexity
- `StripeProcessor`, `PayPalProcessor` implement it
- Simple `process()` method hides details

**Q65: Abstract + Constructor**
Can abstract class have constructor? Create one with parameterized constructor and show how child class uses `super()`.

### MEDIUM LEVEL

**Q66: Abstract Class Hierarchy**
Create:
- `Animal` (abstract) → `Mammal` (abstract) → `Dog` (concrete)
- Show which classes can be instantiated

**Q67: Partial Implementation**
Create abstract `Database`:
- Abstract `connect()`
- Concrete `query(String sql)` that uses abstract method
- `MySQLDatabase` and `MongoDatabase` implement

**Q68: Abstract + Static Members**
Can abstract class have static methods/variables? Demonstrate with example.

**Q69: Abstract Class vs Interface**
Compare when to use each with practical examples.

**Q70: Abstract Collection Template**
Create abstract `DataStructure`:
- Abstract `add()`, `remove()`
- Concrete `isEmpty()`, `display()`
- `Stack`, `Queue` implement it

---

## **PHASE 8: INTERFACES**

### EASY LEVEL

**Q71: Basic Interface**
Create:
- `Drawable` interface with `draw()` method
- `Circle`, `Rectangle`, `Triangle` implement it
- Array of Drawable objects

**Q72: Multiple Implementations**
Create `Serializable` interface and show multiple classes implementing it.

**Q73: Interface with Static Final Variables**
Create `Constants` interface with:
- `static final` constants
- Access them without creating object
- Show interface is documentation + contract

**Q74: Interface vs Class**
Show syntax differences and usage differences.

**Q75: Implementing Multiple Interfaces**
Create a class that implements 2 different interfaces:
- Both with same method name
- How is it handled?

### MEDIUM LEVEL

**Q76: Interface Default Methods (Java 8+)**
Create an interface with:
- Abstract method
- Default method with implementation
- Static method
- Show each usage

**Q77: Interface Inheritance**
```java
interface A { void methodA(); }
interface B extends A { void methodB(); }

class C implements B {
    // What must C implement?
}
```

**Q78: Multiple Interface Implementation**
Create interfaces for different features:
- `Flyer` with `fly()`
- `Swimmer` with `swim()`
- `Duck` implements both

**Q79: Functional Interface**
Create a custom functional interface with single abstract method. Use lambda expression to implement it.

**Q80: Interface Marker**
Create a `Cloneable` marker interface and show its purpose.

---

## **PHASE 9: POLYMORPHISM + ABSTRACTION + INTERFACE**

### MEDIUM LEVEL

**Q81: Shape Hierarchy Problem**
Create:
- `Shape` abstract class
- `Circle`, `Rectangle`, `Triangle` concrete classes
- Calculate total area of mixed shapes
- Show polymorphism in action

**Q82: Payment System**
Design:
- `PaymentMethod` interface
- Abstract `PaymentProcessor` class
- `OnlinePayment`, `CashPayment`, `ChequePayment` classes
- Show extensibility

**Q83: Library Management System**
Create:
- Abstract `LibraryItem` class
- `Book`, `Magazine`, `DVD` extend it
- `Borrowable` interface with `borrow()`, `return()`
- Some items implement it, some don't

**Q84: Employee Management**
Create:
- Abstract `Employee` class
- Interfaces: `Promotable`, `Taxable`
- Various employee types
- Show different combinations

**Q85: Food Delivery System**
Create:
- Abstract `User` class
- Interfaces: `Reviewer`, `PaymentCapable`
- `Customer`, `DeliveryPerson`, `Restaurant` classes
- Show flexible design

---

## **PHASE 10: PACKAGES & IMPORTS**

### EASY LEVEL

**Q86: Package Declaration**
Create classes in packages:
- `com.myapp.models.Student`
- `com.myapp.utils.Calculator`
- Import and use them

**Q87: Default Package**
Show what happens when no package is declared vs explicit package.

**Q88: Import Statement**
```java
import java.util.List;
import java.util.*;
import java.util.List.*; // Valid?
```
What's the difference?

**Q89: Package Private Access**
Create two classes in same package with default (package-private) members.

**Q90: Avoiding Name Conflicts**
```java
import java.util.Date;
import java.sql.Date;  // Conflict?
```
How to resolve?

---

## **PHASE 11: MIXED/COMPLEX SCENARIOS**

### HARD LEVEL

**Q91: Banking System**
Create:
- `Account` abstract class
- `SavingsAccount`, `CheckingAccount` extend it
- `Account` implements `Comparable`
- Sort accounts by balance
- Static variable tracks total accounts

**Q92: E-Commerce Platform**
Design:
- `Product` (with encapsulation)
- `Customer` (with static method to get total customers)
- `Order` (abstract base, `OnlineOrder`, `InStoreOrder` concrete)
- `Payment` interface with multiple implementations
- Show relationships

**Q93: Animal Sanctuary**
Create:
- `Animal` abstract class
- `Diet` interface with `eat()`
- `Habitat` interface
- Various animals implementing different combinations
- Collections management

**Q94: Java Coding Question - Complex Polymorphism**
```java
class A { public void method() { System.out.println("A"); } }
class B extends A { public void method() { System.out.println("B"); } }
class C extends B { public void method() { System.out.println("C"); } }

A a = new B();
B b = new C();
A c = new A();

a.method();  // Output?
b.method();  // Output?
c.method();  // Output?

((C)a).method();  // Runtime error?
```

**Q95: Design Pattern Recognition**
Identify patterns in these scenarios:
- Singleton Database Connection
- Factory Method for Object Creation
- Builder Pattern for Object Construction
- Strategy Pattern with Interfaces
- Template Method Pattern with Abstract Classes

**Q96: Null Handling**
```java
Animal a = null;
a.eat();  // What happens?
```
How to prevent? Show best practices.

**Q97: Object Comparison**
Create a `Person` class and override:
- `equals()` for value comparison
- `hashCode()` for hash-based collections
- Show why both are important

**Q98: Immutable + Builder Combination**
Create an immutable `Configuration` class using Builder pattern.

**Q99: Interview Question - Liskov Substitution Principle**
```java
class Bird {
    public void fly() { System.out.println("Flying"); }
}

class Penguin extends Bird {
    public void fly() { throw new UnsupportedOperationException(); }
}
```
What's the problem? How to fix? (Hint: Think about substitutability)

**Q100: Design Your Own System**
Choose one:
- **Game System**: Players, Weapons, Abilities, PowerUps
- **Social Media**: Users, Posts, Comments, Followers, Notifications
- **Hospital**: Patients, Doctors, Appointments, Departments
- **University**: Students, Professors, Courses, Grades

Requirements:
- Proper inheritance hierarchy
- Encapsulation with validation
- At least one interface
- At least one abstract class
- Demonstrate polymorphism
- Use collections
- Implement proper access modifiers

---

## **BONUS: KEY CONCEPTS SUMMARY**

### Understanding Principles

**Encapsulation**: Hide internal details, expose through public interface
**Inheritance**: Code reuse through is-a relationships
**Polymorphism**: One interface, many implementations
**Abstraction**: Simplify complexity by hiding details

### Design Principles

1. **DRY** - Don't Repeat Yourself
2. **SOLID** - Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion
3. **Composition over Inheritance** - Prefer has-a over is-a when possible
4. **Program to Interface, not Implementation**

---

## **HOW TO USE THIS QUESTION BANK**

### Week 1-2: Fundamentals (Q1-Q20)
- Understand classes, objects, constructors
- Practice object creation and initialization
- Get comfortable with basic syntax

### Week 2-3: Core Features (Q21-Q40)
- Master method overloading
- Understand inheritance hierarchy
- Learn access modifiers

### Week 3-4: Advanced OOP (Q41-Q70)
- Polymorphism practice
- Abstract classes
- Encapsulation patterns

### Week 4-5: Interfaces & Design (Q71-Q85)
- Multiple interfaces
- Design patterns introduction
- Real-world scenarios

### Week 5-6: Integration & Practice (Q86-Q100)
- Mixed scenarios
- Complete systems
- Interview-level questions

---

## **TIPS FOR SUCCESS**

✅ **Don't just read** - Code every single question
✅ **Understand why** - Learn the reason behind each concept
✅ **Make mistakes** - Compile and run to see errors
✅ **Visualize** - Draw class hierarchies and relationships
✅ **Compare approaches** - See different ways to solve same problem
✅ **Think like interviewer** - Why this concept? When to use?
✅ **Build projects** - Combine concepts into mini projects
✅ **Refactor code** - Improve your earlier solutions

---

## **COMMON PITFALLS TO AVOID**

❌ Overusing inheritance (not everything is-a relationship)
❌ Mixing abstract classes and interfaces unnecessarily
❌ Not understanding static vs instance context
❌ Poor encapsulation (public fields)
❌ Not utilizing polymorphism benefits
❌ Ignoring access modifiers
❌ Creating God classes (doing too much)

---

**Happy coding! Solve these systematically and you'll be an OOP master ready for any interview.** 🚀
