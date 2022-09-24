import java.util.ArrayList;
import java.util.List;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {

        List<Integer> result = new ArrayList<>();
        int[] c = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
            for (int k : b) {
                if (a[i] == k) {
                    c[i] = -1;
                }
            }
        }

        for (int k : c) {
            if (k != -1) {
                result.add(k);
            }
        }
        int[] d = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            d[i] = result.get(i);
        }

        for (int j : d) {
            System.out.println(j);
        }

        return d;
    }

}
