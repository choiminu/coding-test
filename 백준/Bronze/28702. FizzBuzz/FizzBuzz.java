import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Predicate<String> p = s -> {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        int prev = 0;
        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            if (p.test(input)) {
                prev = Integer.parseInt(input);
            } else {
                if (prev != 0) {
                    prev++;
                }
            }
        }

        prev++;

        if (prev % 3 == 0 && prev % 5 == 0) {
            bw.write("FizzBuzz");
        } else if (prev % 3 == 0) {
            bw.write("Fizz");
        } else if (prev % 5 == 0) {
            bw.write("Buzz");
        } else {
            bw.write(prev+"");
        }

        br.close();
        bw.flush();
        bw.close();
    }


}

