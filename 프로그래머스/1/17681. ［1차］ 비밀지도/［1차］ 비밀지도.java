import java.util.Arrays;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            
            String binary1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String binary2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            
            for (int j = 0; j < binary1.length(); j++) {
                int key = (binary1.charAt(j) - '0') + (binary2.charAt(j) - '0');
                if (key > 0) {
                    map[i][j] = 1;
                }
            }
            
            System.out.println(Arrays.toString(map[i]));   
        }
        
        for (int i = 0; i < map.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            
            answer[i] = sb.toString();
        }
        
        
        
        
        return answer;
    }
}