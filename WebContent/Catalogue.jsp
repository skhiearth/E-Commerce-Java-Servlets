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
							<div class="col" style="margin-right: 0px">
					            <div class="card" style="width: 18rem;">
					                <img class="card-img-top" src="..." alt="Card image cap">
						                <div class="card-body">
							                <h5 class="card-title"><%=itr.next()%></h5>
							                <h6 class="card-subtitle mb-2 text-muted">Price: <%=itr.next()%></h6>
							                <p class="card-text"><%=itr.next()%></p>
							                <input type="submit" name=<%=itr.next()%> value="Add to cart">
						                </div>
					            </div>
					        </div>
						<%}%>
						
<!-- 						if (request.getParameter("btn1") != null){
				      	
				 		}
						else if (request.getParameter("btn2") != null){
						       // do something
						 } -->
    </div>
    
	</body>
	
</html>