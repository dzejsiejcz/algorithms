import java.util.*;

class Permutations {

    public static List<String> singlePermutations(String s) {
        List<String> output = new ArrayList<>();
        List<String> prepare = permutation(s, output, 0);
        List<String> finished = new ArrayList<>();

        for (String entry : prepare) {
            if (!finished.contains(entry)) {
                finished.add(entry);
            }
        }
        return finished;
    }

    private static List<String> permutation(String s, List<String> output, int poz) {
        if (poz == s.length()) {
            output.add(s);
            return output;
        } else {
            for (int i = poz; i < s.length(); i++) {
                char[] c = s.toCharArray();
                char temp = c[i];
                c[i] = c[poz];
                c[poz] = temp;
                s = new String(c);
                output = permutation(s, output, poz + 1);
                c = s.toCharArray();
                temp = c[i];
                c[i] = c[poz];
                c[poz] = temp;
                s = new String(c);
            }
        }
        return output;
    }


    public static List<String> singlePermutations2(String s) {
        Set<String> set = new HashSet<>();
        if (s.length() == 1) {
            set.add(s);
        } else {
            for (int i = 0; i < s.length(); i++) {
                List<String> temp = singlePermutations(s.substring(0, i) + s.substring(i + 1));
                for (String string : temp) {
                    set.add(s.charAt(i) + string);
                }
            }
        }

        return new ArrayList<>(set);
    }

}