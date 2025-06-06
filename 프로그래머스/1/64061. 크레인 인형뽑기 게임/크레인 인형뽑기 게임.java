import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> basket = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
            int nx = moves[i] - 1;
            int ny = 0;
            
            while(board[ny][nx] == 0) {
                ny++;
                if (ny >= board.length) {
                    ny--;
                    break;
                };
            }
            
            if (board[ny][nx] != 0) {
                int doll = board[ny][nx];
                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(board[ny][nx]);
                }
                board[ny][nx] = 0;
            }
            
        }

        System.out.println(basket);
        
        return answer;
    }
}