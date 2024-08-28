package com.codebook.interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private Map<K, Node> cache = new HashMap<>();
    private final Integer capacity;
    private Node head;
    private Node tail;

    public LRUCache(Integer size) {
        this.capacity = size;
    }

    public void put(K key, V value){
        if (cache.size() < this.capacity) {
            if (head == null) {
                Node head = new Node(key, value, null, null);
                tail = head;
            } else {
                if (cache.containsKey(key)) {
                    reshuffleNode(key, value);
                }
                Node node = new Node(key, value, head, null);

            }
            cache.put(key, head);
        } else {
            remove(key);
        }
    }

    private void reshuffleNode(K key, V value) {
        if(this.cache.size() == 1){
            return;
        }

        if(value == head){

        } else if ( value == tail){

        } else{

        }
        Node node = cache.get(key);
        Node prevNode = node.prev;
        Node nextNode = node.next; ///Null
        node.next = head;
        head.prev = node;
        head = node;
        prevNode.next = nextNode;
        if(nextNode.prev != null) {
            nextNode.prev = prevNode;
        }
        node.value = value;
    }

    public V get(K key){
        return null;
    }

    public boolean remove(K key){
        if(head == null){
            return false;
        }
        return false;
    }


    class Node {
        V value;
        K key;
        Node next;
        Node prev;

        public Node(K key, V value, Node next, Node prev) {
            this.value = value;
            this.key = key;
            this.next = next;
            this.prev = prev;
        }
    }
}
