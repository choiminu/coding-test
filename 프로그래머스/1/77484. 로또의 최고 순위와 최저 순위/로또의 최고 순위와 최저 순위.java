class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int hit = 0;
        int zero = 0;
            
        for (int i = 0; i < lottos.length; i++) {
            int number = lottos[i];
            
            for (int j = 0; j < win_nums.length; j++) {
                if (number == win_nums[j]) hit++;
            }
            
            if (number == 0) zero++;
        }
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        answer[0] = rank[hit + zero];
        answer[1] = rank[hit];
        
        return answer;
    }
}