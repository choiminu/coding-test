import java.util.stream.*;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String rsp) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "0");
        map.put('0', "5");
        map.put('5', "2");
        
        return rsp.chars().mapToObj(ch -> map.get((char)ch)).collect(Collectors.joining());
    }
}