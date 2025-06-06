import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
    
        List<int[]> list = new ArrayList<>();
        Map<String, Integer> extMap = new HashMap<>();
        extMap.put("code", 0);
        extMap.put("date", 1);
        extMap.put("maximum", 2);
        extMap.put("remain", 3);


        int extIndex = extMap.get(ext);        
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][extIndex] < val_ext) {
                list.add(data[i]);
            }
        }
        
        int sortIndex = extMap.get(sort_by);
        Collections.sort(list, (o1, o2) -> {
            return Integer.compare(o1[sortIndex], o2[sortIndex]);
        });

        answer = new int[list.size()][4];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}