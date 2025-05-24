import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            
            for (int j = 0; j < name.length; j++) {
                map.put(name[j], yearning[j]);
            }
            
            int result = 0;
            for (int j = 0; j < photo[i].length; j++) {
                result += map.getOrDefault(photo[i][j], 0);                
            }
            
            answer[i] = result;
            
        }
        
        return answer;
    }
}