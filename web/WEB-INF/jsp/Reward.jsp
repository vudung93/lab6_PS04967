<%-- 
    Document   : home
    Created on : May 30, 2017, 2:07:17 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            .title {
                width: 100%;
                background-color: #CFCFCF;
                overflow: auto;
            }

            .title a {
                float: left;
                width: 50%;
                text-align: center;
                padding: 12px 0;
                transition: all 0.3s ease;
                color: white;
                font-size: 15px;
            }

            .icon-bar a:hover {
                background-color: #000;
            }
            .active1{
                background-color:#1DC7EA;;
            }
        </style>
    </head>

    <body>

        <div class="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>

                <div class="main-panel">
                <jsp:include page="navigationBar.jsp"></jsp:include>



                    <div class="content">
                        <div class="container-fluid">
                        <c:choose>
                            <c:when test="${webName3.equals('Reward')}">
                                <div class="title">
                                    <a class="active1" href="${root}/reward/show.htm">Reward</a> 
                                    <a href="${root}/rewarddetails/show.htm">Reward Details</a> 

                                </div>
                            </c:when>
                            <c:when test="${webName2.equals('RewardDetails')}">
                                <div class="title">
                                    <a  href="${root}/reward/show.htm">Reward</a> 
                                    <a class="active1" href="${root}/rewarddetails/show.htm">Reward Details</a> 

                                </div>
                            </c:when>
                        </c:choose>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="header">

                                        </br>
                                        <a href="${root}/reward/add.htm">  <button  name="btnAdd"  class="btn btn-info btn-fill ">ADD NEW</button></a>

                                    </div>

                                    <div class="content table-responsive table-full-width" id="table-wrapper">
                                        <div id="table-scroll">
                                            <table class="table table-hover table-striped">
                                                <thead>
                                                <th>STT</th>
                                                <th>Reward name</th>
                                                <th>Quantity</th>
                                                <th></th>
                                                <th></th>
                                                </thead>
                                                <tbody>
                                                    <c:set var="stt" value="0"> </c:set>
                                                    <c:forEach var="rew" items="${rewardlist}">
                                                    <form action="${root}/reward/delete.htm" method="post">
                                                        <tr>
                                                            <td>${stt=stt+1}</td>
                                                            <td>${rew.rewname}</td>
                                                            <td>${rew.rewardetailses.size()}</td>

                                                            <c:url var="details" value="/reward/details.htm">
                                                                <c:param name="RewardID" value="${rew.rewId}"/>
                                                                <c:param name="STT" value="${stt}"/>
                                                            </c:url> 
                                                            <td><a href="${details}" >Details</a></td>
                                                            <td>
                                                                <input type="hidden" name="rewID" value="${rew.rewId}"/>
                                                                <input class="btn" type="submit" name="action" value="Delete"/>
                                                            </td>
                                                        </tr>
                                                    </form>
                                                </c:forEach>

                                                </tbody>
                                            </table>
                                        </div>
                                    </div>



                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <jsp:include page="footer.jsp"></jsp:include>


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

    <!--  Notifications Plugin    -->
    <script src="${root}/assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="${root}/text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
    <script src="${root}/assets/js/light-bootstrap-dashboard.js"></script>

    <!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
    <script src="${root}/assets/js/demo.js"></script>


</html>

