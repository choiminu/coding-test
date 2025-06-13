import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<Character, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            termsMap.put(temp[0].charAt(0), Integer.parseInt(temp[1]));
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int day = getTime(today);
        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            int exp = getTime(temp[0]) + ((termsMap.get(temp[1].charAt(0)) * 28)) - 1;
            if (day > exp) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    public int getTime(String date) {
        String[] temp = date.split("\\.");
        return (Integer.parseInt(temp[0]) * 336) + (Integer.parseInt(temp[1]) * 28) + Integer.parseInt(temp[2]);
    }
}