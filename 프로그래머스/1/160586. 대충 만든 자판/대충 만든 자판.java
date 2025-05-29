import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        int[] key = new int[26];
        for (int i = 0; i < key.length; i++) {
            key[i] = 99;
        }
        
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                int index = keymap[i].charAt(j) - 'A';
                key[index] = Math.min(key[index], j + 1);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            
            for (char ch : targets[i].toCharArray()) {
                if (key[ch - 'A'] != 99) {
                    sum += key[ch - 'A'];
                } else {
                    sum = -1;
                    break;
                }
            }
            
            if (sum != -1) {
                answer[i] = sum;
            } else {
                answer[i] = -1;
            }
        }
        
        
        return answer;
    }
}