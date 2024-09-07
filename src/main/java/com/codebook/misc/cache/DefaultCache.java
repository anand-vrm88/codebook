package com.codebook.misc.cache;

import java.util.HashMap;
import java.util.Map;

public class DefaultCache<K, V> implements Cache<K, V> {

    private final Map<K, Integer> cacheMap = new HashMap<>();
    private DataNode<K, V> listHead;
    private DataNode<K, V> listTail;
    private final int cacheSize;
    private final EvictionPolicy<K, V> evictionPolicy;

    public DefaultCache(int cacheSize, EvictionPolicy<K, V> evictionPolicy) {
        this.cacheSize = cacheSize;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public void set(K key, V value) {
        //If cache is full, use eviction policy to remove cached item.
        if (cacheMap.size() >= cacheSize) {
            evictionPolicy.remove(cacheMap, listHead, listTail);
        }

/*        if (cacheMap.containsKey(key)) {
            DataNode<K, V> removedNode = dataNodes.remove(cacheMap.get(key).intValue());
            dataNodes.add(0, removedNode);
            cacheMap.put(key, 0);
        } else {

        }*/
    }

    @Override
    public V get(K key) {
        return null;
    }
}
