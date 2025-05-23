import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int row = 0; row < commands.length; row++) {
            
            int i = commands[row][0];
            int j = commands[row][1];
            int k = commands[row][2];
            
            int[] temp = new int[j - i + 1];
            for (int index = 0; i <= j; i++, index++) {
                temp[index] = array[i - 1];
            }
            
            Arrays.sort(temp);

            answer[row] = temp[k - 1];
        
        }
        
        return answer;
    }
}