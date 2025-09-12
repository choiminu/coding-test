import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사용자에게 N장의 카드를 입력받는다.
        int N = Integer.parseInt(br.readLine());

        // FIFO 구조를 갖는 자료구조 큐 선언 후 1부터 N 까지의 값을 저장한다.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        // 남은 카드가 한 장이라면 종료
        while (q.size() > 1) {

            // 제일 위에 있는 카드를 버린다.
            q.poll();

            // 제일 위에 있는 카드를 맨 아래로 보낸다.
            q.offer(q.poll());

        }

        bw.write(q.poll() + "");

        br.close();
        bw.flush();
        bw.close();
    }

}

