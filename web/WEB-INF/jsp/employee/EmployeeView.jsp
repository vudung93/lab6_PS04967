<%-- 
    Document   : home
    Created on : May 30, 2017, 2:07:17 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/favicon.ico">
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

    </head>
    <body>

        <div class="wrapper">
            <jsp:include page="/WEB-INF/jsp/menu.jsp"></jsp:include>

                <div class="main-panel">
                <jsp:include page="/WEB-INF/jsp/navigationBar.jsp"></jsp:include>


                    <div class="content">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="card">
                                        <div class="header">
                                            <h4 class="title">Edit Profile</h4>
                                        </div>
                                        <div class="content">
                                        <form:form action="${root}/employee.htm" enctype="multipart/form-data" modelAttribute="employee" method="post"> 
                                            <div class="row">
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <label>Employee ID</label>

                                                        <form:input path="employeeId" type="text" class="form-control"  />
                                                    </div>


                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Department</label>



                                                        <form:select  path="department.depId" class="form-control" name="depid">
                                                            <form:option value="0">Select department</form:option>
                                                            <c:forEach var="dep" items="${listdep}">
                                                                <form:option value="${dep.depId}">${dep.depName}</form:option>
                                                            </c:forEach>
                                                        </form:select>





                                                    </div>
                                                </div>

                                            </div>

                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Full name</label>

                                                        <form:input path="name" type="text" class="form-control" />
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Sex</label>
                                                        <form:select  path="gender" class="form-control">
                                                            <form:option  value="">Select sex</form:option>
                                                            <form:option  value="true">Nam</form:option>
                                                            <form:option  value="false">Nữ</form:option>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-8">
                                                    <div class="form-group">
                                                        <label>Address</label>

                                                        <form:input type="text" path="address" class="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Salary</label>
                                                        <form:input path="salary" type="text" class="form-control" />

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Birthday</label>
                                                        <fmt:formatDate value="${employee.birthday}" pattern="yyyy-MM-dd" var="DATE"/>
                                                        <%-- <form:input path="birthday" type="text"/>--%>
                                                        <input name="txtDate" type="date" value="${DATE}"  class="form-control"/>

                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Phone Number</label>
                                                        <form:input type="text" path="phone" class="form-control"/>

                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Email</label>
                                                        <form:input path="email" type="text" class="form-control" />
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Notes</label>

                                                        <form:textarea path="notes" class="form-control"></form:textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div>   
                                                    <button name="btnUpdate"  class="btn btn-info btn-fill pull-right">Update</button>
                                                </div>    
                                                <div class="clearfix"></div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="card card-user">
                                            <div class="image">
                                                <img src="${root}/assets/img/faces/banner.jpg" alt="..."/>
                                        </div>
                                        <div class="content">
                                            <div class="author">
                                                <a href="#">
                                                    <form:input path="photo" type="hidden" />
                                                    <c:choose>
                                                        <c:when test="${(employee.photo.equals('') || employee.photo==null) && src.equals('')}">
                                                            <img class="avatar border-gray" src="${root}/assets/img/faces/face-0.jpg" alt="..."/>
                                                        </c:when>
                                                        <c:when test="${ src.equals('') eq false}">
                                                            <img class="avatar border-gray" src="${root}/upload/${src}" alt="..."/>
                                                        </c:when>
                                                        <c:when test="${(employee.photo.equals('') eq false) && src.equals('')}">

                                                            <img class="avatar border-gray" src="${root}/assets/img/faces/${employee.photo}" alt="..."/>
                                                        </c:when>    
                                                    </c:choose>
                                                    <div>
                                                        <label for="files" class="btn btn-info btn-fill" id="click">Change Image</label>
                                                        <input id="files" style="visibility:hidden;" type="file" name="image2">
                                                        <button name="btnUploadUpdate"  style="visibility:hidden;" id="fuck"></button>
                                                    </div></br>

                                                </form:form>

                                                <h4 class="title">${employee.name}<br />
                                                    <small>${employee.email}</small>
                                                </h4>
                                            </a>
                                        </div>
                                        <p class="description text-center"> ${employee.notes}
                                        </p>
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
    <script src="http://code.jquery.com/jquery-latest.js">
    </script>
    <script>
        $('#files').change(function () {
            $('#fuck').click();
        });
    </script>
    <!--  Notifications Plugin    -->
    <script src="${root}/assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="${root}/text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
    <script src="${root}/assets/js/light-bootstrap-dashboard.js"></script>

    <!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
    <script src="${root}/assets/js/demo.js"></script>


</html>

