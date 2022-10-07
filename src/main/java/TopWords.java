import java.text.Collator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;


public class TopWords {

    public static List<String> top3(String s) {

        String[] list = s.toLowerCase().split("[^a-zA-Z0-9']+");
        Arrays.sort(list);
        Map<String, Integer> counterMap = new LinkedHashMap<>();

        for (String word : list) {
            System.out.println("word: " + word);

            if (word.matches(".*[a-zA-Z]+.*")) {
                if (counterMap.containsKey(word)) {
                    counterMap.put(word, counterMap.get(word) + 1);
                } else {
                    counterMap.put(word, 1);
                }
            }
        }

        Map<String, Integer> resultNew = counterMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return new ArrayList<>(resultNew.keySet());
    }

    public static List<String> top33(String s) {
        return Arrays.stream(s.toLowerCase().split("[^a-z*|']"))
                .filter(o -> !o.isEmpty() && !o.replace("'", "").isEmpty())
                .collect(groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());
    }
}