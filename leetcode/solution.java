import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Solution {
    public static void main(String[] args) {
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words1, 2));

        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.print(topKFrequent(words2, 4));
    }


    public static List<String> topKFrequent(String[] words, int k) {
        return Stream.of(words)
                .sorted()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(word -> word.getKey())
                .limit(k)
                .collect(Collectors.toList());
    }
}
