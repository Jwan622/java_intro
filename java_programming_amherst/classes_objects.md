## Writing classes to define Objects

Programmers can use classes to define their own objects. You’ve actually already done this, because an enumerated type is a simple class that defines a simple kind of value.

```java
public class BankTest {
  public static void main (String[] args) {
    BankAccount his = new BankAccount ("Joe Smith", 23.00);
    BankAccount hers = new BankAccount ("Jane Doe", 94.00);
    his.makeDeposit (12.00);
    hers.deductFunds (20.00);
    System.out.println (his);
    System.out.println (hers);
    double balance = hers.getBalance();
    System.out.printf ("Jane’s balance is $%.2f\n", balance);
    if (hers.deductFunds(80.00))
        System.out.println ("Funds are available");
    else
        System.out.println ("Funds are not available");
    System.out.println (hers);
  }
}
```

Look at this class of code. Inside the class, and in BankAccount, there are two instance variables defined: owner and balance. These are variables that are outside of any particular method and that are associated with the object itself.

Some important facts about instance variables:
- The values in the instance variables characterize the object.
- Instance variables are never labelled as static.

```java
import java.io.PrintWriter;
import java.io.StringWriter;
public class BankAccount {
    /////////////// instance variables //////////////////////////////////////
  private String owner;
  private double balance;
  /////////////// constructor /////////////////////////////////////////////
  public BankAccount (String o, double b) {  // constructor method
    owner = o;
    balance = b;
  }
  /////////////// public methods /////////////////////////////////////////
  public void makeDeposit (double amount) {   // this is an instance method that can be called on an object.
      balance += amount;
  }
  public boolean deductFunds (double amount) {
      if (checkAvailability(amount)) {
          balance -= amount;
          return true;
      }
      else return false;
  }
  public double getBalance() {
      return balance;
  }
  public String getOwner() {
      return owner;
  }
  public String toString () {
      StringWriter s = new StringWriter();
      PrintWriter p = new PrintWriter (s);
      p.printf ("Owner: %s, Balance = $%.2f", owner, balance);
      p.close();
      return s.toString();
}
  /////////////// private method /////////////////////////////////////////
  private boolean checkAvailability (double amount) {
      if (balance >= amount)
          return true;
      else
          return false;
  }
}
```

In this case, the instance variables are labeled private, meaning that they can not be accessed from outside
class BankAccount.

#### Constructors

When an object is created by using the new operator, memory is allocated for the object. Part of this memory is used to hold the object’s instance variables. After the memory is allocated, a constructor is run for the object. (Some classes have multiple constructors; we won’t worry about that for now.) **A constructor is simply a special method that is run when the object is created.**

Look at the constructor method in the code above. The header has several interesting features:
1. The name of the constructor matches the name of the class.
2. There is no keyword static.
3. There is no return type.

Constructors are often very simple. In this case, the constructor simply copies values from its parameters into the instance variables.


Now recall the lines from the main method that we used to create the two bank accounts:
```java
  BankAccount his = new BankAccount ("Joe Smith", 23.00);
  BankAccount hers = new BankAccount ("Jane Doe", 94.00);
```
The values given within the parentheses on each line are assigned to the parameters of the constructor, which in turn copies them into the appropriate instance variables.

In this way we create two correctly defined BankAccount objects. The variables his and hers are references to the objects, in the same way that array variables were really references to the actual arrays.

#### Public Instance Methods

The BankAccount class contains several methods that are public and that are not static. The keyword public is the opposite of private; it means that these can be called from methods in other classes. As discussed in section 5.2, the absence of the keyword static means that they are methods that must be applied to objects. When we wrote

```
  his.makeDeposit (12.00);
```

in the main method, we requested that the method makeDeposit be applied to the object referenced by variable his. Because his is a BankAccount, the system will look for a method called makeDeposit in class BankAccount. It will execute the method using the instance variables of the particular object referred to by his. This is just like Ruby. In the makeDeposit method, it will use the object's balance instance variable.

#### Private Instance Methods

