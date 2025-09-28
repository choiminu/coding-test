import java.util.Arrays;
class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum();
        int product = Arrays.stream(num_list).reduce(1, (i1, i2) -> i1 * i2);
        return product > sum * sum ? 0 : 1; 
    }
}