
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>All User Data</title>
</head>
<body>
<h2>All User Data</h2>
  <%
  try {

  String connectionURL="jdbc:mariadb://localhost:3306/mydb";
  Connection connection = null;
  Statement statement = null;
  ResultSet rs = null;
  Class.forName("org.mariadb.jdbc.Driver");
  connection= DriverManager.getConnection(connectionURL,"root","Unoveo@5");
  statement = connection.createStatement();
  String QueryString = "SELECT * from UserDetail";
  rs = statement.executeQuery(QueryString);
   %>
   <TABLE cellpadding="15" border="1" style="background-color: #ffffcc;" class="center">
   <TR>
      <TD>Id</TD><TD>FirstName</TD><TD>LastName</TD><TD>City</TD><TD>Age</TD>
   </TR>
   <%
   while(rs.next()){
   %>
   <TR>
   <TD><%=rs.getInt(1)%></TD>
   <TD><%=rs.getString(2)%></TD>
   <TD><%=rs.getString(3)%></TD>
   <TD><%=rs.getString(4)%></TD>
   <TD><%=rs.getInt(5)%></TD>
   </TR>
   <% } %>
   <%
   rs.close();
   statement.close();
   connection.close();
    }catch(Exception e){
    out.println("Unable to connect to database.");
    }
    %>

</TABLE>
</body>
</html>