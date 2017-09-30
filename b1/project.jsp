<%@ page import= "java.sql.*" %>
<%@ page import= "javax.sql.*" %>

<%
String query=request.getParameter("submit");

try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pl1","root","root123");
	Statement stmt = conn.createStatement();
	ResultSet rs=null;

	if(query.equals("insert"))
	{
		String sid=request.getParameter("studentid");
		String sname=request.getParameter("studentname");
		String smark=request.getParameter("studentmarks");

		stmt.executeUpdate("insert into studentmark(student_id,student_name,student_mark) values("+sid+",'"+sname+"',"+smark+")");

		rs=stmt.executeQuery("select * from studentmark");

		%><table border="1">
		<tr>
			<TH>ID</TH>
			<TH>NAME</TH>
			<TH>MARKS</TH>
		</tr>
		<%while(rs.next())
		{
			%><tr>
				<td><% out.println(rs.getInt(1)); %></td>
				<td><%out.println(rs.getString(2)); %></td>
				<td><%out.println(rs.getInt(3)); %></td>
			</tr><%
		}%>

		</table><%
	}

	else if(query.equals("select"))
	{
		String limit=request.getParameter("limit");

		rs=stmt.executeQuery("select * from studentmark limit " +limit);

		%><table border="1">
		<tr>
			<TH>ID</TH>
			<TH>NAME</TH>
			<TH>MARKS</TH>
		</tr>
		<%while(rs.next())
		{
			%><tr>
				<td><% out.println(rs.getInt(1)); %></td>
				<td><%out.println(rs.getString(2)); %></td>
				<td><%out.println(rs.getInt(3)); %></td>
			</tr><%
		}%>

		</table><%

		rs=stmt.executeQuery("select distinct student_name from studentmark");

		%><table border="1">
		<tr>
			<TH>SNAME</TH>
		</tr>
		<%while(rs.next())
		{
			%><tr>
				<td><%out.println(rs.getString(1)); %></td>
			</tr><%
		}%>

		</table><%
	}

	else if(query.equals("update"))
	{
		String sname1=request.getParameter("name");
		String smark1=request.getParameter("m2");

		stmt.executeUpdate("update studentmark set student_mark="+smark1+" where student_name='"+sname1+"' ");

		rs=stmt.executeQuery("select * from studentmark");

		%><table border="1">
		<tr>
			<TH>ID</TH>
			<TH>NAME</TH>
			<TH>MARKS</TH>
		</tr>
		<%while(rs.next())
		{
			%><tr>
				<td><% out.println(rs.getInt(1)); %></td>
				<td><%out.println(rs.getString(2)); %></td>
				<td><%out.println(rs.getInt(3)); %></td>
			</tr><%
		}%>

		</table><%
	}

	else if(query.equals("delete"))
	{
		String sname2=request.getParameter("m3");
		
		stmt.executeUpdate("delete from studentmark where student_name='"+sname2+"'");

		rs=stmt.executeQuery("select * from studentmark");

		%><table border="1">
		<tr>
			<TH>ID</TH>
			<TH>NAME</TH>
			<TH>MARKS</TH>
		</tr>
		<%while(rs.next())
		{
			%><tr>
				<td><% out.println(rs.getInt(1)); %></td>
				<td><%out.println(rs.getString(2)); %></td>
				<td><%out.println(rs.getInt(3)); %></td>
			</tr><%
		}%>

		</table><%
	}
	
	else if(query.equals("count"))
	{

		rs=stmt.executeQuery("select count(*) from studentmark");

		%><table border="1">
		<tr>
			<TH>Count</TH>
		</tr>
		<%while(rs.next())
		{
			%><tr>
				<td><% out.println(rs.getInt(1)); %></td>
			</tr><%
		}%>

		</table><%
	}

	else if(query.equals("average"))
	{

		rs=stmt.executeQuery("select avg(student_mark) from studentmark");

		%><table border="1">
		<tr>
			<TH>Average</TH>
		</tr>
		<%while(rs.next())
		{
			%><tr>
				<td><% out.println(rs.getInt(1)); %></td>
			</tr><%
		}%>

		</table><%
	}

}
catch(Exception e) 
{
	e.printStackTrace();
}

%>
