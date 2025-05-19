class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        int minValue = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < minValue) {
                minValue = num;
            }
        }
        
        int size = arr.length - 1;
        
        if (size == 0) {
            return new int[] {-1};
        } else {
            answer = new int[size];
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (minValue != arr[i]) {
                    answer[index++] = arr[i];
                }
            }
        }
        
        return answer;
    }
}