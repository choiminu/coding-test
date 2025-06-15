import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String call : callings) {
            int index = map.get(call);
            
            String frontPlayer = players[index - 1];
            players[index - 1] = players[index];
            players[index] = frontPlayer;
            
            map.put(call, index - 1);
            map.put(frontPlayer, index);
        }
        
        return players;
    }
}