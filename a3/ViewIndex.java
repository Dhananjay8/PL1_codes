//Dhananjay Patil(3152)

//STEP 1. Import required packages
import java.sql.*;		//javax.sql package provides Connection pooling functionalities
import java.util.Scanner;	

public class ViewIndex{
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  	//no need of this
   static final String DB_URL = "jdbc:mysql://localhost:3306/pl1";	//JDBC protocol to specify connection;this URL has form "jdbc:<subprotocol>:<otherparameters>"

   //  Database credentials (to pass as arguments to "DriverManager.getConnection" method)
   static final String USER = "root";
   static final String PASS = "root123";
   
   public static void main(String[] args){
	Scanner Sc=new Scanner(System.in);
   	Connection conn = null;		//to create object of connection class
   	Statement stmt = null;		//to create object of statement class
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");	//to explicitly load JDBC driver

	//static method forName in the "Class" class returns java class as specified in the argument string and executes its static static constructor;this static constructor of dynamically loaded class loads instance of the "Driver" class;which registers itself with the "DriverManager" class 

      //STEP 3: Open a connection(by connecting to data source through creation of "Connection" object)
      System.out.println("Connecting to database...");
       conn = DriverManager.getConnection(DB_URL,USER,PASS);	//DriverManager class has getConnection method & 'conn' is the connection object

      //STEP 4: Execute a query
      System.out.println("Creating statement...");

      stmt = conn.createStatement();		//createStatement method creates actual query statemet
      
	ResultSet rs= null;				//executeQuery(of Statement class) returns ResultSet object
	
      String sql;
      boolean b=true;
      while(b==true)
      {
      	System.out.println("Lets look into 1. Views 2. Indexes 3.Exit");
      	System.out.println("Enter Your Choice");

      	int a=Sc.nextInt();
      
      	if(a==1)
      {
    	  System.out.println("Lets look into 1. Simple View 2. Composite/Compound View ");
          System.out.println("Enter Your Choice");
          int c=Sc.nextInt();
          if(c==1)
          {
      //View:Simple
      System.out.println("Simple View Example");
      System.out.println("create or replace view Customers1 as select company,custid from Customers");
      String sql4;
      sql4= "create or replace view Customers1 as select company,custid from Customers";
      stmt.executeUpdate(sql4);		//Statement.executeUpdate returns integer indicating number of rows the SQL statement modified
      String sql5;
      sql5= "select * from Customers1";
      rs = stmt.executeQuery(sql5);	//Statement.executeQuery returns data(ResultSet object) corresponding to the SQL statement(just like SELECT in query)

      //STEP 5: Extract data from result set
      System.out.print("Customers"+"\t");
      System.out.println("Customers"+"\t"); 
      System.out.println("------------------------------------------------------------");
      
      while(rs.next()){
         //Retrieve by column name
         String rn = rs.getString("company");
         String  hn= rs.getString("custid");

         //Display values

         System.out.print(rn+" \t");
         System.out.println(hn+" \t");
      }
          }
      if(c==2)
      {
      //View:Compound
      System.out.println("Compound View Example");
      String sql6;
      sql6= "create or replace view hello1 as select r.productname,r.qty,o.city,o.target from Offices as o,Orders as r where o.Officeid=r.Orderno";
      stmt.executeUpdate(sql6);
      String sql7;
      sql7= "select * from hello1";
      rs = stmt.executeQuery(sql7);

      //STEP 5: Extract data from result set
      System.out.print("Product Name"+"\t"); 
      System.out.print("Qty"+"\t");
      System.out.print("City"+"\t");
      System.out.println("Target"+"\t"); 
      System.out.println("------------------------------------------------------------");
      
      while(rs.next()){
         //Retrieve by column name
         String  hn1= rs.getString("Product Name");
         String  hn2= rs.getString("Qty");
         String rn = rs.getString("City");
         String  hn= rs.getString("Target");

         //Display values

         System.out.print(hn1+" \t");
         System.out.print(hn2+" \t");
         System.out.print(rn+" \t");
         System.out.println(hn+" \t");
      }
      }
      }
      
      if(a==2)
      {
    	  //Index
    	  System.out.println("Lets look into 1. Simple Index 2. Unique Index 3. Composite Index 4. Fulltext Index");
          System.out.println("Enter Your Choice");
          int c=Sc.nextInt();
          
          if(c==1){
      //Simple Index
      System.out.println("Simple Index");
      System.out.println("create index id11 on Salesreps(name);");
      String sql8;
      sql8= "create index id11 on Salesreps(name)";
      stmt.executeUpdate(sql8);
      System.out.println("show index from Salesreps");
      String sql11;
      sql11= "show index from Salesreps";
      ResultSet rs1= stmt.executeQuery(sql11);
		System.out.print("Table"+"\t");
		System.out.print("Non_unique" + "\t"); 
		System.out.print("Key_name " +"\t");
		System.out.print("Seq_in_index"+"\t");
		System.out.print("Column_name : " +"\t");
		System.out.print("Collation " +"\t");
		System.out.print("Cardinality"+"\t");
		System.out.print("Sub_part" + "\t");
		System.out.println("Index_type"+"\t");

      System.out.println("------------------------------------------------------------");
      
      while(rs1.next()){
			String tblname = rs1.getString("Table");
			int nonuni = rs1.getInt("Non_unique");
			String keyname = rs1.getString("Key_name");
			int seq = rs1.getInt("Seq_in_index");
			String col = rs1.getString("Column_name");
			String col1 = rs1.getString("Collation");
			String sub = rs1.getString("Sub_part");
			int car = rs1.getInt("Cardinality");
			String ind = rs1.getString("Index_type");
			
			System.out.print(tblname+" \t");
	         System.out.print(nonuni+" \t");
	         System.out.print(keyname+" \t");
	         System.out.print(seq+" \t");
	         System.out.print(col+" \t");
	         System.out.print(col1+" \t");
	         System.out.print(sub+" \t");
	         System.out.print(car+" \t");
	         System.out.println(ind+" \t");
          }
      }
          if(c==2)
          {
      //Unique Index
      System.out.println("Unique Index");
      System.out.println("creating index in Salesresps with primary key");
      System.out.println("create unique index id2 on Salesresps(repid)");
      String sql9;
      sql9= "create unique index id4 on Salesresps(repid)";
      stmt.executeUpdate(sql9);
      System.out.println("show index from Salesresps");
      String sql11;
      sql11= "show index from Salesresps";
      rs=stmt.executeQuery(sql11);
		System.out.print("Table"+"\t");
		System.out.print("Non_unique" + "\t"); 
		System.out.print("Key_name " +"\t");
		System.out.print("Seq_in_index"+"\t");
		System.out.print("Column_name : " +"\t");
		System.out.print("Collation " +"\t");
		System.out.print("Cardinality"+"\t");
		System.out.print("Sub_part" + "\t");
		System.out.println("Index_type"+"\t");

      System.out.println("------------------------------------------------------------");
      
      while(rs.next()){
			String tblname = rs.getString("Table");
			int nonuni = rs.getInt("Non_unique");
			String keyname = rs.getString("Key_name");
			int seq = rs.getInt("Seq_in_index");
			String col = rs.getString("Column_name");
			String col1 = rs.getString("Collation");
			String sub = rs.getString("Sub_part");
			int car = rs.getInt("Cardinality");
			String ind = rs.getString("Index_type");
			
			System.out.print(tblname+" \t");
	         System.out.print(nonuni+" \t");
	         System.out.print(keyname+" \t");
	         System.out.print(seq+" \t");
	         System.out.print(col+" \t");
	         System.out.print(col1+" \t");
	         System.out.print(sub+" \t");
	         System.out.print(car+" \t");
	         System.out.println(ind+" \t");
       			}
          }
          if(c==3)
          {
      //Composite Index
      System.out.println("Composite Index");
      System.out.println("create index id3 on Orders(productname,qty)");
      String sql10;
      sql10= "create index id3 on Orders(productname,qty)";
      stmt.executeUpdate(sql10);
      System.out.println("show index from Orders");
      String sql11;
      sql11= "show index from Orders";
      rs=stmt.executeQuery(sql11);
		System.out.print("Table"+"\t");
		System.out.print("Non_unique" + "\t"); 
		System.out.print("Key_name " +"\t");
		System.out.print("Seq_in_index"+"\t");
		System.out.print("Column_name : " +"\t");
		System.out.print("Collation " +"\t");
		System.out.print("Cardinality"+"\t");
		System.out.print("Sub_part" + "\t");
		System.out.println("Index_type"+"\t");

      System.out.println("------------------------------------------------------------");
      
      while(rs.next()){
			String tblname = rs.getString("Table");
			int nonuni = rs.getInt("Non_unique");
			String keyname = rs.getString("Key_name");
			int seq = rs.getInt("Seq_in_index");
			String col = rs.getString("Column_name");
			String col1 = rs.getString("Collation");
			String sub = rs.getString("Sub_part");
			int car = rs.getInt("Cardinality");
			String ind = rs.getString("Index_type");
			
			System.out.print(tblname+" \t");
	         System.out.print(nonuni+" \t");
	         System.out.print(keyname+" \t");
	         System.out.print(seq+" \t");
	         System.out.print(col+" \t");
	         System.out.print(col1+" \t");
	         System.out.print(sub+" \t");
	         System.out.print(car+" \t");
	         System.out.println(ind+" \t");
      			}
      
          }
      if(a==3){b=false;}
      }
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se)
      	{
    	  //Handle errors for JDBC
    	  se.printStackTrace();
   	}
      catch(Exception e)
	{
      		//Handle errors for Class.forName
      		e.printStackTrace();
   	}finally
	{
      		//finally block used to close resources
      		try{
         		if(stmt!=null)
            		stmt.close();
      			}
	catch(SQLException se2)
		{
		
                }// nothing we can do
      	try
	{
	         if(conn!=null)
	            {conn.close();}
	}
	catch(SQLException se)
	{
	         se.printStackTrace();
	}//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
//end class ViewIndex
}

