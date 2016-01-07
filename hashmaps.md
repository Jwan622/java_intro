## Hashmaps

**Other good points:**
Since the internal array of HashMap is of fixed size, and if you keep storing objects, at some point of time hash function will return same bucket location for two different keys, this is called collision in HashMap. In this case, a linked list is formed at that bucket location and a new entry is stored as next node.

If we try to retrieve an object from this linked list, we need an extra check to search correct value, this is done by equals() method. Since each node contains an entry, HashMap keeps comparing entry's key object with the passed key using equals() and when it return true, Map returns the corresponding value.



#### How to iterate over a map?

Why do we need to call entrySet on the map object?

**Answer:**
This is as close to iterating over the map as we can because you have to say
whether you want just the keys, just the values or the whole key/value entry.
For Sets and Lists, there is only one option so, no need to have a separate method to do this.

BTW: This is how I would iterate over a Map. Note the use of generics, the for-each loop and the LinkedHashMap so the entries appear in some kind of logical order. TreeMap would be another good choice.

```java
Map<K,V> m=new LinkedHashMap<K,V>();
for(Map.Entry<K,V> entry: m.entrySet())
    System.out.println(entry.getKey() + ": " + entry.getValue());
```


#### Why do we iterate using a set why no directly map???

You can iterate over the keys, or the values, or the entries. But what does it mean to "iterate directly over the map"?

Presumably you mean iterating over the keys and values in parallel without returning a Map.Entry object. That would require the iterator's next() method to return two result objects ... and you can't do that in Java!!.

In Java, a method returns one value (or none). It is not possible to return multiple values without wrapping them in a reference type ... and then you are actually returning an instance of that reference type. And that is precisely what the entrySet iterator is doing!

Iteration is an operation on a collection generally, not a map specifically.

**If you only need the values, use values():**
```java
for (Object value : map.values()) {
    // ...
}
```

**Finally, if you want both the key and value, use entrySet():**
```java
for (Map.Entry<String, Object> entry : map.entrySet()) {
    String key = entry.getKey();
    Object value = entry.getValue();
    // ...
}
```

if you want to remove items mid-iteration, you'll need to do so via an Iterator (see karim79's answer).


**If you're going to use an iterator:**
```java
public static void printMap(Map mp) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
}
```
