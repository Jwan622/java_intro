/*
The following example is contained in the project "de.vogella.datastructures.map".
A map represents a data structure in which collections of unique key and collections
of values are stored where each key is associated with one value. The operation
of finding the value is called lookup.

A standard array is a special case of a map where the key are the index number
of the elements pointing to the object in the array.
The standard Java interfaces for maps is import java.util.Map. Standard
implementations of Maps are for example java.util.HashMap
*/


// first a mapEntry

public class MyEntry<K, V> {
  private final K key;
  private V value;

  public MyEntry(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }
}

// map implementation
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class MyMap<K, V> {   // think of a map as an array of MapEntrys
  private int size;
  private int DEFAULT_CAPACITY = 16;

  private MyEntry<K,V>[] values = new MyEntry[DEFAULT_CAPACITY]; //this is an array

  public V get(K key) {
    for (int i = 0; i < size; i++) {
      if (values[i] != null) {   // if values[i] isn't null / there is an entry in that 16 capacity spot
        if (values[i].getKey().equals(key)) {    //if the mapEntry at i key == the passed in key
          return values[i].getValue();
        }
      }
    }
    return null;  // if the key isn't found, return null
  }

  public void put(K key, V value) {
    boolean insert = true;
    for (int i = 0; i< size; i++) {
      if (values[i].getKey().equals(key)) {
        values[i].setValue(value);
        insert = false;
      }
    }
    if (insert) {
      ensureCapa();
      values[size++] = new MyEntry<K, V>(key, value);
    }
  }

  private void ensureCapa() {
    if (size == values.length) {
      int newSize = values.length * 2;
      values = Arrays.copyOf(values, newSize);  // create a new array with padded 0s
    }
  }

  public int size() {
    return size;
  }

  public void remove(K key) {
    for (int i = 0; i < size; i++) {
      if (values[i].getKey().equals(key)) {
        values[i] = null;
        size--;
        condenseArray(i);
      }
    }
  }

  private void condenseArray(int start) {
    for (int i = start; i < size; i++) {
      values[i] = values[i+1];
    }
  } //so basically this works like this: once we remove an MapEntry from the Map array, we need to shift
  // everything in front of it back 1 index.

  public Set<K> keySet() {
    Set<K> set = new HashSet<K>();  //why do we do this?
    for (int i = 0; i < size; i++) {
      set.add(values[i].getKey());
    }
    return set;
  }
}
