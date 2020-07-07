/**
 * @author : lichao
 * @date : 2020/7/7 6:33 下午
 */

public class SelectionSort {

    /**
     * 算法类不允许创建实例
     */
    private SelectionSort(){}

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // 寻找[i,n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i ,minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 测试排序算法辅助函数
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("SelectionSort", arr);
        SortTestHelper.printArray(arr);

        return;
    }

}
