## Inheritance

Java permits programmers to design new classes that are derived from existing classes. Each new subclass can inherit methods and variables from its superclass. Inheritance makes it possible to reuse existing code easily and is one of the most powerful aspects of Java and other object-oriented languages.

Let’s begin with an example. Consider the following class:
```java
  public class Shape {
    public int sides;
    public String toString() {
        return "This is a shape";
  }
    public int getSides() {
        return sides;
  }
}
```

In some method, perhaps the main method, you could write:
```java
  Shape s = new Shape();
  System.out.println (s);
  System.out.println (s.getSides());
```
The println statements would work in the expected way, producing:

```
This is a shape
0
```

**Recall that all numeric instance variables have a default value of zero.**

Now consider a class that “extends” the idea of a shape:
```java
public class Triangle extends Shape {
  public Triangle() {
    sides = 3;
  }
  public String toString() {
    return "This is a triangle";
  }
  public String hi() {
    return "Hello!";
  }
}
```

Here are some statements that might appear in the main method:
```java
Triangle t = new Triangle();
  System.out.println (t.getSides());
  System.out.println (t);
  System.out.println (t.hi());
```

These statements lead to the following output:

```
  3
  This is a triangle
  Hello!
```

Triangle has no method getSides(), so it inherits the method from Shape. It does have a toString() method, which overrides the one in Shape. It also has a method hi(), so the reference to t.hi() works.

When we say Triangle extends Shape, we are declaring Triangle to be a subclass of Shape. A Triangle object inherits all the methods and variables in class Shape, and it overrides one of the methods.

The reference to variable sides in the Triangle constructor works because sides is a variable and was declared but not initialized in Shape.


Now consider these statements:
```java
Triange t = new Triangle();
Shape s = t;
System.out.println (s.getSides());
System.out.println (s);
System.out.println (s.hi());
```

The third line of code
```
println(s)
```

actually prints "This is a triangle". This may seem surprising. Variable s refers to an object that is really a Triangle. It was created as a Triangle, and it maintains that identity even though we are now holding the reference in a Shape reference variable.

So here’s the rule: **when you apply a method to an object, the method that is used is chosen based on what the object really is.** In this case the object is really a Triangle, so the toString() method used is the one from Triangle.



#### Polymorphism

The ability to execute di↵erent methods based on an object’s “real type” is called polymorphism and is valuable in many settings. Here’s an example. The Java graph- ics library defines a generic graphical object called a JComponent. There are many subclasses of JComponent, such as JButton, JScrollBar, and JTextField, each of which corresponds to a kind of graphical object that someone might want to use. Each of these classes, including JComponent has a method called paintComponent() for displaying itself in a graphics window.
In addition to classes describing individual graphical components, there’s an- other class called JPanel that contains variables describing the location, dimensions, visibility, etc. of a window. It also contains an array of JComponent references that point to the various things that appear in the window. Now consider the code that is needed to display a window. After creating the frame of the window, it needs to display the components in the window. It can achieve this by simply invoking the paintComponent() method on each JComponent in the array. Each JComponent will be displayed based on what it really is (e.g. a JScrollBar or a JButton). Inher- itance makes it easy to define the di↵erent kinds of components and polymorphism makes it very easy to write code to redraw a collection of components **without worrying about what they actually are.**



### The class object

- A single class may have many subclasses. This was certainly the case with JComponent, and it occurs frequently in the Java API. Each class may extend only one other class, i.e. it can have only **one** superclass.

- A subclass can itself have subclasses. For example, B might extend A and C might extend B. This would mean that C would indirectly extend A. Class C would have access to each method and variable declared in class A, unless B contained a declaration overriding the one in A.

- If a class is not labelled as extending another one, it is implicitly a subclass of Object, a class defined in the Java API. Object is the ultimate superclass, in the sense that every class is a subclass of it, either directly or indirectly.

- Class Object contains a collection of methods, some of which we will see in the pages ahead. The presence of these methods as part of Object means that they can be applied to any objects at all. It is often desirable to override these methods in the classes we write.
One method in Object is toString(). When called on an object of type MyClass, it produces a string of this form:
```
  MyClass@47b480
```    
This string gives the name of the class and the address (in hexadecimal notation) of the object. Not too interesting, right? The version of toString() in Object is e↵ectively the default that’s used when no other version is available. If MyClass had contained its own version of toString(), then any object of type MyClass would be printed with the new version. The new version would be also be used by subclasses of MyClass if they didn’t have their own versions.


#### Casts to subclasses

It is possible to test if an object has a particular type and to cast reference variables from one type to another.
Suppose we have an Object reference variable called o. We can test if it refers to a String object by writing
```
if (o instanceof String) ...
```
The keyword instanceof is a binary operator that yields true if o is a String. Remember if o is an Object and since Object is the ultimate superclass (every class is a subclass of it), o may not be a String.

If o refers to a String, you can write

```
String s = (String)o;
```

The cast will succeed as long as o really is of type String; if not, a ClassCastException will occur. Doing the cast makes it possible, for instance, to write s.length(). We can’t write o.length(), because length() is not a method in class Object.

#### Exceptions

In Java, exceptions are represented by objects.

We’ve seen many kinds of exceptions, such as ArrayIndexOutOfBoundsException, NullPointerException, and so on, each of which is a distinct class in the Java API. We can write new class descriptions to define new kinds of exceptions. **We can write our own exceptions**

Here’s a simple example:

```java
public class StackEmptyException extends RuntimeException {
  public StackEmptyException() {
      super("Stack is empty.");
  }
}
```

You can throw this kind of exception by writing
```java
  throw new StackEmptyException();
```
The call to super() in the constructor of StackEmptyException invokes a constructor in the superclass, which is RuntimeException, which in this case records a message describing the exception.

There is an important general rule: **all constructors in a subclass must, directly or indirectly, invoke a constructor in the superclass.**


Because exception objects are full-fledged objects, it is possible at add instance variables and methods to them. You could, for example, use
```java
    throw new MyException(3,4,5);
```
to throw a new exception object that stores various values that provide information about what went wrong. If you catch the exception with
```java
catch(MyException e) { ... }
```
then you can use variable e to access the information that’s embedded in the exception object.

Remember, there are try-catch blocks and the method that gets "try"ed is responsible for throwing the exception.

#### Abstract classes

An abstract class is a class in which one or more methods are not implemented.

Instead of writing
```java
    public int f() { ... }
```
where the code in the ellipsis does something or other, we might write

```java
public abstract int f();
```
The above is an example of an abstract method in an abstract class.
If some method is abstract, the class itself must be labelled as abstract, for example with
```
public abstract class MyClass {}
```
If MyClass is abstract, it is illegal to write:
```java
  MyClass c = new MyClass();
```




Abstract methods are useful in many applications. A typical example concerns the graphical components mentioned on page 161. JComponent is an abstract class, because it doesn’t make sense to have a paintComponent() method for a general graphical component. What would it do? On the other hand, we need to force subclasses of JComponent to provide the method.
