package cn.litiezhu.algorithm;


/**
 * @author Li Kai
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {9, 7, 11,1, 12, 1, 4, 3, 0};
        sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] <= v) if(i == hi) break;
            while (a[--j] >= v) if(j == lo) break;
            if(i >= j) break;
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        int tmp = a[lo];
        a[lo] = a[j];
        a[j] = tmp;
        return j;

    }

    public static ListNode sort(ListNode list) {
        return null;
    }
}
