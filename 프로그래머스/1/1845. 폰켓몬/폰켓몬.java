import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int pick = nums.length / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int p : nums) {
            map.put(p, 1);
        }
        
        if (map.size() > pick) {
            answer = pick;
        } else {
            answer = map.size();    
        }
        
        return answer;
    }
}