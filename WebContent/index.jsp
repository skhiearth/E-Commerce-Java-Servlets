<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <link href="css/sticky-footer-navbar.css" rel="stylesheet">
    <title>store.xyz</title>
  </head>
  <body>
    
    <header>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="margin-bottom: 10px;">
        <div class="container-fluid">
          <a class="navbar-brand" href="index.jsp">store.xyz</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            </ul>
            <span class="navbar-text">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link" href="CartOne.jsp">Cart</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="signin.html">Login</a>
                </li>
              </ul>
            </span>
          </div>
        </div>
      </nav>
    </header>
	
    <main>
      <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h1 class="display-4">Welcome to store.xyz</h1>
          <p class="lead">This is our mockup for an example e-commerce store using Java Servlets, JSP and JDBC</p>
          
          

          <iframe src="/E_Commerce/Catalogue" width = "100%" height = "450" style="padding-left: 20px; padding-right: 20px;">
            Frames not supported.
          </iframe>
          
        </div>
      </div>
    </main>

    <footer class="footer text-center">
      <div class="container">
        <span class="text-muted" style="text-align: center;">store.xyz © 2021 | by Ramanuj Sharma, Simran Gogia and Utkarsh Sharma</span>
      </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
  </body>
</html>