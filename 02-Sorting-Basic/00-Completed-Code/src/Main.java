import java.util.Arrays;

/**
 * @author : lichao
 * @date : 2020/7/8 11:09 上午
 */

public class Main {

    /**
     * 比较SelectionSort和InsertionSort两种排序算法的性能效率
     * @param args
     */
    public static void main(String[] args) {

        int n = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + n + " , random range [0, " + n + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(n, 0, n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("InsertionSort", arr2);

        System.out.println();


        // 测试2 有序性更强的测试
        System.out.println("Test for more ordered random array, size = " + n + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(n, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("InsertionSort", arr2);

        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + n + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(n, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("InsertionSort", arr2);

    }
}
