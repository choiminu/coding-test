import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, String> map = new HashMap<>();

        map.put('M', "MatKor");
        map.put('W', "WiCys");
        map.put('C', "CyKor");
        map.put('A', "AlKor");
        map.put('$', "$clear");

        bw.write(map.get(br.readLine().charAt(0)));

        br.close();
        bw.flush();
        br.close();
    }

}
