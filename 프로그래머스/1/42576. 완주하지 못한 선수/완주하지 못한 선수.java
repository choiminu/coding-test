import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        for (String p : completion) {
            map.put(p, map.getOrDefault(p, 0) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer += key;
            }
        }
        
        
        return answer;
    }
}