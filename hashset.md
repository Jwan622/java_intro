## How to implement a set in java

**Some things to implement:**
- use private variables
- perhaps use transient variables, variables that won't persist with the state.
- since maps are key value pairs, and sets are not, we can use the map's keys as the sets values
and just associate each key in the keymap to a dummy value. That's the point of this line:

```java
private static final Object PRESENT = new Object();
```
-

```java
public class HashSet<E>
extends AbstractSet<E>
implements Set<E>, Cloneable, java.io.Serializable

{
    private transient HashMap<E,Object> map;

    // Dummy value to associate with an Object in the backing Map

    private static final Object PRESENT = new Object();



    public HashSet() {
        map = new HashMap<>();
    }

    // SOME CODE ,i.e Other methods in Hash Set


    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }

    // SOME CODE ,i.e Other methods in Hash Set
}
```

- In the above code, the HashSet constructor creates a new HashMap
- the add method is interesting. So the HashMap.put (key,value) will return

1. null , if the key is unique and successfully added to the map
2. The old value of the key, if the key is a duplicate key.



#### Iterating through a HashSet

There are following two ways to iterate through HashSet:
1. Using Iterator
2. Without using Iterator

**Example 1: Using Iterator**

```java
import java.util.HashSet;
import java.util.Iterator;

class IterateHashSet{
  public static void main(String[] args) {
     // Create a HashSet
     HashSet<String> hset = new HashSet<String>();

     //add elements to HashSet
     hset.add("Rick");
     hset.add("Rahul");
     hset.add("Tim");
     hset.add("Rick");
     hset.add("Harry");

     Iterator<String> it = hset.iterator();
     while(it.hasNext()){
        System.out.println(it.next());
     }
  }
}
```

**Example 2: Iterate without using Iterator**
```java
import java.util.HashSet;
import java.util.Set;

class IterateHashSet{
  public static void main(String[] args) {
     // Create a HashSet
     Set<String> hset = new HashSet<String>();

     //add elements to HashSet
     hset.add("Chaitanya");
     hset.add("Rahul");
     hset.add("Tim");
     hset.add("Rick");
     hset.add("Harry");

     for (String temp : hset) {
        System.out.println(temp);
     }
  }
}
```
