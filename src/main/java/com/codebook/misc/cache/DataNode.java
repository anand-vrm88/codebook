package com.codebook.misc.cache;

public class DataNode <K, V>{

    private final K key;
    private final V value;
    private DataNode<K, V> next;
    private DataNode<K, V> prev;

    public DataNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public DataNode<K, V> getNext() {
        return next;
    }

    public DataNode<K, V> getPrev() {
        return prev;
    }

    public void setNext(DataNode<K, V> next) {
        this.next = next;
    }

    public void setPrev(DataNode<K, V> prev) {
        this.prev = prev;
    }
}
