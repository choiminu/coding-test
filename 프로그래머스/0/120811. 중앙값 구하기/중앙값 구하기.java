import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        return Arrays.stream(array).sorted().skip(array.length / 2).findFirst().getAsInt();
    }
}