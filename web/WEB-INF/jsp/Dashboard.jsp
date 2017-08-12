<%-- 
    Document   : home
    Created on : May 30, 2017, 2:07:17 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
            .box{
                border-radius: 4px;
                padding: 10px;
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
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="card card-inverse card-info">
                                        <div class="box  bg-info text-center" style="background-color: #009efb; color: #fff;">
                                            <h1 class="font-light text-white">${quantitiesEmp}</h1>
                                        <h6 class="text-white">Employee</h6>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="card card-inverse card-info">
                                    <div class="box bg-info text-center" style="background-color: #7460ee; color: #fff;">
                                        <h1 class="font-light text-white">${quantitiesDep}</h1>
                                        <h6 class="text-white">Department</h6>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="card card-inverse card-info">
                                    <div class="box bg-info text-center" style="background-color: #55ce63; color: #fff;">
                                        <h1 class="font-light text-white">${quantitiesRew}</h1>
                                        <h6 class="text-white">Reward</h6>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-3">
                                <div class="card card-inverse card-info">
                                    <div class="box bg-info text-center" style="background-color: #ffbc34; color: #fff;">
                                        <h1 class="font-light text-white">${quantitiesDis}</h1>
                                        <h6 class="text-white">Discipline</h6>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="header">
                                        <h4 class="title">HR position in the department</h4>
                                    </div>
                                    <div class="content">
                                        <div id="canvas-holder" style="width:100%"><iframe class="chartjs-hidden-iframe" tabindex="-1" style="display: block; overflow: hidden; border: 0px; margin: 0px; top: 0px; left: 0px; bottom: 0px; right: 0px; height: 100%; width: 100%; position: absolute; pointer-events: none; z-index: -1;"></iframe>
                                            <canvas id="chart-area" style="display: block; " >
                                            </canvas>
                                        </div> 
                                    </div>
                                </div>

                            </div>

                            <div class="col-md-8">
                                <div class="card">
                                    <div class="header">
                                        <h4 class="title">Department Rank</h4>
                                    </div>
                                    <div class="content">
                                        <iframe class="chartjs-hidden-iframe" tabindex="-1" style="display: block; overflow: hidden; border: 0px; margin: 0px; top: 0px; left: 0px; bottom: 0px; right: 0px; height: 100%; width: 100%; position: absolute; pointer-events: none; z-index: -1;"></iframe>
                                        <canvas id="canvas" style="display: block; height: 361px; width: 100%;"></canvas> 
                                    </div>
                                </div>

                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="content table-responsive table-full-width" id="table-wrapper">
                                        <table id="myTable" class="table table-hover table-striped">
                                            <thead>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Salary</th>
                                            <th>Gender</th>
                                            <th>Birthday</th>
                                            <th>Email</th>
                                            <th>Department</th>
                                            <th>Point</th>

                                            </thead>
                                            <tbody>

                                                <c:forEach var="emp" items="${top10}">
                                                    <tr>
                                                        <td>${emp.employeeId}</td>
                                                        <td>${emp.name}</td>
                                                        <td>${emp.salary}</td>
                                                        <td>
                                                            <c:if test="${emp.gender eq true}">
                                                                Nam
                                                            </c:if> 
                                                            <c:if test="${emp.gender eq false}">
                                                                Nữ
                                                            </c:if>  
                                                        </td>
                                                        <td>
                                                            <fmt:formatDate value="${emp.birthday}" pattern="yyyy-MM-dd" var="DATE"/>
                                                            ${DATE}
                                                        </td>
                                                        <td>${emp.email}</td>
                                                        <td>${emp.department.depName}</td>
                                                        <td>${emp.rewardetailses.size()-emp.disciplinedetailses.size()}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
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
    <script src="https://www.google-analytics.com/analytics.js"></script>
    <script src="http://www.chartjs.org/dist/2.6.0/Chart.bundle.js"></script>
    <script src="${root}/assets/js/Chart.js"></script>
    <script>



        var config = {
            type: 'pie',
            data: {
                datasets: [{
                        data: [
        ${data1}
                        ],
                        backgroundColor: [
        ${data3}

                        ]

                    }],
                labels: [
        ${data2}
                ]
            },
            options: {
                responsive: true
            }
        };
        ////////////////////

        var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        var color = Chart.helpers.color;
        var barChartData = {
            labels: [${data2}],
            datasets: [
                    {
                    label: 'Năm ${yearOld}',
                    backgroundColor: window.chartColors.red,
                    borderColor: window.chartColors.red,
                    borderWidth: 1,
                    data: [
                        ${data5}
                    ]
                    },
                {
                    label: 'Năm ${yearNew}',
                    backgroundColor: window.chartColors.Teal,
                    borderColor: window.chartColors.Teal,
                    borderWidth: 1,
                    data: [
                        ${data4}
                    ]
                }
                
            ]

        };



        /////////////////////////
        window.onload = function () {
            var ctx = document.getElementById("chart-area").getContext("2d");
            window.myPie = new Chart(ctx, config);





            var ctx2 = document.getElementById("canvas").getContext("2d");
            window.myBar = new Chart(ctx2, {
                type: 'bar',
                data: barChartData,
                options: {
                    responsive: true,
                    legend: {
                        position: 'top',
                    },
                    title: {
                        display: true,
                        text: 'Năm ${yearNew}'
                    }
                }
            });



        };


////////////////////Search Table
        function myFunction() {
            var input, filter, table, tr, td, i;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[1];
                if (td) {
                    if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>

</html>

