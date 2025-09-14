import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.IntSupplier;

public class Main {

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T --> 0) {
            q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int index = 0;
            while (!q.isEmpty()) {

                // 저장된 문서의 맨 앞에 있는 문서를 꺼낸다.
                int[] cur = q.poll();

                // 현재 문서의 우선순위가 가장 높은지 확인하는 변수
                boolean isFirst = true;

                // 문서를 순회하면서 현재 문서보다 우선순위가 더 높은 문서가 있는지 확인한다.
                for (int[] next : q) {
                    // 우선순위가 더 높은 문서가 있다면 isFirst 변수의 값을 false로 설정하고 반복문 종료
                    if (cur[1] < next[1]) {
                        isFirst = false;
                        break;
                    }
                }

                // 현재 문서가 우선순위가 가장 높다면?
                if (isFirst) {
                    index++;
                    // 만약 몇 번쨰로 인쇄되었는지 궁금한 문서의 인덱스와 현재 문서의 인덱스가 같은 경우 출력 후 종료
                    if (cur[0] == M) {
                        sb.append(index).append("\n");
                        break;
                    }
                } else {
                    // 현재 문서보다 우선순위가 더 높은 문서가 존재한다면 문서의 맨뒤로 이동
                    q.offer(cur);
                }
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}

