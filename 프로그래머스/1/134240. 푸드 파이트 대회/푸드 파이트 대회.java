class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder player = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int amount = food[i] / 2;
            player.append(String.valueOf(i).repeat(amount));
        }

        answer = player.toString() + "0" + player.reverse().toString();
        
        return answer;
    }
}