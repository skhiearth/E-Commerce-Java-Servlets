<%@page language="java" import="java.util.*" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

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
						                <div class="card-body">
							                <h5 class="card-title">ID: <%=itr.next()%></h5>
							                <h6 class="card-subtitle mb-2 text-muted">Name: <%=itr.next()%></h6>
							                <p class="card-text">Price: <%=itr.next()%></p>
						                </div>
					            </div>
					        </div>
						<%}%>
    </div>
    
	</body>
	
</html>