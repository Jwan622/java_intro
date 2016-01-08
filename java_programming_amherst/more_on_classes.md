### More on Classes

A class can contain variables that have declarations using the keyword static. These **class variables** are similar to instance variables, but there is only one copy of the variable for the whole class.

The most common use of class variables is in classes that contain only static methods, for example in a class containing a main method. Suppose you were building a one-class program with a variable size that is needed in all of the meth- ods. You could do the declaration in the following way,
```
  private static int size;
```
placing the declaration inside the class but outside of any method. The variable could then be accessed in any method in the class, without the need to pass it as a parameter.

**The above is pretty much just like Ruby**

__This explanation is great:__

> It is regarded as bad style to use class variables in this way, because the flow of information between methods is obscured. If a class variable is inadvertently changed in one method, other methods will be a↵ected. This is, of course, true when variables are passed as parameters or returned from methods, but the explicit use of parameters and return values makes dependencies more obvious.


__Useful application of class variables__:

Sometimes it is useful to use class variables in other ways. For example, recall the class Student that appeared in Figure 15.3. Suppose we wanted to keep track of how many Student objects had ever been created. We could declare a counter variable in the following way:
```
  private static int studentCount = 0;
```

The constructor could then be the following:
```
public Student (String name, int year, int box) {
  this.name = name;
  this.year = year;
  this.box = box;
  studentCount++;
}
```
Each time that a Student object is created, the counter is incremented.

To permit other classes to retrieve the counter, which is in a private variable,
we could add a class method to Student:
```
  public static int getCount() {
    return studentCount;   // this is a class variable
}
```
A class method uses the keyword static and is associated with the class as a whole rather than with a particular object. Method getCount could then be called from another class by writing:
```
  Student.getCount()
```

**Class methods are never permitted to call instance methods or to access instance variables, because class methods are not associated with an underlying object. On the other hand, instance methods and constructors can freely call class methods or access class variables. We saw an example of this above, when the constructor for Student accessed variable studentCount.**


#### Final variables or constants

It is sometimes useful to have names that are associated with constant values. Here’s an example:
```
private static final int MAXIMUM_SIZE = 100;
```
  Here’s another example, which appears in the built-in class Math:
```
  public static final double PI = 3.141592653589793;
```
The keyword **final** forces the name to be permanently associated with the value instead of with a genuine variable.

The significance of the declaration of PI is that we can write Math.PI whenever we want the value of ⇡.

By convention, constants use names containing upper-case characters. Under- score characters are used to separate words if the constant name is based on a phrase, for example in MAXIMUM_SIZE.


#### Constructors

Classes are permitted to have multiple constructors, as long as each constructor has a distinct list of parameter types. Recall that class StudentList (Figure 15.4) had a constructor that took an int parameter that specified a maximum number of students that could be part of the list:

```java
public StudentList(int size) {
  list = new Student[size];
  capacity = size;
  count = 0;
}
```

We could add a second constructor that takes no parameters:
```java
public StudentList() {
  list = new Student[MAXIMUM_SIZE];
  capacity = MAXIMUM_SIZE;
  count = 0;
}
```
This would permit us to create a StudentList by writing either new StudentList(100) (which is the first one) or new StudentList() (the second constructor).

If a class has no constructors, there is always a default no-argument constructor that does nothing.
So if class A had no constructor, it would be fine to write new A(). On the other hand, the presence of any constructor eliminates our ability to use the default constructor.


#### Garbage collection for objects

Once created, an object will remain in the computer’s memory for as long as it is needed. They are handled in the same way as arrays (see section 13.5), and in reality an array is just a special kind of object. If an object is no longer accessible via variables and other objects, its memory becomes available for reuse via garbage collection.
Here’s an example illustrating a case which which an object becomes garbage:
```java
  Student s = new Student ("Jim", 2011, 923);
  Student t = new Student ("Anne", 2012, 1011);
  t = s;
```
After the reference in s is copied into t, the object for Jim is unreachable and becomes garbage.


**Here’s a better way to write the no-argument constructor for StudentList:**
```java
public StudentList() {
  this(MAXIMUM_SIZE);
}
```
The call to this means “call another constructor for this same kind of object.” This type of call can only be made in a constructor, and it must appear as the very first statement. It’s possible to put other code in the constructor after the call to this. (Please note, this use of this is totally unrelated to the use of this as a variable that refers to the current object.)

**Fascinating tidbit on private constructors:**
The class Math provides an interesting illustration of the e↵ect of the public and private keywords on constructors. Math exists only to hold static methods, such as cos and sqrt, and static variables, such as PI. No one is ever supposed to create a Math object. To prevent this possibility, Math contains a single, private, no-argument constructor that does nothing. This means that a call to new Math() will be interpreted as a call to a private constructor and will cause a compilation error.


#### Testing objects for equality

Suppose you have created a class MyClass and wish to test whether two MyClass objects are equivalent. It is usually not correct to write
```java
if (a == b) ...
```
The problem with this code is that it asks “Are pointers a and b equal?” In other words, it asks whether a and b refer to the same object. It’s possible that the pointers refer to distinct but equivalent objects, in which case the comparison will yield the wrong answer.

Java classes often provide an equals method that compares objects rather than pointers. This is what permits us to compare two String objects by writing some- thing like
```java
  if (s.equals(t)) ...
```

As mentioned earlier, it is vital use this way of comparing strings rather than ==.


#### More on private instance variables:

Instance variables are made private to **force the users of those class to use methods to access them.** In most cases there are plain getters and setters but other methods might be used as well.

Using methods would allow you, for instance, to restrict access to read only, i.e. a field might be read but not written, if there's no setter. That would not be possible if the field was public.

Additionally, you might add some checks or conversions for the field access, which would not be possible with plain access to a public field. If a field was public and you'd later like to force all access through some method that performs additional checks etc. You'd have to change all usages of that field. If you make it private, you'd just have to change the access methods later on.

If phone was private:

Consider this case:
```java
class Address {
  private String phone;

  public void setPhone(String phone) {
    this.phone = phone;
  }
}

//access:
Address a = new Address();
a.setPhone("001-555-12345");
```
If we started with the class like this and later it would be required to perform checks on the phoneNumber (e.g. some minimum length, digits only etc.) you'd just have to change the setter:
```java
class Address {
  private String phone;

  public void setPhone(String phone) {
    if( !isValid( phone) ) { //the checks are performed in the isValid(...) method
     throw new IllegalArgumentException("please set a valid phone number");
    }

    this.phone = phone;
  }
}

//access:
Address a = new Address();
a.setPhone("001-555-12345"); //access is the same
```
If phone was public:

Someone could set phone like this and you could not do anything about it:
```
Address a = new Address();
a.phone="001-555-12345";
```
If you now want to force the validation checks to be performed you'd have to make it private and whoever wrote the above lines would have to change the second line to this:
```
a.setPhone("001-555-12345");
```

Thus you couldn't just add the checks without breaking other code (it wouldn't compile anymore).
