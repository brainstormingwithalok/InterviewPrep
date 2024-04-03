package main.java.algos.miscellenious;

import java.net.PasswordAuthentication;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {

    private int capacity;
    private int age;
    private Map<Integer,Pair> map;

    class Pair{
        int key;
        int age;
        Pair(int key,int age){
            this.key=key;
            this.age=age;
        }
    }
    PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.age-o2.age;
        }
    });



    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>(capacity);
    }

    public int get(int key) {
        Pair pair=map.get(key);
       if(null==pair){
           return -1;
       }
       else {
           Pair newPair=new Pair(key,age++);
           map.put(key,newPair);
           pq.add(newPair);
           return key;
       }
    }

    public void put(int key, int value) {
        Pair newPair=new Pair(key,age++);
        if(map.size()==capacity){
            //remove
            Pair removedPair=pq.poll();
            map.remove(removedPair.key);
        }
        map.put(key,newPair);
        pq.add(newPair);
    }
}
