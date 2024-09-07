package com.codebook.misc.cache;

import java.util.Map;
import java.util.Objects;

public class LruEvictionPolicy<K, V> implements EvictionPolicy<K, V> {

    @Override
    public void remove(Map<K, Integer> cacheMap, DataNode<K, V> listHead, DataNode<K, V> listTail) {
        if (Objects.isNull(listHead) || Objects.isNull(listTail)) {
            return;
        }

        if(listHead == listTail){
            listHead = null;
            listTail = null;
        }

        DataNode<K, V> lastNode = listTail;
        DataNode<K, V> prevToLastNode = lastNode.getPrev();

        /*DataNode<K, V> reshufflingNode = listTail;

        DataNode<K, V> prevNode = listTail.getPrev();
        prevNode.setNext(null);

        listTail.setPrev(null);

        reshufflingNode.setNext(listHead);

        cacheMap.remove(reshufflingNode.getKey());*/
    }
}