package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static consts.Consts.COUNT_OF_TOP_MATCH;


public class TextAnalysisService {

    public Map<String, Integer> getMostPopularWords(List<String> list) {
        SignsService signsService = new SignsService();
        Map<String, Integer> result = new HashMap<>();

        for (String line : list) {
            StringBuilder stringBuilder = new StringBuilder();

            for (char c : line.toCharArray()) {
                if (signsService.isAlphabetSymbol(c)) {
                    stringBuilder.append(Character.toLowerCase(c));
                } else {
                    if (!stringBuilder.isEmpty()) {
                        String cur = stringBuilder.toString();
                        result.put(cur, result.getOrDefault(cur, 0) + 1);
                        stringBuilder.setLength(0);
                    }
                }
            }
            if (!stringBuilder.isEmpty()) {
                String cur = stringBuilder.toString();
                result.put(cur, result.getOrDefault(cur, 0) + 1);
            }
        }
        return result;
    }

    public int compareMaps(Map<String, Integer> cryptPopularWords, Map<String, Integer> exampleWords) {
        int mathes = 0;
        for (Map.Entry<String, Integer> entry : cryptPopularWords.entrySet()) {
            String cur = entry.getKey();
            int count = entry.getValue();
            if (count >= 2 && cur.length() >= 4) {
                Integer exampleCount = exampleWords.get(cur);
                if (exampleCount != null && exampleCount >= 2) {
                    mathes++;
                }
            }
        }
        return mathes;
    }

    public Map<Character, Integer> getStatsAfterDotSpace(List<String> lines) {
        SignsService signsService = new SignsService();
        Map<Character, Integer> stats = new HashMap<>();
        for (String line : lines) {
            for (int i = 0; i + 2 < line.length(); i++) {
                if (line.charAt(i) == '.' && line.charAt(i + 1) == ' ') {
                    char next = line.charAt(i + 2);
                    if (signsService.isAlphabetSymbol(next)) {
                        next = Character.toLowerCase(next);
                        stats.put(next, stats.getOrDefault(next, 0) + 1);
                    }
                }
            }
        }
        return stats;
    }

    public int topMatch(Map<Character, Integer> a,
                        Map<Character, Integer> b) {

        Set<Character> topA = selectTopMatches(a);
        Set<Character> topB = selectTopMatches(b);
        topA.retainAll(topB);
        return topA.size();
    }

    private Set<Character> selectTopMatches(Map<Character, Integer> map) {
        return map.entrySet().stream()
                .sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
                .limit(COUNT_OF_TOP_MATCH)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}