- Class BankAccount also contains a method called checkAvailability that is labelled private. A private method can only be called from elsewhere within the same class.
- Methods should be labelled private if there is no good reason to permit methods in other classes to use them. By making them private, you can protect the object from incorrect manipulation by methods outside the class.

#### Public Instance Variables
- Although it doesn’t happen in the bank account class, instance variables can also be labelled public. If an instance variable is public, it can be manipulated in other classes. For example, if variable balance were public, you could use or modify his.balance within class BankTest. By making it private, we reduce the possibility that the balance can be modified by mistake. The main method can still use his.getBalance(), a public method, to retrieve the balance, but it can’t use the variable directly.


#### Class Student

```java
public class Student {
  private String name;
  private int year;
  private int box;

  public Student (String name, int year, int box) {
    this.name = name;
    this.year = year;
    this.box = box;
  }

  public String getName () {
    return name;
  }

  public int getYear() {
    return year;
  }

  public int getBox() {
    return box;
  }

  public boolean precedes (Student s) {
    if (name.compareTo(s.name) < 0) return true;
    else return false;
  }

  public String toString() {
    return name + " " + year + " " + box;
  }
}

```
Notice some things about the above class:
- Note the presence of a toString method that produces a string describing the object.
- There are private fields for the data itself, and public methods for accessing it.
- The precedes determines whether or not one student has a name that precedes another in alphabetic order. Here’s how it might be used:
```
Student s = new Student ("Bill", 2002, 438);
Student t = new Student ("Jane", 2004, 610);
if (t.precedes(s)) ...
```
After creating the two Student objects, this code runs the precedes method on t. This means that when we refer to name within the method, we mean the name associated with t. The method compares t’s name with that of s by applying the compareTo method from class String. The latter method yields a negative value if t’s name comes first alphabetically, zero if the names are the same, and a positive value if t’s name comes later alphabetically. Putting this together, we see that the precedes method returns true if t’s name comes before that of s.



#### Keyword "this"

- Within an instance method, you can use the keyword this in order to access the “current object.”

For example, if you execute the following statement,
```java
  if (u.precedes(t)) ...
```
then you can use this within precedes to access the object to which u points.

Similarly, you can use this within a constructor to reference the object that is being constructed.

The constructor of Student shows a case in which it’s vital to use this. There is an instance variable called year which is prefaced with the word this (which refers to the object), and there’s a parameter with the same name. Java permits this situation, which is arguably dangerous. In any event, it’s possible to copy the parameter into the instance variable by writing
```
  this.year = year;
```
The right-hand side refers to the parameter, and the left-hand side refers to the instance variable. Programming languages typically give priority to more local definitions, which is what causes year to be associated with the parameter.


#### Conditional Boolean operators

Method addStudent also illustrates a feature of the && operator, which is a “con- ditional and.” Here is the for statement used above:
```
  for (i=count-2; i>=0 && s.precedes(list[i]); --i)
```
As we discussed earlier, the && operator will yield true if the operands on both sides of the operator are true. Suppose that the left operand is false. The overall result will surely be false, and the computer does not bother to evaluate the expression on the right. This behavior is often desirable. In the example above, the precedes test occurs only if i >= 0. That’s good news, because if i is less than zero, the use of list[i] will cause an exception. The conditional behavior of the && operator often helps avoid exceptions and meaningless tests. Obviously we need to be careful in ordering the operands of an && operator. This statement is probably undesirable:
```java
  if (s.precedes(list[i]) && i>=0) ...      // bad example
```
Note that an exception will occur if i is ever negative.


Here’s another example of
the correct use of &&:
```
if (s != null && s.precedes(t)) ...
```
The “conditional and” prevents us from applying the precedes method to a null pointer, which is erroneous and would lead to an exception.


#### Summary and takeaways

You should write a class to define a new kind of object when you have an entity or idea that has data and operations associated with it. Some objects do little more than hold data (for example, BankAccount and Student objects), while others (such as StudentList and Grid objects) are more complex. Constructors must ensure that the object is initially given some sensible state. For simple objects this sometimes means filling the instance variables with values copied from parameters, while for others there may be significantly more work.
