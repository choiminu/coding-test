import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int up = in.nextInt();	
		int down = in.nextInt();
		int length = in.nextInt(); 
 
		int day = (length - down) / (up - down);
        
		if ((length - down) % (up - down) != 0) {
			day++;
		}
		System.out.println(day);
	}
}