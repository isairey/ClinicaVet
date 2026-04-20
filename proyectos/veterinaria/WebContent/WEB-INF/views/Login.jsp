<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  <!DOCTYPE html >
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
  <!-- Le styles -->
    <link href="../css/bootstrap.css" rel="stylesheet">


    <link href="../css/bootstrap-responsive.css" rel="stylesheet">
    
    <style type="text/css">
      /* Override some defaults */
      html, body {
        background-color: #eee;
      }
      body {
        padding-top: 40px; 
      }
      .container {
        width: 300px;
      }

      /* The white background content wrapper */
      .container > .content {
        background-color: #fff;
        padding: 20px;
        margin: 0 -20px; 
        -webkit-border-radius: 10px 10px 10px 10px;
           -moz-border-radius: 10px 10px 10px 10px;
                border-radius: 10px 10px 10px 10px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.15);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                box-shadow: 0 1px 2px rgba(0,0,0,.15);
      }

    .login-form {
      margin-left: 65px;
    }
  
    legend {
      margin-right: -50px;
      font-weight: bold;
      color: #404040;
    }

    </style>	

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<title>Login: Veterinaria</title>
</head>

<body onload='document.loginForm.Usuario.focus();'>

<div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="#">Team Furious</a>
          <div class="nav-collapse">
            <ul class="nav">
               <li><a href="../index.jsp">Inicio</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

 <div class="container">
      <div class="content">
          <div class="row">
              <div class="login-form">
                  <h2>Login</h2>
                  <form id="loginForm" name="loginForm" action="editarLogin" method="post">
                      <fieldset>
                          <div class="clearfix">
                              <input type="text" placeholder="Username" id="usernameField" type="text" name="Usuario">
                          </div>
                          <div class="clearfix">
                              <input type="password" placeholder="Password" id="passwordField" name="Password" >
                          </div>
                          <button class="btn btn-primary" type="submit">Login</button>
                      </fieldset>
                  </form>
              </div>
          </div>
          <footer>
        <p>&copy; Furious LLC 2012</p>
   		</footer>
      </div>
      
  </div> <!-- /container -->


    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/jquery-ui.min.js"></script>
    <script src="../js/jas-script.js"></script>

</body>

</html>