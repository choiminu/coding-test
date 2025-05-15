class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        int[] temp = new int[max + 1];
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                temp[arr[i]] = 1;
                size++;                
            }
        }
        
        if (size == 0) {
            return new int[] {-1};
        }
        
        int index = 0;
        int[] answer = new int[size];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                answer[index++] = i;
            }
        }
        return answer;
    }
}