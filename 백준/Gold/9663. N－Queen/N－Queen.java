import java.io.*;

public class Main {

    static int N;
    static int result;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        dfs(0);

        bw.write(result + "");

        br.close();
        bw.flush();
        br.close();
    }

    public static void dfs(int row) {

        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (canPlace(col, row)) {
                board[row][col] = 1;
                dfs(row + 1);
                board[row][col] = 0;
            }
        }

    }

    private static boolean canPlace(int col, int row) {

        // 같은 열에 퀸이 있는지 확인
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // 왼쪽 위 대각선 확인
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 오른쪽 위 대각선 확인
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;

    }

}
