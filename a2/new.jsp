<%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>

<%
	
	//String driver="com.mysql.jdbc.Driver";
	//String user="root";
	//String password="root123";
	//String url="jdbc:mysql://localhost:3306/pl1";
	String query=request.getParameter("submit");
	try
	{
		out.println("Hi!!!");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pl1","root","root123");
		Statement stmt=conn.createStatement(); 

		if(query.equals("Query1"))
		{
			out.println(query);
			ResultSet rs=stmt.executeQuery("select repid,name from Salesreps");
			

			%>

			<table border="1">
			<tr>
				<TH>RepID</TH>
				<TH>Name</TH>
			</tr>

			<% 
			while(rs.next())
			{
				%><tr>
					<td><% out.println(rs.getInt(1)); %></td>
					<td><% out.println(rs.getString(2)); %></td>
				</tr><% 
			}
			%>

			</table>
			
			<%
		}
		else if(query.equals("Query2"))
		{
			out.println(query);
			ResultSet rs=stmt.executeQuery("select custid,company,credit_limit from Customers where credit_limit > 50000 or custid in(select custid from Orders where amt > 50000)");

			%>

			<table border="1">
			<tr>
				<TH>ID</TH>
				<TH>company</TH>
				<TH>Limit</TH>
			</tr>
			
			<%
			while(rs.next())
			{
				%><tr>
					<td><% out.println(rs.getInt(1)); %></td>
					<td><% out.println(rs.getString(2)); %></td>					
					<td><% out.println(rs.getString(3)); %></td>
				</tr><%
			}
			%>

			</table>
				
			<%

		}
		else if(query.equals("Query3"))
		{
			out.println(query);
			ResultSet rs=stmt.executeQuery("select productname from Orders where qty is null");

			%>
			<table border="1">
			<tr>
				<TH>Product Name</TH>
			</tr>
			<%
			while(rs.next())
			{
				%><tr>
					<td><% out.println(rs.getString(1)); %></td>
				</tr><%
			}
			%>
			</table>
			<%

		}
		else if(query.equals("Query4"))
		{
			out.println(query);
			ResultSet rs=stmt.executeQuery(" select Salesreps.name as seller,Customers.company as customer,Orders.productname,Orders.amt from Salesreps,Customers,Orders where Orders.amt>25000 and Orders.custid=Customers.custid and Customers.repid=Salesreps.repid");

			%>
			<table border="1">
			<tr>
				<TH>Seller</TH>
				<Th>Customer</TH>
				<TH>Prodct Name</TH>
				<TH>Amount</TH>
			</tr>
			<%
			while(rs.next())
			{
				%><tr>
					<td><% out.println(rs.getString(1)); %></td>
					<td><% out.println(rs.getString(2)); %></td>
					<td><% out.println(rs.getString(3)); %></td>
					<td><% out.println(rs.getInt(4)); %></td>
				</tr><%
			}
			%>
			</table>
			<%

		}
		else if(query.equals("Query5"))
		{
			out.println(query);
			ResultSet rs=stmt.executeQuery(" select custid,Customers.company as customer,credit_limit from Customers,Salesreps where Customers.credit_limit > Salesreps.quota and Customers.repid=Salesreps.repid");

			%>
			<table border="1">
			<tr>
				<TH>Customer ID</TH>
				<Th>Customer</TH>
				<TH>Limit</TH>
			</tr>
			<%
			while(rs.next())
			{
				%><tr>
					<td><% out.println(rs.getInt(1)); %></td>
					<td><% out.println(rs.getString(2)); %></td>
					<td><% out.println(rs.getInt(3)); %></td>
				</tr><%
			}
			%>
			</table>
			<%

		}
		else if(query.equals("Query6"))		//doubt in query
		{
			out.println(query);

			ResultSet rs=stmt.executeQuery("select Customers.company,avg(Salesreps.sales) from Customers,Salesreps where Customers.repid=Salesreps.repid group by Customers.company");

			%>
			<table border="1">
			<tr>
				<TH>Customer</TH>
				<Th>Average</TH>
			</tr>
			<%
			while(rs.next())
			{
				%><tr>
					<td><% out.println(rs.getString(1)); %></td>
					<td><% out.println(rs.getInt(2)); %></td>
				</tr><%
			}
			%>
			</table>
			<%

		}		

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
out.println("Good Bye!!!");

%>




