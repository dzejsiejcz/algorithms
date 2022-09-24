import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDiffBetterSolution {


    public static int[] arrayDiff(int[] a, int[] b) {


//        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
//        List<Integer> listB = Arrays.stream(b).boxed().toList();
//
//        listA.removeAll(listB);
//
//        listA.forEach(System.out::println);

        //return listA.stream().mapToInt(value -> value).toArray();

boolean eb = "a"=="a" && 4>5 || 6>1;
final String s1 = "a";
String s2 = "a";
    List<String> test = new ArrayList<>(Arrays.asList("aa", "df"));


        return IntStream.of(a).filter(aa -> IntStream.of(b).noneMatch(bb -> bb==aa)).toArray();
    }
    public static void test() {
        System.out.println("");

    }
}

