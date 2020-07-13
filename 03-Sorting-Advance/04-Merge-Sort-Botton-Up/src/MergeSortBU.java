import java.util.Arrays;

/**
 * @author : lichao
 * @date : 2020/7/8 4:14 下午
 */

public class MergeSortBU {

    private MergeSortBU(){}

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // Merge Sort Bottom Up 无优化版本
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz -1, n -1));
            }
        }

        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
//        for( int i = 0 ; i < n ; i += 16 ) {
//            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );
//        }
//
//        for( int sz = 16; sz < n ; sz += sz ) {
//            for( int i = 0 ; i < n - sz ; i += sz+sz ) {
//                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
//                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 ) {
//                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
//                }
//            }
//        }

    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     * @param arr       需要合并的数组
     * @param l         最左边索引
     * @param mid       左半部分最后一个元素索引
     * @param r         最右边索引
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++) {

            // 如果左半部分元素已经全部处理完毕
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            }
            // 如果右半部分元素已经全部处理完毕
            else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            // 左半部分所指元素 < 右半部分所指元素
            else if (aux[i - l].compareTo(aux[j-l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            }
            // 左半部分所指元素 >= 右半部分所指元素
            else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

}
