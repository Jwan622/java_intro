## Arrays in Java

An array is a set of variables that is created at one time and that can be referenced using a common name. Here’s an example:

```java
int[] a = new int[100];
```

This declares a variable called a. Its type, int[], means “array of ints”.
**The expression new int[100] allocates enough memory to hold 100 ints.**
**If variable a is declared and initialized in this way, we say that “a refers to an array of 100 ints.”**

The above is new and a departure from Ruby.


It is possible to “index into an array” to access individual elements. Here are some examples:
```
int j = a[50];
int k = 3;
j = a[k];
int m = a[3*a[2]];
a[k] = a[k-1];
```

a[50] refers to the 50th integer in the array. a[k] uses use whatever value is in variable k as the index into array a. In this case k is 3, so a[k] refers to the third integer in the array. Any integer expression can serve as the index. For example, in the third line the value in a[2] is multiplied by three, and that value is used to pick an element out of the array.

If an array has n elements, the indices of the element will be from 0 to n   1. The first element of the array always has index 0. An attempt to use a nega- tive index or an index greater than or equal to the array length will cause an ArrayIndexOutOfBoundsException.

#### Examples of Arrays

Here’s a code fragment that generates the first 100 Fibonacci numbers and stores them in an array

```java
int[] fib = new int[100];
fib[0] = 1;
fib[1] = 1;
for (int i=2; i<100; ++i)
  fib[i] = fib[i-1] + fib[i-2];
```


This code will find the largest value in an array of ints:

```java
int[] a = new int[...];     // some length is used
// Values are then somehow assigned to elements of the array so the array is filled with ints
...
// Now, we look for the maximum value in the array
int big = a[0];  // big will rep the largest value in the array
for (int i=1; i<a.length; ++i)
  if (a[i] > big)
    big = a[i];
```

Here’s an example of an array with strings:
```
String s = "hello";
char[] a = s.toCharArray();
printBackward(a);
```

The method toCharArray in class String takes the given String and returns an array of chars containing all of its characters.

Some methods that deal with arrays:

```java
public static void printBackward(char[] a) {
  for (int i=a.length-1; i>=0; --i)
     System.out.print (a[i]);
  System.out.println();
}
```

Notice the backwards iteration through the array in this method.


Here's another method that deals with arrays:

```java
public static char[] reverseArray (char[] a) {
  char[] b = new char[a.length];
  for (int i=0; i<a.length; ++i)
    b[i] = a[a.length-1-i];
  return b; }
```

Method reverseArray takes an array of characters and returns a new array that contains the original sequence of characters reversed. Notice how it starts by initializing a new array called b then iterates through the parameter array from the back. It starts from the back of the parameter array and takes each element and puts it into the newly initialized array.


#### Palindrome method using arrays
