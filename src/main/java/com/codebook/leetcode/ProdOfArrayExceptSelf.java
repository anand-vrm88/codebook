package com.codebook.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ProdOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 4};
        for (int num : productExceptSelf(nums)) {
            System.out.print(num + " ");
        }
    }


    public static int[] productExceptSelf(int[] nums) {
        int numsProd = 1;
        Set<Integer> zeroIndices = new HashSet<>();
        int index = 0;
        for(int num : nums){
            if(num != 0){
                numsProd *= num;
            }else{
                zeroIndices.add(index);
            }
            index++;
        }

        for(int i = 0; i < nums.length; i++){
            if(zeroIndices.size() == 0){
                nums[i] = numsProd / nums[i];
            } else if (!zeroIndices.contains(i) || zeroIndices.size() > 1){
                nums[i] = 0;
            } else{
                nums[i] = numsProd;
            }
        }

        return nums;
    }
}
