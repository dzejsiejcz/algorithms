import java.util.*;

public class Burrows {

    public static BWT encode(String s) {
        int length = s.length(), resultRow = -1;
        char[][] chars = new char[length][length];

        for (int i = 0; i < length; i++) {
            chars[i] = s.toCharArray();
        }

        char temp, swap;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                temp = chars[i][length - 1];
                for (int k = 0; k < length; k++) {
                    swap = temp;
                    temp = chars[i][k];
                    chars[i][k] = swap;
                }
            }
        }

        String[] args = new String[length];
        for (int i = 0; i < length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append(chars[i][j]);
            }
            args[i] = sb.toString();
        }

        Arrays.sort(args);

        for (int i = 0; i < length; i++) {
            if (args[i].equals(s)) {
                resultRow = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(args[i].charAt(length - 1));
        }

        return new BWT(sb.toString(), resultRow);
    }


    public static String decode(String s, int n) {
        if (n < 0) return "";

        StringBuilder builder = new StringBuilder();
        builder.setLength(0);

        int length = s.length();
        char[] preArr = s.toCharArray();
        char[] nextArr = s.toCharArray();

        Arrays.sort(nextArr);

        Map<Character, List<Integer>> preMap = new HashMap<>();
        Map<Character, List<Integer>> nextMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            List<Integer> preList = preMap.getOrDefault(preArr[i], new ArrayList<>());
            List<Integer> nextList = nextMap.getOrDefault(nextArr[i], new ArrayList<>());

            preList.add(i);
            nextList.add(i);

            preMap.put(preArr[i], preList);
            nextMap.put(nextArr[i], nextList);
        }

        for (int i = length-1; i>=0; i--) {
            char temp = nextArr[n];
            builder.append(temp);
            n = nextMap.get(temp).indexOf(n);
            n = preMap.get(temp).get(n);
        }

        return builder.toString();
    }

}


//public class BurrowsWheeler {
//
//    public static BWT encode(String s) {
//
//        int L = s.length();
//        List<String> lst = IntStream.range(0,s.length())
//                .mapToObj( i -> s.substring(L-i,L) + s.substring(0,L-i) )
//                .sorted()
//                .collect(Collectors.toList());
//
//        return new BWT( lst.stream().map( ss -> ss.substring(L-1) ).collect(Collectors.joining()),
//                L==0 ? 0 : lst.indexOf(s) );
//    }
//
//
//    public static String decode(String s, int n) {
//
//        BWT[] arr = IntStream.range(0,s.length())
//                .mapToObj( i -> new BWT(""+s.charAt(i), i) )
//                .sorted(BurrowsWheeler::compareBWT)
//                .toArray(BWT[]::new);
//
//        StringBuilder out = new StringBuilder(s.length());
//        for (int i_=0 ; i_<s.length() ; i_++) {
//            BWT t = arr[n];
//            out.append(t.s);
//            n = t.n;
//        }
//        return out.toString();
//    }
//
//
//    private static int compareBWT(BWT a, BWT b) {
//        return a.s.equals(b.s) ? Integer.compare(a.n, b.n) : a.s.compareTo(b.s);
//    }
//}
