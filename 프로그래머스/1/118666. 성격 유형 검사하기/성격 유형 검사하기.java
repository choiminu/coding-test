import java.util.Map;
import java.util.HashMap;

class Solution {
    private static final char[] MBTI = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    private static final int[] SCORE = {0,3,2,1,0,1,2,3};
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> scores = new HashMap<>();
        for (char ch : MBTI) {
           scores.put(ch, 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            int index = choice < 4 ? 0 : 1;
            if (choice == 4) continue;
            scores.put(survey[i].charAt(index), scores.getOrDefault(survey[i].charAt(index), 0) + SCORE[choice]);
        }
        
        for (int i = 0; i < MBTI.length; i += 2) {
            if (scores.get(MBTI[i]) > scores.get(MBTI[i + 1])) {
                answer += MBTI[i];
            } else if (scores.get(MBTI[i]) < scores.get(MBTI[i + 1])){
                answer += MBTI[i + 1];
            } else {
                answer += MBTI[i];
            }
        }
        
        
        
        return answer;
    }
}