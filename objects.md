## Initializing an Object

Here's the code for the Point class:

```java
public class Point {
    public int x = 0;
    public int y = 0;
    //constructor
    public Point(int a, int b) {
        x = a;
        y = b;
    }
}
```

This class contains a single constructor. You can recognize a constructor because its declaration uses the same name as the class and it has no return type. The constructor in the Point class takes two integer arguments, as declared by the code (int a, int b). The following statement provides 23 and 94 as values for those arguments:

```java
Point originOne = new Point(23, 94);
```


#### Constructors

Here's the code for the Rectangle class, which contains four constructors:

```java
public class Rectangle {
    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public Rectangle() {
        origin = new Point(0, 0);
    }
    public Rectangle(Point p) {
        origin = p;
    }
    public Rectangle(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
    }
    public Rectangle(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing the area of the rectangle
    public int getArea() {
        return width * height;
    }
}
```

Each constructor lets you provide initial values for the rectangle's origin, width, and height, using both primitive and reference types. If a class has multiple constructors, they must have different signatures. The Java compiler differentiates the constructors based on the number and the type of the arguments. When the Java compiler encounters the following code, it knows to call the constructor in the Rectangle class that requires a Point argument followed by two integer arguments:

```java
Rectangle rectOne = new Rectangle(originOne, 100, 200);
```

This calls one of Rectangle's constructors that initializes origin to originOne. Also, the constructor sets width to 100 and height to 200. Now there are two references to the same Point object—an object can have multiple references to it. One of the originOne is inside the Rectangle and one is apart. We have originOne code here twice in this file.

The Rectangle constructor used in the following statement doesn't take any arguments, so it's called a no-argument constructor:

```java
Rectangle rect = new Rectangle();
```

All classes have at least one constructor. If a class does not explicitly declare any, the Java compiler automatically provides a no-argument constructor, called the default constructor. This default constructor calls the class parent's no-argument constructor, or the Object constructor if the class has no other parent. If the parent has no constructor (Object does have one), the compiler will reject the program.


## Using Objects

First some sample code which will become clear later as we go over the code for Rectangle:

```java
public class CreateObjectDemo {
  public static void main(String[] args) {
    // Declare and create a point object and two rectangle objects.
    Point originOne = new Point(23, 94);
    Rectangle rectOne = new Rectangle(originOne, 100, 200);
    Rectangle rectTwo = new Rectangle(50, 100);

    // display rectOne's width, height, and area
    System.out.println("Width of rectOne: " + rectOne.width);
    System.out.println("Height of rectOne: " + rectOne.height);
    System.out.println("Area of rectOne: " + rectOne.getArea());

    // set rectTwo's position
    rectTwo.origin = originOne;

    // display rectTwo's position
    System.out.println("X Position of rectTwo: " + rectTwo.origin.x);
    System.out.println("Y Position of rectTwo: " + rectTwo.origin.y);

    // move rectTwo and display its new position
    rectTwo.move(40, 72);
    System.out.println("X Position of rectTwo: " + rectTwo.origin.x);
    System.out.println("Y Position of rectTwo: " + rectTwo.origin.y);
  }
}
```

This program creates, manipulates, and displays information about various objects. Here's the output:

```
Width of rectOne: 100
Height of rectOne: 200
Area of rectOne: 20000
X Position of rectTwo: 23
Y Position of rectTwo: 94
X Position of rectTwo: 40
Y Position of rectTwo: 72
```

Once you've created an object, you probably want to use it for something. You may need to use the value of one of its fields, change one of its fields, or call one of its methods to perform an action.


#### Referencing an Object's Fields

Object fields are accessed by their name. You must use a name that is unambiguous.

You may use a simple name for a field within its own class. For example, we can add a statement within the Rectangle class that prints the width and height:

```java
System.out.println("Width and height are: " + width + ", " + height);
```

In this case, width and height are simple names.

Code that is outside the object's class must use an object reference or expression, followed by the dot (.) operator, followed by a simple field name, as in:

```java
objectReference.fieldName
```

For example, the code in the CreateObjectDemo class is outside the code for the Rectangle class. So to refer to the origin, width, and height fields within the Rectangle object named rectOne, the CreateObjectDemo class must use the names rectOne.origin, rectOne.width, and rectOne.height, respectively. The program uses two of these names to display the width and the height of rectOne:

```java
System.out.println("Width of rectOne: "  + rectOne.width);
System.out.println("Height of rectOne: " + rectOne.height);
```
Attempting to use the simple names width and height from the code in the CreateObjectDemo class doesn't make sense — those fields exist only within an object — and results in a compiler error.

Later, the program uses similar code to display information about rectTwo. Objects of the same type have their own copy of the same instance fields. Thus, each Rectangle object has fields named origin, width, and height. When you access an instance field through an object reference, you reference that particular object's field. The two objects rectOne and rectTwo in the CreateObjectDemo program have different origin, width, and height fields.

To access a field, you can use a named reference to an object, as in the previous examples, or you can use any expression that returns an object reference. Recall that the new operator returns a reference to an object. So you could use the value returned from new to access a new object's fields:

```java
int height = new Rectangle().height;
```

This statement creates a new Rectangle object and immediately gets its height. In essence, the statement calculates the default height of a Rectangle. Note that after this statement has been executed, the program no longer has a reference to the created Rectangle, because the program never stored the reference anywhere. The object is unreferenced, and its resources are free to be recycled by the Java Virtual Machine.
