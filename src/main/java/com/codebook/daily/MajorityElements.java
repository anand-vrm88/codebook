package com.codebook.daily;

import java.util.*;

public class MajorityElements {

    public static void main(String[] args) {
        //System.out.println(findMajorityElements(Arrays.asList(1, 2, 1, 1, 3, 4, 0)));
        System.out.println(findMajorityElementsV2(Arrays.asList(2,2,1,1,1,2,2)));
    }

    private static List<Integer> findMajorityElements(List<Integer> elements) {
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> elementsFrequency = new HashMap<>();
        for (Integer element : elements) {
            Integer frequency = elementsFrequency.getOrDefault(element, 0);
            frequency++;
            if (frequency >= elements.size() / 2) {
                result.add(element);
            }
            elementsFrequency.put(element, frequency);
        }
        return new LinkedList<>(result);
    }

    private static int findMajorityElementsV2(List<Integer> elements) {
        Set<Integer> result = new HashSet<>();
        Map<Integer, Integer> elementsFrequency = new HashMap<>();
        for (Integer element : elements) {
            Integer frequency = elementsFrequency.getOrDefault(element, 0);
            frequency++;
            if (frequency >= elements.size() / 2) {
                result.add(element);
            }
            elementsFrequency.put(element, frequency);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (x, y) -> y - x
        );
        queue.addAll(result); //O(nlogn)
        return queue.isEmpty() ? -1 : queue.remove();
    }
}
