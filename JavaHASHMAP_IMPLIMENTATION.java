/* HASHMAP IS AN IMPLIMENTATION OF HASH TABLE*/
/*IN HASHMAP WE ARE FACIILITATED BY O(1) TIME COMPLEXITY FOR VARIOUS FUNCTION */
/* IN THIS CODE I AM CREATING HASHMAP FROM SCRATCH */

import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V>  // GENERIC SUPPORT
  {
    private class HMNode {      // HMNode class for assigning key and values to the hashmap. as we know that class is a primitive data type so we can modify 
                                // the type of data structure we wanted on our own.
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size;                                            // this will give the size of the hashmap.
    private LinkedList<HMNode>[] buckets;                        // N = buckets.length, created an array of linkedlist
                                                                 // basic implementation of hash table.

    public HashMap() {
      initbuckets(4);                // initializing the size of the array
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception     // HASHMAP.PUT() FUNCTION
    {
     int bi=hashfn(key);        // finding the index of the key in the hashtable
    int di=getindex(key,bi);    // finding the index in the linkedlist of index bi of the array
    if(di!=-1)
    {
      HMNode node= bucket[bi].get(di);  // alter the value of the key if present in the linkedlist
      node.value=value;
    }
    else{
        HMNode node=new HMNode(key,value);   // else create a new node
        bucket[bi].add(node);
    size++;
    }
    double loadf=(size*1.0)/bucket.length;   // LOAD FACTOR FROM THE IMPLEMENTATION OF HASH TABLE
    if(loadf>2.0) 
    {
        rehash();   // rehashing if load factor > 2.0 , this prevent from increasing the size of the linked list beyond the certain value 
                    // so as to maintain the time complexity within O(1).
    }
}
    }

    public V get(K key) throws Exception     // HASHMAP.GET()
    {
     int bi=hashfn(key);
    int di=getindex(key,bi);
    if(di!=-1)
    {
      HMNode node= bucket[bi].get(di);
      return node.value;                     // if the value is present in the bucket , return the key.value
    }
    else{
       return null;                          // else return null
    }
    }
    

    public boolean containsKey(K key) {
  int bi=hashfn(key);
    int di=getindex(key,bi);
    if(di!=-1)
    {
     return true;                       // // if the value is present in the bucket , return true
    }
    else{
       return false;   // else false
    }
    }
    

    public V remove(K key) throws Exception {
   int bi=hashfn(key);
    int di=getindex(key,bi);
    if(di!=-1)
    {
     bucket[bi].remove(di);
    size--;
    }
    else{
       return null;
    }
    }

    public ArrayList<K> keyset() throws Exception {     // implementation of keyset data structure in java
       ArrayList<K> kkeyset=new ArrayList<>();          // created an arraylist of HMNode.
    for(int i=0;i<bucket.length;i++)                  // iterate through the bucket array
    {                                                 // and add key.value to the arraylist
      for(HMNode node:bucket[i])
      {
          kkeyset.add(node.key);
        }
    }
      return kkeyset;   // return arrylist containing key.values of each node
    }

    public int size() {
     return size;        // size of the hashmap
    }

   public void display() {                        // iterating through out the bucket array
      System.out.println("Display Begins");       // fetching key.value from every node and printing them 
      for (int bi = 0; bi < buckets.length; bi++) {  // using System.out.print();
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
private static void rehash()    // if the size of the linked list becomes greater then load factor
{                              //  just doubles the size of the array 
    LinkedList<HMNode> oba[]=bucket;          // as load factor is size of hashmap / bucket length
    initbuckets(oba.length*2);
  for(int i=0;i<bucket.length;i++)          // so by increasing the length of bucket the load factor become less than 2 again.
    {
      for(HMNode node:bucket[i])
      {
         put(node.key,node.value);
        }
    }
}
private static int hashfn(K keys)  // hash function from the basic implementation of hashtable
{
    int hc=key.hashcode();
    return (Math.abs(hc)%bucket.length);  // hash function will give the index of the key using the hash code
}
private static int getindex(K key, int bi)
{
    int di=0;
    for(HMNode node:bucket[bi])
    {
        if(node.key.equal(key)){
    return di;}
else{
    di++;}
return -1;}
}
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
