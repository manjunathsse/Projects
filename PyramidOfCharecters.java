import java.util.Scanner;
public class PyramidOfCharecters {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of rows");
		int n=s.nextInt();
		int a=97;
		for(int i=0;i<n;i++) {
			a=97;
			for(int j=0;j<i+1;j++) {
				System.out.print((char)a);
				a++;
			}
			System.out.println();
		}
	}
}
