import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       bw.write("|\\_/|\n"
               + "|q p|   /}\n"
               + "( 0 )\"\"\"\\\n"
               + "|\"^\"`    |\n"
               + "||_/=\\\\__|");

        br.close();
        bw.flush();
        bw.close();
    }
}

