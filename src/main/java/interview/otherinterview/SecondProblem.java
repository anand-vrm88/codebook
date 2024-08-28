package interview.otherinterview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SecondProblem {

    public static void main(String[] args) {
        int[] numbners = {-1, 0, 1, 2, -1, -4};
        findTriplet(numbners, 0);
    }


    private static Set<Integer> findTriplet(int[] numbers, int targetSum){
        for(int index = 0; index < numbers.length; index++){
            int remainingSum = targetSum - numbers[index];
            List<Set<Integer>> results = findTwoSum(numbers, remainingSum, index + 1);



            for(Set<Integer> result: results){
                System.out.println(result);
                /*if (result.isEmpty())
                    continue;
                result.add(numbers[index]);
                System.out.println(result);*/
            }
        }
        return new HashSet<>();
    }

    private static List<Set<Integer>> findTwoSum(int[] numbers, int targetSum, int index){
        List<Set<Integer>> results = new LinkedList<>();
        Set<Integer> numsSet = new HashSet<>();
        for(int i = index; i < numbers.length; i++){
            if (numsSet.contains(targetSum - numbers[i])) {
                Set<Integer> result = new HashSet<>();
                result.add(numbers[i]);
                result.add(targetSum - numbers[i]);
                results.add(result);
            }
            numsSet.add(numbers[index]);
        }
        return results;
    }
}
