package com.codebook.misc.cache;

import java.util.Map;

public interface EvictionPolicy<K, V> {

    void remove(Map<K, Integer> cacheMap, DataNode<K, V> head, DataNode<K, V> tail);
}
