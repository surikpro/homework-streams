import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task2 {

    private final static int SUM_VALUE = 10;

    public static void main(String[] args) {
        // [3, 4, 2, 7], 10 -> [3, 7]
        int[] array = {3, 4, 2, 7, 5, 5};
        // time complexity: O(n^2)
        System.out.println("Time complexity: O(n^2)");
        System.out.println(Arrays.toString(findSumOfTwoNumbers(array)));
        // time complexity: O(n)
        System.out.println("Time complexity: O(n)");
        System.out.println(Arrays.toString(findSum(array)));
    }

    public static int[] findSumOfTwoNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] + array[j]) == SUM_VALUE) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[]{};
    }

    public static int[] findSum(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int complement = SUM_VALUE - array[i];
            if (map.containsKey(complement)) {
                return new int[]{array[map.get(complement)], array[i]};
            } else {
                map.put(array[i], i);
            }
        }
        return new int[]{};
    }
}
