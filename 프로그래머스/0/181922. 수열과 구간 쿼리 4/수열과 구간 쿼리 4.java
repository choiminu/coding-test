class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            if (k == 0) continue;

            for (int idx = s; idx <= e; idx++) {
                if (idx % k == 0) {
                    arr[idx]++;
                }
            }
        }
        return arr;
    }
}
