class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int c = queries[i][2];
            
            int min = Integer.MAX_VALUE;
            while(left <= right) {
                if (arr[left] > c) {
                    min = Math.min(min, arr[left]);
                }
                left++;
            }
            
            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            answer[i] = min;
        }
        
        return answer;
    }
}