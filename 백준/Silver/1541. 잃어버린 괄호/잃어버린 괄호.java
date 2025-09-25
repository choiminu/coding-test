import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 최소값을 만들려면 가장 큰 값을 빼줘야 한다.
        String[] input = br.readLine().split("-");

        int answer = 0;

        // 첫번쨰 그룹 처리
        String[] firstGroup = input[0].split("\\+");
        for (String s : firstGroup) {
            answer += Integer.parseInt(s);
        }

        // 나머지 그룹 처리
        for (int i = 1; i < input.length; i++) {
            String[] group = input[i].split("\\+");
            for (String s : group) {
                answer -= Integer.parseInt(s);
            }
        }

        System.out.println(answer);

        br.close();
        bw.flush();
        bw.close();
    }

}
