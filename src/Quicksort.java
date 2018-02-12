import edu.princeton.cs.algs4.StdRandom;

public class Quicksort {

    public static void sort(Comparable[] a) {
        // shuffle needed for performance guarantee
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    
    private static void threeWayQuickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            // find item on left to swap
            while (less(a[++i], a[lo]))
                if (i == hi)
                    break;

            // find item on right to swap
            while (less(a[lo], a[--j]))
                if (j == lo)
                    break;

            // check if pointers cross swap
            if (i >= j)
                break;

            // exchange i, j
            exch(a, i, j);
        }

        // swap with partitioning item
        exch(a, lo, j);
        // return index of item now known to be in place
        return j;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // find the kth smallest item
    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return a[k];
        }
        return a[k];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
