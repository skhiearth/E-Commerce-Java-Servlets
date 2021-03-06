<%@page language="java" import="java.util.*" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="icon" type="image/png" href="img/favicon.ico"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<link href="css/styles.css" rel="stylesheet">
    <title>store.xyz</title>
  </head>
  
	<body> 
	
	<div class="row" style="padding: 4px;">
		<%Iterator itr;%>
				<% List data= (List)request.getAttribute("data");
					for (itr=data.iterator(); itr.hasNext(); ){
						%>
							<div class="col" style="margin-bottom: 14px">
					            <div class="card" style="width: 18rem;">
					                <img class="card-img-top" src=<%=itr.next()%> width="140" height="240" alt="Product image">
						                <div class="card-body">
							                <h5 class="card-title"><%=itr.next()%></h5>
							                <h6 class="card-subtitle mb-2 text-muted">Rs. <%=itr.next()%></h6>
							                <p class="card-text"><%=itr.next()%></p>
							                <form method="POST" action="/E_Commerce/Adder">
							                	<input type="submit" name=<%=itr.next()%> value="Add to cart">
							                </form>
						                </div>
					            </div>
					        </div>
						<%}%>
    </div>
    
	</body>
	
</html>