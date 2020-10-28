/* HASHMAP IS AN IMPLIMENTATION OF HASH TABLE*/
/*IN HASHMAP WE ARE FACIILITATED BY O(1) TIME COMPLEXITY FOR VARIOUS FUNCTION */
/* IN THIS CODE I AM CREATING HASHMAP FROM SCRATCH */

import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V>  // GENERIC SUPPORT
  {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception  // HASHMAP.PUT() FUNCTION
    {
     int bi=hashfn(key);
    int di=getindex(key,bi);
    if(di!=-1)
    {
      HMNode node= bucket[bi].get(di);
      node.value=value;
    }
    else{
        HMNode node=new HMNode(key,value);
        bucket[bi].add(node);
    size++;
    }
    double loadf=(size*1.0)/bucket.length;   // LOAD FACTOR FROM THE IMPLIMENTATION OF HASH TABLE
    if(loadf>2.0) 
    {
        rehash();
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
      return node.value;
    }
    else{
       return null;
    }
    }
    

    public boolean containsKey(K key) {
  int bi=hashfn(key);
    int di=getindex(key,bi);
    if(di!=-1)
    {
     return true;
    }
    else{
       return false;
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

    public ArrayList<K> keyset() throws Exception {
       ArrayList<K> kkeyset=new ArrayList<>();
    for(int i=0;i<bucket.length;i++)
    {
      for(HMNode node:bucket[i])
      {
          kkeyset.add(node.key);
        }
    }

    public int size() {
     return size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
private static void rehash()
{
    LinkedList<HMNode> oba[]=bucket;
    initbuckets(oba.length*2);
  for(int i=0;i<bucket.length;i++)
    {
      for(HMNode node:bucket[i])
      {
         put(node.key,node.value);
        }
    }
}
private static int hashfn(K keys)
{
    int hc=key.hashcode();
    return (Math.abs(hc)%bucket.length);
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
