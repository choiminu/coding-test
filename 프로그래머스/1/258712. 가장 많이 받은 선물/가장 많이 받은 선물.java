import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> send = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        Map<String, Integer> nextMonthGifts = new HashMap<>();

        for (String friend : friends) {
            send.put(friend, new HashMap<>());
            giftScore.put(friend, 0);
            nextMonthGifts.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String from = parts[0];
            String to = parts[1];

            send.get(from).put(to, send.get(from).getOrDefault(to, 0) + 1);

            giftScore.put(from, giftScore.get(from) + 1);
            giftScore.put(to, giftScore.get(to) - 1);
        }

        for (String from : friends) {
            for (String to : friends) {
                if (from.equals(to)) continue;

                int fromTo = send.get(from).getOrDefault(to, 0);
                int toFrom = send.get(to).getOrDefault(from, 0);

                if (fromTo > toFrom) {
                    nextMonthGifts.put(from, nextMonthGifts.get(from) + 1);
                } else if (fromTo == toFrom && giftScore.get(from) > giftScore.get(to)) {
                    nextMonthGifts.put(from, nextMonthGifts.get(from) + 1);
                }
            }
        }

        int max = 0;
        for (int value : nextMonthGifts.values()) {
            max = Math.max(max, value);
        }

        return max;
    }
}
