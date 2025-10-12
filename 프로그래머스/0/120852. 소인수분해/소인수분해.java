import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        
        for (int i = 2; i <= n; i++) {
            
            if (isNotPrime[i]) {
                continue;
            }
            
            for (int j = i + i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i] && n % i == 0) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}