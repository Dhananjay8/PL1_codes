import java.sql.*;
import java.util.Scanner;

public class ViewIndex
{
	static final String driver_name="com.mysql.jdbc.Driver";
	static final String url="jdbc:mysql://localhost:3306/new";
	static final String user="root";
	static final String passwd="root123";
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String str1,str2,str3,str4;
		boolean check=true;
		
		try
		{
			System.out.println("Registering Driver...");
			Class.forName(driver_name);
			System.out.println("Driver Registered!!");

			System.out.println("Connecting to the DataBase...");
			conn = DriverManager.getConnection(url,user,passwd);
			System.out.println("Connected!!");

			System.out.println("Creating Statement...");
			stmt = conn.createStatement();
			System.out.println("Statement Created!!");
			
			str1="create or replace view simpview as select city,phone from Offices";
			stmt.executeUpdate(str1);
			str2="select * from simpview";
			rs=stmt.executeQuery(str2);
			
			System.out.print("Office\t");
			System.out.print("Phone\t");
			System.out.println("\n");
			
			while(rs.next())
			{
				String str_city=rs.getString("city");
				String str_phone=rs.getString("phone");
				
				System.out.print(str_city+"\t");
				System.out.print(str_phone+"\t");
				System.out.println("\n");
			}
			
			System.out.println("\nSimple Index Created");
			stmt.executeUpdate("drop view simpview");
			
			str3="create index dex on Offices(sales)";
			stmt.executeUpdate(str3);
			str4="show index from Offices";
			rs=stmt.executeQuery(str4);
			
			System.out.print("Table\t");
			System.out.print("Non_unique\t");
			System.out.print("Key Name\t");
			System.out.print("Seq_in_index\t");
			System.out.println("\n");
			
			while(rs.next())
			{
				String str_1=rs.getString("Table");
				String str_2=rs.getString("Non_unique");
				String str_3=rs.getString("Key_name");
				String str_4=rs.getString("Seq_in_index");
				
				System.out.print(str_1+"\t");
				System.out.print(str_2+"\t");
				System.out.print(str_3+"\t");
				System.out.print(str_4+"\t");
				System.out.println("\n");
			}
			
			System.out.println("\nSimple Index created");
			stmt.executeUpdate("drop index dex on Offices");
	
		}//end try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException se)
			{
				
			}
			try
			{
				if(conn!=null){conn.close();}
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}//end finally
	}//end main
}//end class
