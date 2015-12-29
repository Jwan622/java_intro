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