import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.function.BiFunction;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        BiFunction<Integer, Integer, Integer> getGcd = (num1, num2) -> {
            while (num2 != 0) {
                int temp = num2;
                num2 = num1 % num2;
                num1 = temp;
            }
            return num1;
        };

        Integer gcd = getGcd.apply(x, y);

        System.out.println(gcd);
        System.out.println(gcd * (x / gcd) * (y / gcd));

        br.close();
        bw.flush();
        bw.close();
    }

    @FunctionalInterface
    static interface Procedure {
        int run(int x, int y);
    }
}

