package com.cgpa.Connector;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Please enter your name");
		String name=s.next();
		try {
			System.out.println("Enter number of subjects passed?");
			int subjects=s.nextInt();
			System.out.println("Hii"+" "+name+" "+"is every subject you completed is 4 credit subject(Y/N)");
			String option=s.next();
			if(option.equals("y") || option.equals("Y")) {
				CGPA c=new CGPA();
				System.out.println(c.cgpa(subjects));
			}
			else if(option.equals("N") || option.equals("n")){
				CGPA1 c=new CGPA1();
				System.out.println(c.cgpa1(subjects));
			}
		}
		catch(Exception e) {
			System.out.println("Please enter valid input");
		}
		

	}
}
	
class Grade{	
	public static int grade() {
		Scanner s=new Scanner(System.in);
		String ch=s.next();
		int gradePoint=0;
		if(ch.equals("s") || ch.equals("S")) {
			gradePoint=10;
		}
		else if(ch.equals("a") || ch.equals("A")) {
			gradePoint=9;
		}
		else if(ch.equals("b") || ch.equals("B")) {
			gradePoint=8;
		}
		else if(ch.equals("c") || ch.equals("C")) {
			gradePoint=7;
		}
		else if(ch.equals("d") || ch.equals("D")) {
			gradePoint=6;
		}		
		else if(ch.equals("e") || ch.equals("E")) {
			gradePoint=5;
		}
		return gradePoint;
	}
}


class CGPA{
		
	public static double cgpa(int subjects) {
		int credits=subjects*4;
		Grade g=new Grade();
		int gradePoits=0;
		System.out.println("Please enter the grade");
		for(int i=0;i<subjects;i++) {
			gradePoits+=g.grade()*4;
		}
		return (double)gradePoits/credits;
	}
}

class CGPA1{
	
	public static double cgpa1(int subjects) {
		Scanner s=new Scanner(System.in);
		System.out.println("Please enter respective grade and credits");
		Grade g=new Grade();
		int credits=0;
		int gradePoits=0;
		for(int i=0;i<subjects;i++) {
			gradePoits+=g.grade()*credits;
			credits+=s.nextInt();
		}
		return (double)gradePoits/credits;
	}
}
