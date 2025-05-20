import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] numbers, int target) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);

            for (int i = 0; i < numbers.length; i++) {
                int size = queue.size();

                for (int j = 0; j < size; j++) {
                    Integer sum = queue.poll();
                    queue.offer(sum + numbers[i]);
                    queue.offer(sum - numbers[i]);
                }
            }
        
            while(!queue.isEmpty()) {
                int num = queue.poll();
                if (num == target) answer++;
            }

            return answer;
    }
}