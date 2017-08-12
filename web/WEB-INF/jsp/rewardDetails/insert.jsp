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
                                            <h4 class="title">Reward Detail</h4>
                                        </div>
                                        <div class="content">
                                        <form:form action="${root}/rewarddetails/add.htm" modelAttribute="rewdetails" method="post">
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>RewardDetails ID</label>

                                                        <input  class="form-control" type="text" disabled="true"  value=""/>

                                                    </div>   
                                                </div> 

                                                <div class="col-md-4">
                                                    <div class="form-group">                                                       
                                                        <label>Employee Name</label>
                                                        <c:choose>
                                                            <c:when test="${rewdetails.employee==null}">
                                                                <select name="employee.employeeId" class="form-control">
                                                                    <option value="0">Select Employee</option>
                                                                    <c:forEach var="employee" items="${emplist}">
                                                                        <option value="${employee.employeeId}">${employee.name}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </c:when>
                                                            <c:when test="${rewdetails.employee!=null}">
                                                                <form:select path="employee.employeeId" class="form-control">
                                                                    <form:option value="0">Select Employee</form:option>
                                                                    <c:forEach var="employee" items="${emplist}">
                                                                        <form:option value="${employee.employeeId}">${employee.name}</form:option>
                                                                    </c:forEach>
                                                                </form:select>
                                                            </c:when>
                                                        </c:choose>

                                                        </br>   <div class="kieuchu">${employeeerr}</div>
                                                    </div>
                                                </div>

                                            </div>

                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Reward Name</label>
                                                        <c:choose>
                                                            <c:when test="${rewdetails.reward ==null}">
                                                                <select name="reward.rewId" class="form-control">
                                                                    <option value="0">Select Reward</option>
                                                                    <c:forEach var="reward" items="${rewlist}">
                                                                        <option value="${reward.rewId}">${reward.rewname}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </c:when>
                                                            <c:when test="${rewdetails.reward !=null}">
                                                                <form:select path="reward.rewId" class="form-control">
                                                                    <form:option value="0">Select Reward</form:option>
                                                                    <c:forEach var="reward" items="${rewlist}">
                                                                        <form:option value="${reward.rewId}">${reward.rewname}</form:option>
                                                                    </c:forEach>
                                                                </form:select>
                                                            </c:when>
                                                        </c:choose>

                                                        </br>   <div class="kieuchu">${rewarderr}</div>
                                                    </div>   
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Formality</label>
                                                        <form:input path="formality" type="text" class="form-control" />
                                                        </br>   <div class="kieuchu">${formalityerr}</div>
                                                    </div>   
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Date</label>
                                                        <fmt:formatDate value="${rewdetails.date}" pattern="yyyy-MM-dd" var="DATE"/>

                                                        <input name="txtDate" type="date" value="${DATE}"  class="form-control"/>
                                                        </br>   <div class="kieuchu">${dateerr}</div>
                                                    </div>    
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Reason</label>
                                                        <form:textarea path="reason" class="form-control" />
                                                        </br>   <div class="kieuchu">${reasonerr}</div>
                                                    </div>
                                                </div>
                                            </div> 



                                            <div>   
                                                <button name="btnSave"  class="btn btn-info btn-fill pull-right">Update</button>
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

