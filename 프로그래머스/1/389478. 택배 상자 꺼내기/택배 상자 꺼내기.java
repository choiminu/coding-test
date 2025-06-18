class Solution {
    public int solution(int n, int w, int num) {

        int row = (n + w - 1) / w;
        int[][] box = new int[row][w];

        int num1 = 1;
        boolean isLeft = true;

        for (int i = row - 1; i >= 0; i--) {
            if (isLeft) {
                for (int j = 0; j < w && num1 <= n; j++) {
                    box[i][j] = num1++;
                }
            } else {
                for (int j = w - 1; j >= 0 && num1 <= n; j--) {
                    box[i][j] = num1++;
                }
            }
            isLeft = !isLeft;
        }

        int cx = 0;
        int cy = 0;
        outer:
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == num) {
                    cx = j;
                    cy = i;
                    break outer;
                }
            }
        }

        int result = 1;
        while (cy > 0) {
            cy--;
            if (box[cy][cx] == 0) break;
            result++;
        }

        for (int[] arr : box) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

        return result;
    }
}
