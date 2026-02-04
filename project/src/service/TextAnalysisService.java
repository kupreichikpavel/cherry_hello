package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
}
