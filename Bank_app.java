package m_bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class Bank_app {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/bank";
		String un="root";
		String pwd="************";
		Connection con=null;
		PreparedStatement pstm1=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, un, pwd);
			
			//login module
			Scanner s=new Scanner(System.in);
			System.out.println("******welcome to m_bank*******");
			System.out.println("Enter your account number:");
			int acc_num=s.nextInt();
			System.out.println("enter pin:");
			int pin=s.nextInt();
			
			pstm1=con.prepareStatement("select *from info where acc_num=? and pin=?");
			pstm1.setInt(1, acc_num);
			pstm1.setInt(2, pin);
			
			ResultSet res1=pstm1.executeQuery();
			
			res1.next();
			String name=res1.getString("name");
			int balance=res1.getInt("balance");
			System.out.println("welcome"+" "+name);
			System.out.println("Your account balance is: "+balance);
			
			//transaction module
			
			System.out.println("******Transcation details*******");
			System.out.println("Enter benificiary account number");
			int bacc_num=s.nextInt();
			System.out.println("Enter amount to be transfered");
			int tamount=s.nextInt();
			con.setAutoCommit(false);
			Savepoint sa=con.setSavepoint();
			PreparedStatement pstm2 = con.prepareStatement("update info set balance=balance-? where acc_num= ?");
			pstm2.setInt(1, tamount);
			pstm2.setInt(2, acc_num );
			pstm2.executeUpdate();
			System.out.println(name +" wants to send you "+tamount);
			System.out.println("please enter your choice(y/n)");
			String choice=s.next();
			if(choice.equals("y")) {
				PreparedStatement pstm3 = con.prepareStatement("update info set balance=balance + ? where acc_num= ?");
				pstm3.setInt(1, tamount);
				pstm3.setInt(2, bacc_num);
				pstm3.executeUpdate();
				PreparedStatement pstm4= con.prepareStatement("select *from info where acc_num= ?");
				pstm4.setInt(1,acc_num);
				
				ResultSet res=pstm4.executeQuery();
				res.next();
				System.out.println("your updated balance is "+ res.getInt(4));
			}
			else{
				con.rollback(sa);
				PreparedStatement pstm5= con.prepareStatement("select *from info where acc_num= ?");
				pstm5.setInt(1, acc_num);

				ResultSet res=pstm5.executeQuery();
				res.next();
				System.out.println("your existing balance is "+ res.getInt(4));
			}
			con.commit();
			
		} catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}

	}

}
