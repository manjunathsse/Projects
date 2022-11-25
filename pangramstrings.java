import java.util.Scanner;
public class pangramstrings {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
		str=str.toLowerCase();
		boolean mark[]=new boolean[26];
		boolean b=false;
		int index=0;
		for(int i=0;i<str.length();i++) {
			if('a'<=str.charAt(i) && 'z'>=str.charAt(i)) {
				index=str.charAt(i)-'a';
			}
			mark[index]=true;
			
		}
		for(int i=0;i<26;i++) {
			if(mark[i]==true) {
				b=true;
			}
			else {
				b=false;
				break;
			}
		}
		if(b==true) {
			System.out.println("Pangram string");
		}
		else {
			System.out.println("not a pangram string");
		}
	}

}
