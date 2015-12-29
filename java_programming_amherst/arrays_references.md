In this chapter we consider precisely how arrays are handled in Java. Suppose you declare
```
int[] a = new int[100];
```

This statement does several things:
1. It creates a variable of type int[], which means “array of int”. The variable won’t contain the actual array, but rather it will contain a reference (also called a pointer) to the array itself. Think of a reference as a numeric address telling where the array is located in the computer’s memory.
2. It allocates space to hold 100 integers.
3. It sets the variable so that it refers to the allocated memory.
Now suppose you execute a statement such as
a[3] = 27;
The computer will check variable a to obtain the address of the array. It will then go to the array itself, find position 3, and store the value 27 in that position.
