/**
 * @author RChen
 * 
 * ~ 1/2 N^2 compares and N exchanges.
 * Quadratic time, even if input is sorted.
 * 
 */

public class Selection {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (Helper.less(a[j], a[min])) {
                    min = j;
                }
            }
            Helper.exch(a, i, min);
        }
    }

}
