class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        for (int y = 0; y < arr1.length; y++) {
            for (int x = 0; x < arr1[0].length; x++) {
                answer[y][x] = arr1[y][x] + arr2[y][x];
            }
        }
        
        return answer;
    }
}