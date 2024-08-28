package interview.otherinterview;

import java.util.HashSet;
import java.util.Set;

/**
 * 5 ->
 * 4 -> {1}^4, {4, 1, 2}, {1,3}, {2, 3}, {1,2,3}}
 * 3 -> {1}^3, {1, 2}, {1,3}, {2, 3}, {1,2,3}
 * 2 -> {1}^2, {1, 2}
 * 2-> 3 -> (2)^2
 * 3 -> 7 -> (2)^3
 *
 *
 * n -> (n-1) -> {}, {{}, {1}}, 2
 */
public class InterviewFirstProblem {

    private static void generateSubsetsV1(int n) {
        int[] numbers = new int[n];

        for (int index = 1; index <= n; index++) {
            numbers[index - 1] = index;
        }

        System.out.println(new HashSet<>());
        for(int index = 0; index < n; index++){
            Set<Integer> set = new HashSet<>();
            set.add(numbers[index]);
            generateSubsetsV1(set, numbers, index+1, numbers.length);
        }
    }


    private static void generateSubsetsV1(Set<Integer> set, int[] numbers, int index, int length){
        if (index >= length) {
            return;
        }
        System.out.println(set);

        set.add(numbers[index]);
        generateSubsetsV1(set, numbers, index+1, length);

    }

    private static void generateSubsets(int[] numbers, int numbersConsideredSoFar, int numbersInSet, int index, Set<Integer> set) {
        if(index >= numbers.length){
            return;
        }
        if (numbersConsideredSoFar >= numbersInSet) {
            System.out.println(set);
            return;
        }

        set.add(numbers[index]);
        generateSubsets(numbers, numbersConsideredSoFar + 1, numbersInSet, index + 1, set);
        generateSubsets(numbers, numbersConsideredSoFar, numbersInSet, index+1, new HashSet<>());
    }

    public static void main(String[] args) {
        generateSubsetsV1(2);
    }
}


/**
 * n -> 3
 *
 * 000
 * 001
 * 010
 * 111
 *
 * {1, 2, 3}
 *
 */