import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] round = new int[3];
        int currentRound = 0;
        
        
        String score = "";
        for (char ch : dartResult.toCharArray()) {
            if (Character.isDigit(ch)) {
                score += ch;
            } else {
                if (!score.isEmpty()) {
                    round[currentRound++] = Integer.parseInt(score);
                    score = "";
                }
                
                if (ch == 'S' || ch == 'D' || ch == 'T') {
                    if (ch == 'S') round[currentRound - 1] = (int) Math.pow(round[currentRound - 1], 1);
                    if (ch == 'D') round[currentRound - 1] = (int) Math.pow(round[currentRound - 1], 2);
                    if (ch == 'T') round[currentRound - 1] = (int) Math.pow(round[currentRound - 1], 3);
                }
                
                if (ch == '*' || ch == '#') {
                    if (ch == '*') {
                        if (currentRound == 1) {
                            round[currentRound - 1] *= 2;
                        } else {
                            round[currentRound - 1] *= 2;
                            round[currentRound - 2] *= 2;
                        }
                    }
                    if (ch == '#') {
                        round[currentRound - 1] = -round[currentRound - 1];
                    }
                }
            }
        }
        
        for (int r : round) {
            answer += r;
        }
        
        
        return answer;
    }
}