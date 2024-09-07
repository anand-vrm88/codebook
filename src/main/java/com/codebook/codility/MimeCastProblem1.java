package com.codebook.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MimeCastProblem1 {

    public static void main(String[] args) {
        new MimeCastProblem1().solution(new int[]{1, 3, 6, 4, 1, 2});
    }


    public int solution(int[] A) {
        // Implement your solution here
        List<Integer> list = getList(A);
        Collections.sort(list);

        if(list.get(list.size()-1) <= 0){
            return 1;
        }

        int smallestNumber = 0;
        for(int index = 0; index < list.size(); index++){
            if(list.get(index) != (index+1)){
                return index+1;
            }
        }

        return list.get(list.size() - 1) + 1;
    }

    private List<Integer> getList(int[] A) {
        List<Integer> list = new LinkedList<>();
        for (int index = 0; index < A.length; index++) {
            list.add(A[index]);
        }
        Exception e = new Exception();
        e.getMessage();
        return list;
    }
}
