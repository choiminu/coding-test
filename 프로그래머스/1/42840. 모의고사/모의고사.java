import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] std = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < std.length; j++) {
                if (answers[i] == std[j][i % std[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
