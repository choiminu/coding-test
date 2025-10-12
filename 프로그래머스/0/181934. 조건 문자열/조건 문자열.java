import java.util.function.Function;
class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        
        Function<String, Boolean> func = str -> {
            if (str.equals(">=")) {
                return n >= m;
            }
            
            if (str.equals("<=")) {
                return n <= m;
            }
            
            if (str.equals(">!")) {
                return n > m;
            }
            
            if (str.equals("<!")) {
                return n < m;
            }
            
            return false;
        };

        return func.apply(ineq + eq) ? 1 : 0;
    }
}