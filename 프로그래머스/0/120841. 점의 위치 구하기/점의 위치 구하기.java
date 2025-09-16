import java.util.function.BinaryOperator;
class Solution {
    public int solution(int[] dot) {
        
        BinaryOperator<Integer> find = (x, y) -> {
            if (x > 0 && y > 0) return 1;
            if (x < 0 && y > 0) return 2;
            if (x < 0 && y < 0) return 3;
            return 4;
        };
        
        int answer = find.apply(dot[0], dot[1]);
        return answer;
    }
}