class Solution {
    public String solution(String s) {
        int[] alphabet = new int[26];

        for (char ch : s.toCharArray()) {
            alphabet[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 1) {
                sb.append((char)(i + 'a'));
            }
        }

        return sb.toString();
    }
}