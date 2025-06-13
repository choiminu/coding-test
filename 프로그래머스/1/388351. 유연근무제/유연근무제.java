class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int schedule = ((schedules[i] / 100) * 3600) + ((schedules[i] % 100) * 60) + 600;
            boolean isLate = false;
            int day = (startday - 1) % 7;
            
            for (int j = 0; j < timelogs[i].length; j++) {
                int timeLog = ((timelogs[i][j] / 100) * 3600) + ((timelogs[i][j] % 100) * 60);
             
                if (isLate) {
                    break;
                }
                
                if (day == 5 || day == 6) {
                    day = (day + 1) % 7;
                    continue;
                } else if (schedule >= timeLog) {
                    day = (day + 1) % 7;
                    continue;
                } else {
                    isLate = true;
                }
            }
            
            if (!isLate) {
                answer++;
            }
            
        }
        
        return answer;
    }
}