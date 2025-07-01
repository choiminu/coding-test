import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int Ycount = 0;
		int countV = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
				countV++;
			}
			
			if(s.charAt(i) == 'y') {
				Ycount++;
			}
		}
		
		System.out.println(countV + " " + (countV + Ycount));
		sc.close();
	}
}