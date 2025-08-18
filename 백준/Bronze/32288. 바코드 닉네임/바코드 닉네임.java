import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		String s = sc.next();
		String newS = "";
		
		for(int i = 0; i < a; i++) {
			if(s.charAt(i) == 'I') {
				newS += 'i';
			}else if(s.charAt(i) == 'l') {
				newS += 'L';
			}
		}
		
		System.out.println(newS);
		sc.close();
	}
}