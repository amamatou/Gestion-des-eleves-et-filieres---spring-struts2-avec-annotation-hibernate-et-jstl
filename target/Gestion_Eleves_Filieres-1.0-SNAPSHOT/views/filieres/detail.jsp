<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Detail filiere - GesFil</title>

    <link rel="stylesheet" href="../ressources/css/mhaostyle.css" />
    <link rel="stylesheet" href="../ressources/css/main/app.css" />
    <link rel="stylesheet" href="../ressources/css/main/app-dark.css" />
    
    <link rel="icon" href="../ressources/images/logo/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="../ressources/images/logo/favicon.png" type="image/png" />
    

  </head>

  <body>
    <script src="../ressources/js/initTheme.js"></script>
    <div id="app">
      <s:include value="../layouts/sidebar.jsp" />

    <div id="main">
        <header class="mb-3">
          <a href="#" class="burger-btn d-block d-xl-none">
            <i class="bi bi-justify fs-3"></i>
          </a>
        </header>

        <div class="page-title">
            <div class="row">
              <div class="col-12 col-md-6 order-md-1 order-last">
                <h3>Filieres</h3>
              </div>
              <div class="col-12 col-md-6 order-md-2 order-first">
                <nav
                  aria-label="breadcrumb"
                  class="breadcrumb-header float-start float-lg-end"
                >
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <s:a href="%{lien1}">Filieres</s:a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Detail filiere
                    </li>
                  </ol>
                </nav>
              </div>
            </div>
          </div>
        
        <section id="basic-vertical-layouts">
            <div class="row match-height">
              <div class="col-12">
                <div class="card">
                  <div class="card-header">
                    <h4 class="card-title">Detail de la filiere</h4>
                  </div>
                  <div class="card-content">
                    <div class="card-body">
                      
                        <table class="table table-striped dataTable-table" id="table1">
                            <tbody>
                                <tr>
                                    <th>Code de la filière</th>
                                    <td>
                                        <s:property value="filiere.code_Fil"></s:property>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Nom de la filière</th>
                                    <td> 
                                        <s:property value="filiere.nom_Fil"></s:property>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Nombre d'eleves de la filière</th>
                                    <td>
                                        <c:out value="${filiere.elevesFil.size()}"/>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="buttons">
                            <a href="<s:url action="editFiliere" ><s:param name="Code_Fil"><s:property value="Code_Fil"/></s:param></s:url>" class="btn btn-info">
                             Modifier
                            </a>
                             <!--<span class="pe-4"></span>-->
                            <a href="<s:url action="deleteFiliere"><s:param name="Code_Fil"><s:property value="Code_Fil"/></s:param></s:url>"
                                onclick="return confirm('Confirmer la suppression ?')" accesskey=""  class="btn btn-danger ">
                            Supprimer
                             </a>   
                        </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>

        <s:include value="../layouts/footer.jsp" />
      </div>
    </div>
    <script src="../ressources/js/bootstrap.js"></script>
    <script src="../ressources/js/app.js"></script>
  </body>
</html>

