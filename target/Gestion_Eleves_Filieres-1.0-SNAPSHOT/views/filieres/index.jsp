<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Gestion filieres - GesFil</title>

    <link rel="stylesheet" href="../ressources/css/mhaostyle.css" />
    <link rel="stylesheet" href="../ressources/css/main/app.css" />
    <link rel="stylesheet" href="../ressources/css/main/app-dark.css" />
    
    <link rel="icon" href="../ressources/images/logo/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="../ressources/images/logo/favicon.png" type="image/png" />
    
    <link rel="stylesheet" href="../ressources/extensions/simple-datatables/style.css" />
    <link rel="stylesheet" href="../ressources/css/pages/simple-datatables.css" />
    
    <s:head />
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
                        <s:a href="#">Filieres</s:a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Gestion des filieres
                    </li>
                  </ol>
                </nav>
              </div>
            </div>
          </div>
        
          <section class="section">
            <div class="card">
                <div class="card-header">Liste des filieres</div>
                <div class="card-body">
                
                    <!--<a href="createFiliereLink.action" class="btn btn-primary">Ajouter une filiere</a>-->
                    <a href="<s:url action='createFiliereLink'/>"  class="btn btn-primary">Ajouter une filiere</a>
                    <br/><br/>
                    <s:actionerror/>
                    <table class="table table-striped" id="table1">
                        <thead>
                          <tr>
                              <th>Code de la filière</th>
                              <th>Nom de la filière</th>
                              <th>Actions</th>
                          </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="filieres">
                                <tr>
                                    <td>
                                        <s:property value="Code_Fil"></s:property>
                                    </td>
                                    <td> 
                                        <s:property value="Nom_Fil"></s:property>
                                    </td>
                                    <td>
                                        <a href="<s:url action="detailFiliere" ><s:param name="Code_Fil"><s:property value="Code_Fil"/></s:param></s:url>" class="btn btn-primary btn-sm icon icon-left ">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-info"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="16" x2="12" y2="12"></line><line x1="12" y1="8" x2="12.01" y2="8"></line></svg>
                                            Detail
                                        </a>
                                         <span class="pe-4"></span>
                                        <a href="<s:url action="editFiliere" ><s:param name="Code_Fil"><s:property value="Code_Fil"/></s:param></s:url>" class="btn btn-info btn-sm icon icon-left">
                                         <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit"><path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path><path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path></svg> 
                                         Modifier
                                        </a>
                                         <span class="pe-4"></span>
                                        <a href="<s:url action="deleteFiliere"><s:param name="Code_Fil"><s:property value="Code_Fil"/></s:param></s:url>"
                                            onclick="return confirm('Confirmer la suppression ?')" accesskey=""  class="btn btn-danger btn-sm icon icon-left ">
                                        Supprimer
                                         </a>   
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        
        <s:include value="../layouts/footer.jsp" />
       
      </div>
    </div>
    <script src="../ressources/js/bootstrap.js"></script>
    <script src="../ressources/js/app.js"></script>
    
    <script src="../ressources/extensions/simple-datatables/umd/simple-datatables.js"></script>
    <script src="../ressources/js/pages/simple-datatables.js"></script>
  </body>
</html>