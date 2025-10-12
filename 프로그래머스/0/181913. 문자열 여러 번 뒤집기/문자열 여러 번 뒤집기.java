class Solution {
    public String solution(String my_string, int[][] queries) {
        
        char[] chars = my_string.toCharArray();
        
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}