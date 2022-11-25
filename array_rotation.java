import java.util.*;
public class array_rotation {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter no of elements in array");
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i]=s.nextInt();
		}
		int rotations=s.nextInt();
		while(rotations>0) {
			int first=arr[arr.length-1];
			for(int i=arr.length-1;i>0;i--) {
				arr[i]=arr[i-1];
			}
			arr[0]=first;
			rotations--;
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
