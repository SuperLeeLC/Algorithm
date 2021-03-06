/**
 * @author : lichao
 * @date : 2020/7/8 5:39 下午
 */

public class QuickSort {

    private QuickSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    /**
     * 递归使用快速排序,对arr[l...r]的范围进行排序
     * @param arr       需要排序的数组
     * @param l         数组最左边索引
     * @param r         数组最右边索引
     */
    private static void sort(Comparable[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    /**
     * 对arr[l...r]部分进行partition操作
     * 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     * @param arr       数组
     * @param l         数组最左边索引
     * @param r         数组最右边索引
     * @return          返回 p 的索引
     */
    private static int partition(Comparable[] arr, int l, int r) {

        swap(arr, l, (int)(Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        // arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l;

        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, i, j);
            }
        }

        swap(arr, l, j);

        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("QuickSort", arr);

        return;
    }
}
