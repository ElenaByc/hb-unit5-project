public class RecursiveSearch {
    public static void main(String[] args) {
        Integer[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(recursiveSearch(nums, 7));
        System.out.println(recursiveSearch(nums, 3));
        System.out.println(recursiveSearch(nums, 11));
        System.out.println();

        String[] words = {"hey", "there", "are", "you"};
        System.out.println(recursiveSearch(words, "hey"));
        System.out.println(recursiveSearch(words, "you"));
        System.out.println(recursiveSearch(words, "apple"));

    }

    private static int recursiveSearch(Object[] arr, Object item) {
        return recursiveSearch(arr, item, 0);
    }

    private static int recursiveSearch(Object[] arr, Object item, int index) {
        if (index == arr.length) {
            return -1;
        }

        if (arr[index].equals(item)) {
            return index;
        }

        return recursiveSearch(arr, item, index + 1);
    }
}
