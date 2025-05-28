import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        List<Double[]> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            
            int challenger = 0;
            int notClear = 0;
            
            for (int stage : stages) {
                if (i <= stage) {
                    if (i == stage) notClear++;
                    challenger++;
                }
            }
            
            result.add(new Double[] {
                (double) i,
                (challenger == 0) ? 0.0 : (double) notClear / challenger
            });

        }
        
        result.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0].compareTo(o2[0]);
            }
            return o2[1].compareTo(o1[1]);
        });
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i)[0].intValue();
        }
        
        return answer;
    }
}