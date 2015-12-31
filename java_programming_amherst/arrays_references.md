In this chapter we consider precisely how arrays are handled in Java. Suppose you declare
```
int[] a = new int[100];
```

This statement does several things:
1. It creates a variable of type int[], which means “array of int”. **The variable won’t contain the actual array, but rather it will contain a reference (also called a pointer) to the array itself.** Think of a reference as a numeric address telling where the array is located in the computer’s memory.
2. It allocates space to hold 100 integers.
3. It sets the variable so that it refers to the allocated memory.
Now suppose you execute a statement such as
a[3] = 27;
The computer will check variable a to obtain the address of the array. It will then go to the array itself, find position 3, and store the value 27 in that position.


Now suppose you use the following statements:
```
  int[] b;
  b = a;
  System.out.println(b[3]);
```

These statements cause the number 27 to be printed! This happens because the address found in variable a is copied to variable b. That causes a and b to point to the very same array. Printing b[3] therefore prints the value that we just stored in a[3].

The statement
```
if (a == b)
```
compares the values in variables a and b. Because these variables contain references, the e↵ect is simply to ask “Do a and b refer to the same array?” Notice that this is di↵erent than asking if a and b refer to arrays containing the same set of values.


#### Passing Array References as Paramters

Recall that when you call a method, the parameter variables are initialized with copies of the value given when the method is called. This “call-by-value” system means that changes made within the method to parameter variables don’t affect the variables of the calling method.


Here an example of a method that doesn’t work the way you might suppose:
```java
private static void swap (int i, int j) {
    int t = i;
i = j;
j = t; }
// a useless method
```
This method swaps the contents of variables i and j, but unfortunately it’s useless. Suppose you write:

```
swap (m, n);
```

The swap method runs with variable m copied into i and variable n copied into j. Because i and j are copies, m and n are una↵ected when they are swapped.

But this actually does some swapping:
```
public static void swapElements (int[] a, int i, int j) {  // j is the index of the element that GETS inserted into  
  int t = a[i];                                            // index i
  a[i] = a[j];
  a[j] = t;
}
```

If you call

```
  swapElements(myArray, x, y);
```
I think the reason why this actually swaps is that the "value" of the array variable is a reference, and that reference does affect the actual array.

the elements in positions x and y of myArray will be swapped. Let’s see what happens. Parameter a receives a copy of the variable myArray. Variable myArray is a reference to an array, so a ends up referring to the same array. (Recall that this means that a gets the address of the array itself.) By swapping elements in the array referenced by a, the method effectively swaps elements in the array referenced by myArray.

Lets use that swapElements code here:

The following method reverses the contents of an array:
```java
    private static void reverse (int[] a) {
        // This methods reverses the elements of array a,
        // so the first element becomes the last, and so forth.
        int i=0;
        int j=a.length - 1;
        while (i < j) {
            swapElements (a, i, j);
            i++;
            j--;
  }
}
```
If you call reverse(b), the elements of b will be reversed.

This method returns a new array that is a copy of the original one.
```java
  private static char[] copy (char[] a) {
    // This method creates a copy of array a
    char[] b = new char[a.length];
    for (int i=0; i<a.length; ++i)
      b[i] = a[i];
  return b;
}
```

You can write

```
char[] c = copy(a);
```

assuming that a is an existing array of characters.

This method sums the values in an array:
```java
  private static double addPos (double[] d) {
    // This method adds up the values in an array.
    double sum = 0.0;
    for (int i=0; i<d.length; ++i)
      sum += d[i];
  return sum;
}
```

This method looks through an array, examining values in positions lo through length-1, and returns the position of the smallest element:
```java
private static int findMinPos (int[] a, int lo) {
  // This method looks in the elements of a in positions
  // greater than or equal to "lo" and returns the index
  // of some element of minimum value.
  int pos = lo;
    for (int i=lo+1; i<a.length; ++i)
      if (a[i] < a[pos]) pos = i;
  return pos;
}
```

The above method returns the array index of the lowest value in the range of lo to the end of the array.


Here’s a simple approach to sorting, called “selection sort.” Here is the explanation of selection sort in Wiki:

> In computer science, selection sort is a sorting algorithm, specifically an in-place comparison sort. It has O(n2) time complexity, making it inefficient on large lists, and generally performs worse than the similar insertion sort. Selection sort is noted for its simplicity, and it has performance advantages over more complicated algorithms in certain situations, particularly where auxiliary memory is limited.
The algorithm divides the input list into two parts: the sublist of items already sorted, which is built up from left to right at the front (left) of the list, and the sublist of items remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to the right.

In this example, we’ll assume that we’re working with simple integers and that we want to sort them in increasing order:
```java
private static void selectionSort (int[] a) {
    for (int i=0; i<a.length; ++i) {
      int minPos = findMinPos(a, i);
      swap (a,i,minPos);
  }
}
```
Note that this method uses two of the methods we saw earlier. The idea is to work our way through the array, determining which element should go in each position, and then swapping appropriately.

I think this sorting method finds the index of the smallest element starting from i (which itself starts from 0) to the end of the array and then it sticks that in i. i then increases.


#### Short explanation on garbage collection and Array memory allocation and Deallocation

When you create a new array with the new keyword, we say the array is created is dynamically allocated. The array doesn’t disappear when the method ends. Instead it persists and can be returned via a return value, passed to other methods and so on. The array will remain in memory as long as there is some reference to it, i.e. as long as there is some variable holding its address. When there are no more references the array is garbage-collected and its memory becomes available for reuse.
Here’s an example showing a case where an array becomes available for garbage collection:

```
  int[] a = new int[10];
  int[] b = new int[20];
  a = b;
```

After the first two statements, variables a and b point to distinct arrays. The third statement causes the address in b to be copied into a, meaning that both variables
13.6. NULL REFERENCES 123
point to the length-20 array. No variable points to the shorter array, so the shorter array is now garbage. When garbage collection occurs, the space used for the shorter array becomes available for reuse.
