import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        boolean[] isReserveUsed = new boolean[reserve.length];
        boolean[] isLostHandled = new boolean[lost.length];

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    isReserveUsed[j] = true;
                    isLostHandled[i] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (isLostHandled[i]) continue;

            for (int j = 0; j < reserve.length; j++) {
                if (isReserveUsed[j]) continue;

                if (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    isReserveUsed[j] = true;
                    isLostHandled[i] = true;
                    break;
                }
            }
        }

        int count = 0;
        for (boolean handled : isLostHandled) {
            if (handled) count++;
        }

        return n - (lost.length - count);
    }
}
