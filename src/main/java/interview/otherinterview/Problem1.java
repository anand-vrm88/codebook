package interview.otherinterview;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class Problem1 {
    public static void main(String[] args) {

    }
}


class LruCache {
    Map<String, Object> cache = new HashMap<>();

    Map<String, Node> cache2 = new HashMap<>();


    PriorityQueue<PriorityData> priorityQueue;
    private final int capacity;
    private int currentSize;

    public LruCache(int capacity) {
        this.capacity = capacity;



        priorityQueue =  new PriorityQueue<>(
                (PriorityData val1, PriorityData val2) ->
                        val1.criteria.compareTo(val2.criteria)
        );
    }

    public void put(String key, Object value){
        if(currentSize <= capacity){
            //Evict
            PriorityData removeObject = this.priorityQueue.remove();

        }

        if(this.cache.keySet().contains(key)){

        }

        this.cache.put(key, value);
        this.priorityQueue.add(new PriorityData(key, Timestamp.from(Instant.EPOCH)));
    }

    public Object get(String key){
        return null;
    }
}

class PriorityData {
    String key;
    Timestamp criteria;

    public PriorityData(String key, Timestamp criteria) {
        this.key = key;
        this.criteria = criteria;
    }
}




class Node {
    Object value;
    String key;
    Node next;
    Node prev;
}
