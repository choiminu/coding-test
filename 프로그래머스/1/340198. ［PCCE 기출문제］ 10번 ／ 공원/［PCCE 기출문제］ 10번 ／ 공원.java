class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        for (int mat : mats) {
            for (int row = 0; row <= park.length - mat; row++) {
                for (int col = 0; col <= park[row].length - mat; col++) {
                    boolean isLaydown = true;
                    
                    for (int i = row; i < row + mat; i++) {
                        for (int j = col; j < col + mat; j++) {
                            if (!park[i][j].equals("-1")) {
                                isLaydown = false;
                                break;
                            }
                        }
                        if (!isLaydown) break;
                    }
                    
                    if (isLaydown) {
                        answer = Math.max(answer, mat);
                    }
                }
            }
        }
        
        return answer;
    }
}