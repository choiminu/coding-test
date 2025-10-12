import java.util.Arrays;

class Solution {
    public String[] solution(String[] str_list) {
        int left = -1;
        int right = -1;

        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l") && left == -1) {
                left = i;
            }
            if (str_list[i].equals("r") && right == -1) {
                right = i;
            }
        }

        if (left == -1 && right == -1) {
            return new String[]{};
        }
        
        if (right == -1 || (left != -1 && left < right)) {
            return Arrays.copyOfRange(str_list, 0, left);
        } else {
            return Arrays.copyOfRange(str_list, right + 1, str_list.length);
        }
    }
}
