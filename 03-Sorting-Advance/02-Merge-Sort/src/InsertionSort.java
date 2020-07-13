/**
 * @author : lichao
 * @date : 2020/7/8 11:08 上午
 */

public class InsertionSort {

    /**
     * 算法类不允许产生任何实例
     */
    private InsertionSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            Comparable e = arr[i];
            int j = i;

            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--) {
                arr[j] = arr[j-1];
            }

            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {

        int n = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100000);
        SortTestHelper.testSort("InsertionSort", arr);

    }
}
