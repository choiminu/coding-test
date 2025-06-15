import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            list.add(players[i]);
            map.put(players[i], i);
        }
        
        for (String calling : callings) {
            int cur = map.get(calling);
            int next = cur - 1;
            
            String frontPlayer = list.get(next);
            
            list.set(next, calling);
            list.set(cur, frontPlayer);
            
            map.put(calling, next);
            map.put(frontPlayer, cur);
            
        }
        
        return list.toArray(new String[0]);
    }
}