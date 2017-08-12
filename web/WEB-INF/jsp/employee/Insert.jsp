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
        <style>
            .card-user .image {
                height: 60px;
            }
            .btn2{
                border-width: 2px;
                font-weight: 200;
                padding: 7px 14px;
                display: inline-block;
                margin-bottom: 0;
                transition: all 100ms ease-in;
                line-height: 1.42857143;
                font-size: 12px;
                text-align: center;
                white-space: nowrap;
                vertical-align: middle;
                touch-action: manipulation;
                cursor: pointer;
                user-select: none;
                background-image: none;
                border: 1px solid transparent;
                border-radius: 4px;
            }
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
                                <div class="col-md-8">
                                    <div class="card">
                                        <div class="header">

                                        </div>
                                        <div class="content">
                                        <form:form action="${root}/employee.htm" enctype="multipart/form-data"  method="post" modelAttribute="employeeNew" > 
                                            <div class="row">
                                                <div class="col-md-5">
                                                    <div class="form-group">
                                                        <label>Employee ID</label>

                                                        <%----%>       <input name="txtEmployeeID"  type="text" class="form-control" disabled="true"/>
                                                    </div>


                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Department</label>


                                                        <c:choose><%----%>       
                                                            <c:when test="${employeeNew.department==null}">
                                                                <select class="form-control" name="department.depId">
                                                                    <option value="0">Select Department</option>
                                                                    <c:forEach var="dep" items="${listdep}" >
                                                                        <option value="${dep.depId}">${dep.depName}</option>
                                                                    </c:forEach>

                                                                </select>
                                                            </c:when>
                                                            <c:when test="${employeeNew.department!=null}">
                                                                <form:select path="department.depId" class="form-control">
                                                                     <form:option value="0">Select Department</form:option>
                                                                    <c:forEach var="dep" items="${listdep}" >
                                                                        <form:option value="${dep.depId}">${dep.depName}</form:option>
                                                                    </c:forEach>
                                                                </form:select>
                                                            </c:when>
                                                        </c:choose>
                                                                     </br>   <div class="kieuchu">${depIderr}</div>           





                                                    </div>
                                                </div>

                                            </div>

                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label>Full name</label>

                                                        <%----%>       <form:input path="name" type="text" class="form-control" /></br>
                                                        <div class="kieuchu">${nameerr}</div>
                                                    </div>
                                                </div>
                                                <div class="col-md-3">
                                                    <div class="form-group">
                                                        <label>Sex</label>
                                                        <c:choose><%----%>
                                                            <c:when test="${employeeNew.gender==null}">
                                                                <select class="form-control" name="gender">
                                                                    <option value="">Select gender</option>
                                                                    <option value="true">Nam</option>
                                                                    <option value="false">Nữ</option>
                                                                </select>
                                                            </c:when>
                                                            <c:when test="${employeeNew.gender!=null}">
                                                                <form:select path="gender" class="form-control"> 
                                                                    
                                                                    <form:option  value="true">Nam</form:option>
                                                                    <form:option  value="false">Nữ</form:option>
                                                                </form:select>
                                                            </c:when>
                                                        </c:choose>
                                                                    </br>  <div class="kieuchu">${gendererr}</div>  

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-8">
                                                    <div class="form-group">
                                                        <label>Address</label>

                                                        <%----%>  <form:input path="address" type="text" class="form-control"/>
                                                        </br>  <div class="kieuchu">${addresserr}</div>  
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Salary</label>
                                                        <%----%>  <form:input path="salary" type="text" class="form-control" />
                                                        
                                                        </br>  <div class="kieuchu">${salaryerr}</div>  

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Birthday</label>

                                                        <%----%> <fmt:formatDate value="${employeeNew.birthday}" pattern="yyyy-MM-dd" var="DATE"/>
                                                          <input name="txtDate" type="date" value="${DATE}"  class="form-control" />
                                                          </br>  <div class="kieuchu">${dateerr}</div>

                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Phone Number</label>
                                                        <%----%>   <form:input path="phone" type="number" class="form-control"/>
                                                        </br>  <div class="kieuchu">${phoneerr}</div>

                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group">
                                                        <label>Email</label>
                                                        <%----%>  <form:input path="email"  type="text" class="form-control" />
                                                        <div class="kieuchu">${emailerr}</div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Notes</label>

                                                        <%----%> <form:textarea path="notes"  name="txtNotes" class="form-control"></form:textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div>   
                                                <button name="btnSave"  class="btn btn-info btn-fill pull-right">Save</button>
                                            </div>    
                                            <div class="clearfix"></div>
                                       <%-- </form:form>--%>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card card-user">
                                    <div class="image">

                                    </div>
                                    <div class="content">
                                        <div class="author">

                                            <%--<form:form action="${root}/employee/upload.htm" method="post" enctype="multipart/form-data" modelAttribute="employeeNew">--%>
                                            <form:input path="photo" type="hidden" />
                                                <c:choose>
                                                    <c:when test="${src.equals('')}">
                                                        <img style="width: 200px; height:200px"  src="/demo/assets/img/faces/face-0.jpg" /></br></br>
                                                    </c:when>
                                                    <c:when test="${src.equals('') eq false}">
                                                        <img style="width: 200px; height:200px"  src="/demo/upload/${src}" /></br></br>
                                                    </c:when>
                                                </c:choose>



                                                <div>
                                                    <label for="files" class="btn btn-info btn-fill" id="click">Select Image</label>
                                                    <input id="files" style="visibility:hidden;" type="file" name="image">
                                                    <button name="btnUpload"  style="visibility:hidden;" id="fuck"></button>
                                                </div></br>
                                                <%--    <button class="btn2 btn-info btn-fill">Upload</button>--%>
                                            </form:form>

                                            <h4 class="title">${employee.name}<br />
                                                <small>${employee.email}</small>
                                            </h4>

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
    <script src="${root}/assets/js/bootstrap.min.js" type="text/javascript">


    </script>
    <script src="http://code.jquery.com/jquery-latest.js">
    </script>
    <script>
        $('#files').change(function () {
            $('#fuck').click();
        });
    </script>

    <!--  Checkbox, Radio & Switch Plugins -->
    <script src="${root}/assets/js/bootstrap-checkbox-radio-switch.js"></script>

    <!--  Charts Plugin -->
    <script src="${root}/assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="${root}/assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="${root}/text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
    <script src="${root}/assets/js/light-bootstrap-dashboard.js"></script>

    <!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
    <script src="${root}/assets/js/demo.js"></script>


</html>

