/**
 * @author RChen
 * 
 * Average Case: ~ 1/4 N^2 compares and ~ 1/4 N^2 exchanges
 * Best Case: Array is in ascending order
 *            N - 1 compares and 0 exchanges
 * Wrost Case: Array is in descending order
 *             ~ 1/2 N^2 compares and ~ 1/2 N^2 exchanges
 */

public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (Helper.less(a[j], a[j - 1])) {
                    Helper.exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
