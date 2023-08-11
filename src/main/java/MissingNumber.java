import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Imagine a list of numbers from 1 to max_num, inclusive - except
that one of these numbers will be missing from the list.

Write a function that takes this list of numbers, as well as the max_num,
and it should return the missing number.

For example, given a list of numbers, in random order, of 1…10,
8 was removed. If this list and the maxNum of 10 was passed into the function,
it would return 8: missingNumber({2, 1, 4, 3, 6, 5, 7, 10, 9}, 10) ⇒ 8

If there is no missing number, the function should return 0.

#1
Initially, focus on reducing runtime—this should be solvable in O(n) time.
You can create an additional data structure using a Java library if necessary.
Write a version that uses a straightforward solution and runs in O(n) time.

#2
Now, think about reducing memory use—did your first solution require
you to create a new object? Can you think of a different way to think about
the problem that doesn't use additional memory, even if it takes more time?

There’s a way you could solve this in O(n log n) time that doesn't require
creating another large data structure (technically, while being O(n log n) in runtime,
it is O(1) in "runspace"—it uses the same amount of memory no matter how big n is).

#3
There’s a solution that has O(n) runtime and O(1) runspace,
but it requires a bit of creative thinking about the problem from a math perspective.
See if you can find it.

# Similar problem on LeetCode
https://leetcode.com/problems/missing-number/

 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber1(new int[]{2, 1, 4, 3, 6, 5, 7, 10, 9}, 10)); //8
        System.out.println(missingNumber1(new int[]{2, 1, 4, 3, 6, 5, 7, 8, 9}, 9)); //0
        System.out.println(missingNumber1(new int[]{12, 1, 4, 10, 6, 5, 7, 8, 9, 11, 15, 2, 14, 13}, 15)); //3
        System.out.println(missingNumber1(new int[]{2, 1, 4, 3, 6, 5, 7, 8, 9}, 10)); //10

        System.out.println();
        System.out.println(missingNumber2(new int[]{2, 1, 4, 3, 6, 5, 7, 10, 9}, 10)); //8
        System.out.println(missingNumber2(new int[]{2, 1, 4, 3, 6, 5, 7, 8, 9}, 9)); //0
        System.out.println(missingNumber2(new int[]{12, 1, 4, 10, 6, 5, 7, 8, 9, 11, 15, 2, 14, 13}, 15)); //3
        System.out.println(missingNumber2(new int[]{2, 1, 4, 3, 6, 5, 7, 8, 9}, 10)); //10

        System.out.println();
        System.out.println(missingNumber3(new int[]{2, 1, 4, 3, 6, 5, 7, 10, 9}, 10)); //8
        System.out.println(missingNumber3(new int[]{2, 1, 4, 3, 6, 5, 7, 8, 9}, 9)); //0
        System.out.println(missingNumber3(new int[]{12, 1, 4, 10, 6, 5, 7, 8, 9, 11, 15, 2, 14, 13}, 15)); //3
        System.out.println(missingNumber3(new int[]{2, 1, 4, 3, 6, 5, 7, 8, 9}, 10)); //10
    }


    // Time complexity: O(n)
    // Space complexity: O(n) - set
    public static int missingNumber1(int[] numbers, int maxNum) {
        Set<Integer> numbersSet = new HashSet<>();

        for (int n : numbers) {
            numbersSet.add(n);
        }

        for (int i = 1; i <= maxNum; i++) {
            if (!numbersSet.contains(i)) {
                return i;
            }
        }

        return 0;
    }

    // Time complexity: O(nlogn) - sorting
    // Space complexity: O(1)
    public static int missingNumber2(int[] numbers, int maxNum) {
        Arrays.sort(numbers);

        // numbers.length could be less than maxNum
        for (int i = 1; i <= numbers.length; i++) {
            if (numbers[i - 1] != i) {
                return i;
            }
        }

        if (numbers.length < maxNum) { // we already checked all the numbers
            return maxNum;
        }

        return 0;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int missingNumber3(int[] numbers, int maxNum) {
        int expectedSum = (maxNum + 1) * maxNum / 2;
        int actualSum = 0;

        for (int num : numbers) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
