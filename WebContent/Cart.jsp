<%@page language="java" import="java.util.*" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <link href="css/sticky-footer-navbar.css" rel="stylesheet">
    <title>store.xyz</title>
  </head>
  
	<body> 


    
    <table class="table table-bordered table-dark">
	  <thead>
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Product Name</th>
	      <th scope="col">Quantity</th>
	      <th scope="col">Price per piece</th>
	      <th scope="col">Total Price</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%Iterator itr;%>
			<% List data= (List)request.getAttribute("data");
			for (itr=data.iterator(); itr.hasNext(); )
			{
			%>
			<tr>
			<td width="119"><%=itr.next()%></td>
			<td width="168"><%=itr.next()%></td>
			<td width="168"><%=itr.next()%></td>
			<td width="168"><%=itr.next()%></td>
			<td width="168"><%=itr.next()%></td>
			</tr>
			<%}%>
	  </tbody>
</table>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
  </body>
</html>