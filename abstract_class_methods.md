In Object oriented programming Abstraction is a process process of hiding the
implementation details from the user, only the functionality will be provided to
the user. In other words user will have the information on what the object does
instead of how it does it.

In Java Abstraction is achieved using Abstract classes, and Interfaces.



```java
// sample abstract class

public abstract class AbstractClass {
  private String name;
  private String address;
  private int number;

  public Employee(String name, String address, int number) {
    System.out.println("Constructing an Employee");
    this.name = name;
    this.address = address;
    this.number = number;
  }

  public double computePay() {
    System.out.println("Inside Employee computePay");
    return 0.0;
  }

  public void mailCheck() {
    System.out.println("Mailing a check to " + this.name
       + " " + this.address);
  }

  public String toString()
  {
    return name + " " + address + " " + number;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String newAddress)
  {
    address = newAddress;
  }

  public int getNumber()
  {
   return number;
  }
}
```
You can observe that except abstract methods the Employee class is same as normal class in Java. The class is now abstract, but it still has three fields, seven methods, and one constructor.

Now you can try to instantiate the Employee class as shown below:

```java
/* File name : AbstractDemo.java */
public class AbstractDemo
{
  public static void main(String [] args)
  {
    /* Following is not allowed and would raise error */
    Employee e = new Employee("George W.", "Houston, TX", 43);

    System.out.println("\n Call mailCheck using Employee reference--");
    e.mailCheck();
  }
}
```

This is the error you'll get:

```
Employee.java:46: Employee is abstract; cannot be instantiated
      Employee e = new Employee("George W.", "Houston, TX", 43);
                   ^
1 error
```



#### Abstract Methods

**Abstract Methods:**
If you want a class to contain a particular method but you want the actual implementation of that method to be determined by child classes, you can declare the method in the parent class as abstract.

abstract keyword is used to declare the method as abstract.

You have to place the abstract keyword before the method name in the method declaration.

An abstract method contains a method signature, but no method body.

Instead of curly braces an abstract method will have a semoi colon ( ; ) at the end.

Below given is an example of the abstract method.

```java
public abstract class Employee
{
   private String name;
   private String address;
   private int number;

   public abstract double computePay();

   //Remainder of class definition
}
```

Declaring a method as abstract has two consequences:  
1. The class containing it must be declared as abstract.
2. Any class inheriting the current class must either override the abstract method or declare itself as abstract.

**Note:** Eventually, a descendant class has to implement the abstract method; otherwise, you would have a hierarchy of abstract classes that cannot be instantiated.

Suppose Salary class is inherits the Employee class, then it should implement the computePay() method as shown below:

```java
/* File name : Salary.java */
public class Salary extends Employee
{
   private double salary; // Annual salary

   public double computePay()
   {
      System.out.println("Computing salary pay for " + getName());
      return salary/52;
   }

   //Remainder of class definition
}
```
