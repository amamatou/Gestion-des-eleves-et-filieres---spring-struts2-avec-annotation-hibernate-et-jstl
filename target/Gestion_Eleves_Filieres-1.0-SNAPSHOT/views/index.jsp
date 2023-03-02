<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard - Gestion des eleves</title>

    <link rel="stylesheet" href="ressources/css/mhaostyle.css" />
    <link rel="stylesheet" href="ressources/css/main/app.css" />
    <link rel="stylesheet" href="ressources/css/main/app-dark.css" />
    <link rel="icon" href="ressources/images/logo/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="ressources/images/logo/favicon.png" type="image/png" />
    <link rel="stylesheet" href="ressources/css/shared/iconly.css" />
    
    <!--<script src="https://kit.fontawesome.com/45e38e596f.js" crossorigin="anonymous"></script>-->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

  </head>

  <body>
    <script src="ressources/js/initTheme.js"></script>
    <div id="app">
      <s:include value="layouts/sidebar.jsp" />

    <div id="main">
        <header class="mb-3">
          <a href="#" class="burger-btn d-block d-xl-none">
            <i class="bi bi-justify fs-3"></i>
          </a>
        </header>

        <div class="page-heading">
          <h3>Home</h3>
        </div>
        <div class="page-content">
            <section class="row">
                <div class="col-12 col-lg-9">
                    
                    
                    Bienvenue sur mon application dediee a la gestion des eleves et filieres
                    
                    
                    
                </div>
            </section>
        </div>

        <s:include value="layouts/footer.jsp" />
      </div>
    </div>
    <script src="ressources/js/bootstrap.js"></script>
    <script src="ressources/js/app.js"></script>

    <!-- Need: Apexcharts -->
    <script src="ressources/extensions/apexcharts/apexcharts.min.js"></script>
    <script src="ressources/js/pages/dashboard.js"></script>
  </body>
</html>

