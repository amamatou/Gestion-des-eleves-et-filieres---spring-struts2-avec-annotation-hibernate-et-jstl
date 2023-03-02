<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard - GesFil</title>

    <link rel="stylesheet" href="ressources/css/mhaostyle.css" />
    <link rel="stylesheet" href="ressources/css/main/app.css" />
    <link rel="stylesheet" href="ressources/css/main/app-dark.css" />
    
    <link rel="icon" href="ressources/images/logo/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="ressources/images/logo/favicon.png" type="image/png" />
    
    <link rel="stylesheet" href="ressources/css/shared/iconly.css" />
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

        <div class="page-title">
            <div class="row">
              <div class="col-12 col-md-6 order-md-1 order-last">
                <h3>Dashboard</h3>
              </div>
              <div class="col-12 col-md-6 order-md-2 order-first">
                <nav
                  aria-label="breadcrumb"
                  class="breadcrumb-header float-start float-lg-end"
                >
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <s:a href="%{lien1}">Dashboard</s:a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Dashboard
                    </li>
                  </ol>
                </nav>
              </div>
            </div>
          </div>
        
        <!--Page contain-->
        <div class="page-content">
          <section class="row">
            <div class="col-12 col-lg-9">
              <div class="row">
                <div class="col-6 col-lg-3 col-md-6">
                  <div class="card">
                    <div class="card-body px-4 py-4-5">
                      <div class="row">
                        <div
                          class="col-md-4 col-lg-12 col-xl-12 col-xxl-5 d-flex justify-content-start"
                        >
                          <div class="stats-icon purple mb-2">
                            <i class="iconly-boldShow"></i>
                          </div>
                        </div>
                        <div class="col-md-8 col-lg-12 col-xl-12 col-xxl-7">
                          <h6 class="text-muted font-semibold">
                            Filieres
                          </h6>
                          <h6 class="font-extrabold mb-0">${nbTotalFilieres}</h6>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-6 col-lg-3 col-md-6">
                  <div class="card">
                    <div class="card-body px-4 py-4-5">
                      <div class="row">
                        <div
                          class="col-md-4 col-lg-12 col-xl-12 col-xxl-5 d-flex justify-content-start"
                        >
                          <div class="stats-icon blue mb-2">
                            <i class="iconly-boldProfile"></i>
                          </div>
                        </div>
                        <div class="col-md-8 col-lg-12 col-xl-12 col-xxl-7">
                          <h6 class="text-muted font-semibold">Eleves</h6>
                          <h6 class="font-extrabold mb-0">${nbTotalEleves}</h6>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-12">
                  <div class="card">
                    <div class="card-header">
                      <h4>Les filieres</h4>
                    </div>
                    <div class="card-body">
                    <c:forEach items="${nbEleveParFiliere}" var="map">
                        <%--<s:iterator value="filieres" var="filiere">--%>
                        <div class="row">
                          <div class="col-6">
                            <div class="d-flex align-items-center">
                              <svg class="bi text-primary" width="32" height="32" fill="blue" style="width: 10px" >
                                <use xlink:href="../ressources/images/bootstrap-icons.svg#circle-fill" />
                              </svg>
                              <h5 class="mb-0 ms-3">
                                  <%--<s:property value="Code_Fil" />--%>
                                  ${map.key}
                              </h5>
                            </div>
                          </div>
                          <div class="col-6">
                            <h5 class="mb-0">
                                ${map.value}
                            </h5>
                          </div>
                          <div class="col-12">
                            <div id="chart-europe"></div>
                          </div>
                        </div>
                      <%--</s:iterator>--%>
                      </c:forEach>
                      
                    </div>
                  </div>
                </div>
                
              </div>
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

