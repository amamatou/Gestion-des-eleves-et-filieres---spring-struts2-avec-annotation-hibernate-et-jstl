<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ajout d'eleve - GesFil</title>

    <link rel="stylesheet" href="../ressources/css/mhaostyle.css" />
    <link rel="stylesheet" href="../ressources/css/main/app.css" />
    <link rel="stylesheet" href="../ressources/css/main/app-dark.css" />
    
    <link rel="icon" href="../ressources/images/logo/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="../ressources/images/logo/favicon.png" type="image/png" />
    
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
                <h3>Eleves</h3>
              </div>
              <div class="col-12 col-md-6 order-md-2 order-first">
                <nav
                  aria-label="breadcrumb"
                  class="breadcrumb-header float-start float-lg-end"
                >
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <s:a href="#">Eleves</s:a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Ajout d'eleve
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
                    <h4 class="card-title">Ajout d'eleve</h4>
                  </div>
                  <div class="card-content">
                    <div class="card-body">
                      <s:form action="createEleve" method="post" cssClass="form form-vertical">
                        <div class="form-body">
                          <div class="row">
                            <div class="col-12">
                              <div class="form-group">
                                <s:textfield name="eleve.cne" label="CNE" cssClass="form-control" />
                              </div>
                            </div>
                              <div class="col-12">
                              <div class="form-group">
                                <s:textfield name="eleve.nom" label="Nom" cssClass="form-control" />
                              </div>
                            <div class="col-12">
                              <div class="form-group">
                                <s:textfield name="eleve.prenom" label="Prénom" cssClass="form-control" />
                              </div>
                            </div>
                             <div class="col-12">
                              <div class="form-group">
                                <s:textfield name="eleve.moyenne" label="Moyenne" cssClass="form-control" />
                              </div>
                            </div>
                            <div class="col-12">
                              <div class="form-group">
                                  <s:select label="Filiere" list="filieres" listKey="Code_Fil" listValue="Nom_Fil" name="eleve.ref_Fil.Code_Fil" 
                                            emptyOption="true" cssClass="form-control"/>
                              </div>
                            </div>
                            <div class="col-12 d-flex justify-content-between">
                                <div>
                                    <s:submit value="Enregistrer" cssClass="btn btn-primary me-1 mb-1"/>
                                </div>
                                 <div>
                                    <s:reset cssClass="btn btn-light-secondary me-1 mb-1" />
                                </div>
                            </div>
                          </div>
                        </div>
                      </s:form>
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

