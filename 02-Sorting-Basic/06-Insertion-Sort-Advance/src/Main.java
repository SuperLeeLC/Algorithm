/**
 * @author : lichao
 * @date : 2020/7/7 9:49 下午
 */

import java.util.Arrays;

public class Main {

    // 比较SelectionSort和InsertionSort两种排序算法的性能效率
    // 此时，插入排序比选择排序性能略低
    public static void main(String[] args) {

        int N = 10000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 100);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("SelectionSort", arr1);
        SortTestHelper.testSort("InsertionSort", arr2);

        return;
    }
}

