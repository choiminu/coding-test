class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int hit = 0;
        char[] arr = s.toCharArray();
        char first = s.charAt(0);
        
        for (int i = 0; i < arr.length; i++) {
            hit = first == arr[i] ? ++hit : --hit;
            if (hit == 0) {
                answer++;
                if (i + 1 < arr.length) {
                    first = arr[i + 1];
                }
            }
        }

        if (hit != 0) {
            answer++;
        }
        
        return answer;
    }
}