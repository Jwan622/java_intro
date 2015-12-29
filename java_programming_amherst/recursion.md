## Recursion in Java

Some problems can be solved elegantly by using recursion. This is the idea of using methods that call themselves, either directly or indirectly.

Consider, for example, the factorial function:

```
f(n) = n·(n 1)·(n 2)·...·3·2·1.
```

Note that for n > 1,

```
f(n) = n * f(n-1)
```

That is an alternative way to write a factorial function using recursion.


This version of the function is the basis of the following method for computing
factorials:
```java
public static int factorial (int n) {
  if (n <= 1) return 1;
    else return n * factorial(n-1);
}
```

**Notice that the method calls itself with a di↵erent parameter. Just as any method is “put on hold” when it calls another, the execution of this method with parameter n > 1 is “put on hold” while it calls itself with parameter n-1.**

The above bolded statement is a good way to think about the execution of recursive methods.

Let’s consider what happens when n is 10. The execution of factorial(10) pauses while a call is made to factorial(9). The execution of factorial(9) pauses while a call is made to factorial(8). And so on. Eventually a call is made to factorial(1). At this point calls are pending with all choices of n from 10 down to 1. The call to factorial(1) returns 1 back to factorial(2). The call to factorial(2) returns the result of factorial(1) which is 1 times 2.

And so on. The result is that factorial(10) indeed yields
```
10·9·8·7·6·5·4·3·2·1.
```

#### Fibonacci using recursion

The Fibonacci sequence is 1, 1, 2, 3, 5, 8, 13, 21, 34, .... Each term is the sum of the two preceding it. Let’s say that fib0 = 1, fib1 = 1, fib2 = 2, fib3 = 3, and so on. Here’s how we can compute this function with a recursive method:
```java
public static int fib (int n) {   // n is using 0 indexing here so 2 would actually be the third term of the sequence.
  if (n <= 1) return 1;
    else
  return fib(n-1) + fib(n-2);
}
```

Again, if n is more than one, a call to fib(n) must wait for the completion of calls to fib(n-1) and fib(n-2). Each __activation__, an individual call of the method, will have its own set of local variables.

This way of computing Fibonacci numbers is actually very ineffcient. A call to fib(10) yields calls to fib(9) and fib(8). The call to fib(9) yields another call to fib(8), along with a call to fib(7). The second call to fib(8) is wasted computation, and the waste is magnified enormously on later calls.

The lesson here is that recursion must be used carefully to avoid ine ciency. It’s important to avoid unnecessary recalculation of intermediate results.


#### Towers of Hanoi problem

Interestingly, this problem does not have a reasonable solution based on iteration, while recursion leads to a simple elegant solution.

```java
public static void hanoi (int n, int from, int to) {
  if (n == 1)
    System.out.println ("Move disk 1 from pin " + from
                        + " to pin " + to);
  else {
    int other = 6 - from - to;
    hanoi (n-1, from, other);
    System.out.println ("Move disk " + n + " from pin "
                        + from + " to pin " + to);
    hanoi (n-1, other, to);
  }
}
```

Interesting the method here is cool. You basically shuffle disks around between pin 1 and 3 until you can get the largest disk that is not on pin 2 to pin 2. I think I need to play with it and observe the pattern. It's still unclear to me algorithmically what is going on.


Here’s an amusing way to multiply two integers:
```java
public int mult (int a, int b) {
  if (a > 0)
    return mult(a-1, b) + b;
  else if (a == 0)
    return 0;
  else
    return mult(-a, -b);
}
```

What is the above if we did mult(-3,2)  which = -6?
This would be the stack:
mult(3,-2)
mult(2,-2) + -2
mult(1,-2) + -2
mult(0,-2) + -2  
then mult(0,-2) returns 0 and we can go back up the call stack.  

it resolves to -6
