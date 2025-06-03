import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for (String str : completion) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                if (map.get(participant[i]) - 1 <= 0) {
                    map.remove(participant[i]);
                } else {
                    map.put(participant[i], map.getOrDefault(participant[i], 0) - 1);
                }
                participant[i] = "";
            }
        }
        
        
        for (String str : participant) {
            answer += str.trim();
        }
        
        
        return answer;
    }
}