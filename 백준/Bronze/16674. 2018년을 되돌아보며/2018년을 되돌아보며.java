import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        if (!str.matches("[2018]+")) {
            sb.append(0);
            System.out.println(sb.toString());
            return;
        }

        boolean contains2 = str.contains("2");
        boolean contains0 = str.contains("0");
        boolean contains1 = str.contains("1");
        boolean contains8 = str.contains("8");

        if (!(contains2 && contains0 && contains1 && contains8)) {
            sb.append(1);
            System.out.println(sb.toString());
            return;
        }

        int count2 = 0;
        int count0 = 0;
        int count1 = 0;
        int count8 = 0;

        for (char c : str.toCharArray()) {
            if (c == '2') count2++;
            else if (c == '0') count0++;
            else if (c == '1') count1++;
            else if (c == '8') count8++;
        }

        if (count2 == count0 && count0 == count1 && count1 == count8) {
            sb.append(8);
        } else {
            sb.append(2);
        }

        System.out.println(sb.toString());
    }
}