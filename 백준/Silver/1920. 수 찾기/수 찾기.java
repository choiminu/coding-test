import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(token.nextToken()), 1);
        }

        int M = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            System.out.println(map.getOrDefault(Integer.parseInt(token.nextToken()), 0));
        }

    }

}

