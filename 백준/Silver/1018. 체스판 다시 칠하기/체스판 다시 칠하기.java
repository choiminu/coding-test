import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 체스판을 색칠해야하는 패턴을 담은 배열 선언
        String[] board = {"WBWBWBWB", "BWBWBWBW"};

        // 사용자에게 체스판의 크기를 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 사용자에게 체스판의 색깔을 입력받아 저장한다.
        char[][] chessBoard = new char[M][N];
        for (int i = 0; i < M; i++) {
            chessBoard[i] = br.readLine().toCharArray();
        }

        // 체스판을 칠한 최소값을 저장할 변수 선언
        int result = Integer.MAX_VALUE;

        // 색칠해야할 체스판은 8 * 8 크기 이므로 M - 8번 반복
        for (int i = 0; i <= M - 8; i++) {
            // 색칠해야할 체스판은 8 * 8 크기 이므로 N - 8 번 반복
            for (int j = 0; j <= N - 8; j++) {

                // 흰색으로 칠할 체스판의 수를 저장할 변수 선언
                int repaintW = 0;

                // i ~ i + 8 번 반복
                for (int k = i; k < i + 8; k++) {
                    // j ~ j + 8 번 반복
                    for (int n = j; n < j + 8; n++) {

                        // 부분 보드 기준의 상대 위치
                        int rr = k - i;
                        int cc = n - j;

                        char expected = ((rr + cc) % 2 == 0) ? 'W' : 'B';
                        if (chessBoard[k][n] != expected) repaintW++;
                    }
                }
                int repaintB = 64 - repaintW;
                result = Math.min(result, Math.min(repaintW, repaintB));
            }
        }

        System.out.println(result);

        br.close();
        bw.flush();
        bw.close();
    }

}

