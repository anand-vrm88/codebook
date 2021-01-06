package com.codebook.leetcode;

import java.util.Stack;

public class RainWater {

    public static void main(String[] args) {
        RainWater rainWater = new RainWater();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(rainWater.trap(height));
    }

    public int trap(int[] height) {
        int rainWater = 0;
        Stack<Pair> stack = new Stack<>();


        for(int i = 0; i < height.length; i++){
            int h = height[i];
            if(stack.isEmpty() || stack.peek().value > h){
                stack.push(new Pair(i, h));
                continue;
            }

            while(stack.size() > 1 && stack.peek().value < h){
                Pair mediator = stack.pop();
                Pair left = stack.peek();
                int waterWidth = i - left.index - 1;
                int waterHeight = Math.min(left.value, h) - mediator.value;
                if(waterHeight >= 0 && waterWidth >= 0) {
                    rainWater += (waterWidth * waterHeight);
                }
            }
            stack.push(new Pair(i, h));
        }

        return rainWater;
    }

    static class Pair {
        public int index;
        public int value;

        public Pair(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
