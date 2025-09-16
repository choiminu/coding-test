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
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각 사람이 돈을 인출하는데 걸리는 시간을 오름차순으로 정렬
        Arrays.sort(arr);

        // 직전까지의 누적 대기 시간
        int prev = 0;

        // 전체 대기 시간 합
        int total = 0;

        for (int i = 0; i < N; i++) {

            // 현재 사람까지의 누적 시간
            prev += arr[i];

            // 전체 합계에 더하기
            total += prev;
        }

        sb.append(total);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

