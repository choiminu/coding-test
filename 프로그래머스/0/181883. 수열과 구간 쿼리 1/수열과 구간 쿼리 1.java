class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            for (; left <= right; left++) {
                arr[left]++;
            }
        }
        return arr;
    }
}