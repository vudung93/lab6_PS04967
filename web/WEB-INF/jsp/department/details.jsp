<%-- 
    Document   : home
    Created on : May 30, 2017, 2:07:17 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="catcherr.arrangement" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon.ico" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Quản lý nhân viên</title>
        <c:set var="root" value="${pageContext.servletContext.contextPath}"/>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />


        <!-- Bootstrap core CSS     -->
        <link href="${root}/assets/css/bootstrap.min.css" rel="stylesheet" />

        <!-- Animation library for notifications   -->
        <link href="${root}/assets/css/animate.min.css" rel="stylesheet"/>

        <!--  Light Bootstrap Table core CSS    -->
        <link href="${root}/assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>

        <!--     Fonts and icons     -->
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
        <link href="${root}/assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
        <style>
            .kieuchu{
                color: red;
                font-size: 12px;
              
            }
        </style>
    </head>
    <body>

        <div class="wrapper">
            <jsp:include page="/WEB-INF/jsp/menu.jsp"></jsp:include>

                <div class="main-panel">
                <jsp:include page="/WEB-INF/jsp/navigationBar.jsp"></jsp:include>


                    <div class="content">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card">
                                        <div class="header">
                                            <h4 class="title">Details Department</h4>
                                        </div>
                                        <div class="content">
                                        <form:form action="${root}/department.htm" modelAttribute="department" method="post">
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Department ID</label>
                                                        <form:input path="depId" type="hidden" class="form-control"/>
                                                        <input  class="form-control" type="text" disabled="true"  value="${department.depId}"/>
                                                        
                                                    </div>   
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">                                                       
                                                        <label>Department Name</label>
                                                        <form:input path="depName" type="text" class="form-control" />
                                                        </br>   <div class="kieuchu">${depNameerr}</div>
                                                    </div>
                                                </div>

                                            </div>

                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Department Phone</label>
                                                        <form:input path="depPhone" type="text" class="form-control" />
                                                        </br>   <div class="kieuchu">${depPhoneerr}</div>
                                                    </div>   
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Location</label>
                                                        <form:input path="location" type="text" class="form-control" />
                                                        </br>   <div class="kieuchu">${locationerr}</div>
                                                    </div>   
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Founding</label>
                                                        <fmt:formatDate value="${department.founding}" pattern="yyyy-MM-dd" var="DATE"/>
                                                        <%-- <form:input path="birthday" type="text"/>--%>
                                                        <input name="txtFounding" type="date" value="${DATE}"  class="form-control"/>
                                                        </br>   <div class="kieuchu">${foundingerr}</div>
                                                </div>    
                                            </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Function</label>
                                                        <form:textarea path="functions" class="form-control" />
                                                        </br>   <div class="kieuchu">${functionserr}</div>
                                                    </div>
                                                </div>
                                            </div> 
                                                    
                                            <div class="row">
                                            <%--<div class="content table-responsive table-full-width">--%>
                                                <table class="table table-hover table-striped">
                                                    <thead>
                                                    <th>ID</th>
                                                    <th>Name</th>
                                                    <th>Phone</th>
                                                    <th>Address</th>
                                                    <th>Salary</th>
                                                    <th>Gender</th>
                                                    <th>Birthday</th>
                                                    <th>Email</th>
                                                    <th>Notes</th>
                                                    </thead>
                                                    <tbody>
                                                       
                                                        <c:forEach var="emp" items="${arrangement.arr(department.getEmployees())}">
                                                            <tr>
                                                                <td>${emp.employeeId}</td>
                                                                <td>${emp.name}</td>
                                                                <td>${emp.phone}</td>
                                                                <td>${emp.address}</td>
                                                                <td>${emp.salary}</td>
                                                                <td>
                                                                    <c:if test="${emp.gender eq true}">
                                                                        Nam
                                                                    </c:if> 
                                                                    <c:if test="${emp.gender eq false}">
                                                                        Nữ
                                                                    </c:if>     

                                                                </td>
                                                                <td>${emp.birthday}</td>
                                                                <td>${emp.email}</td>
                                                                <td>${emp.notes}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>

                                            <%--</div>--%>
                                                </div>
                                                   
                                            <div>   
                                                <button name="btnUpdatedep"  class="btn btn-info btn-fill pull-right">Update</button>
                                            </div> 


                                        </form:form>
                                    
                                    
                                </div>
                                <hr>
                                <div class="text-center">
                                    <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
                                    <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
                                    <button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i></button>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>


            </div>
        </div>


    </body>
    <!--   Core JS Files   -->
    <script src="${root}/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="${root}/assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="${root}/assets/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="${root}/assets/js/chartist.min.js"></script>
<
<!--  Notifications Plugin    -->
<script src="${root}/assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="${root}/text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="${root}/assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="${root}/assets/js/demo.js"></script>


</html>

