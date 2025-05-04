import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();

            if (input.length() == 1 && input.charAt(0) == '0') {
                break;
            }

            boolean flag = true;
            for (int i = 0; i < input.length() / 2; i++) {
                if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}