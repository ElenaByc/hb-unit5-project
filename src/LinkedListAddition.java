/*
You will be given two linked lists in “reverse-digit” format.
For example, the number 123 would be represented in a linked list like this: 3 → 2 → 1
You should return the sum of these two numbers in the same “reverse-digit” format.
For 123 + 456, this should return 579, in the form of a linked list like this: 9 → 7 → 5.

What is the runtime of this function?
*/

import java.util.LinkedList;

public class LinkedListAddition {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(3);
        list1.add(2);
        list1.add(1);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(6);
        list2.add(5);
        list2.add(4);
        LinkedList<Integer> result = linkedListAddition(list1, list2);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static LinkedList<Integer> linkedListAddition(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> sumList = new LinkedList<>();
        int num1 = 0;
        int num2 = 0;
        int sum;

        int tens = 1;
        for (int i = 0; i < list1.size(); i++) {
            num1 += list1.get(i) * tens;
            tens *= 10;
        }

        tens = 1;
        for (int i = 0; i < list2.size(); i++) {
            num2 += list2.get(i) * tens;
            tens *= 10;
        }

        System.out.println("number1 = " + num1);
        System.out.println("number2 = " + num2);

        sum = num1 + num2;
        while (sum > 0) {
            sumList.add(sum % 10);
            sum /= 10;
        }

        return sumList;
    }
}
