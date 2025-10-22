import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands).mapToInt(cmd -> Arrays.stream(array, cmd[0] - 1, cmd[1]).sorted().skip(cmd[2] - 1).findFirst().getAsInt()).toArray();
    }
    
}