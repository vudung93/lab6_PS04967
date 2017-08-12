<%-- 
    Document   : menu
    Created on : May 31, 2017, 8:32:25 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <c:set var="root" value="${pageContext.servletContext.contextPath}"/>
    </head>
    <body>
        <div class="sidebar" data-color="azure" data-image="${root}/assets/img/sidebar-5.jpg">

            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="#" class="simple-text">
                        WOW
                    </a>
                </div>

                <ul class="nav">
                    <c:choose>
                        <c:when test="${webName.equals('Dashboard')}">
                            <li class="active">
                                <a href="${root}/home.htm">
                                    <i class="pe-7s-graph"></i>
                                    <p><spring:message code="label.menu.dashboard" /></p>
                                </a>
                            </li>
                            <li>
                                <a href="${root}/employee/show.htm">
                                    <i class="pe-7s-user"></i>
                                    <p><spring:message code="label.menu.employee" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/department/show.htm">
                                    <i class="pe-7s-users"></i>
                                    <p><spring:message code="label.menu.department" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/reward/show.htm">
                                    <i class="pe-7s-medal"></i>
                                    <p><spring:message code="label.menu.reward" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/discipline/show.htm">
                                    <i class="pe-7s-hammer"></i>
                                    <p><spring:message code="label.menu.discipline" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/account.htm">
                                    <i class="pe-7s-id"></i>
                                    <p><spring:message code="label.menu.account" /></p>
                                </a>
                            </li>
                        </c:when>

                        <c:when test="${webName.equals('Employee')}" >
                            <li >
                                <a href="${root}/home.htm">
                                    <i class="pe-7s-graph"></i>
                                    <p><spring:message code="label.menu.dashboard" /></p>
                                </a>
                            </li>
                            <li class="active">
                                <a href="${root}/employee/show.htm">
                                    <i class="pe-7s-user"></i>
                                    <p><spring:message code="label.menu.employee" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/department/show.htm">
                                    <i class="pe-7s-users"></i>
                                    <p><spring:message code="label.menu.department" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/reward/show.htm">
                                    <i class="pe-7s-medal"></i>
                                    <p><spring:message code="label.menu.reward" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/discipline/show.htm">
                                    <i class="pe-7s-hammer"></i>
                                    <p><spring:message code="label.menu.discipline" /></p>
                                </a>
                               
                            </li>

                            <li>
                                <a href="${root}/account.htm">
                                    <i class="pe-7s-id"></i>
                                    <p><spring:message code="label.menu.account" /></p>
                                </a>
                            </li>
                        </c:when> 
                            
                        <c:when test="${webName.equals('Department')}" >
                            <li>
                                <a href="${root}/home.htm">
                                    <i class="pe-7s-graph"></i>
                                    <p><spring:message code="label.menu.dashboard" /></p>
                                </a>
                            </li>
                            <li>
                                <a href="${root}/employee/show.htm">
                                    <i class="pe-7s-user"></i>
                                    <p><spring:message code="label.menu.employee" /></p>
                                </a>
                            </li>

                            <li class="active">
                                <a href="${root}/department/show.htm">
                                    <i class="pe-7s-users"></i>
                                    <p><spring:message code="label.menu.department" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/reward/show.htm">
                                    <i class="pe-7s-medal"></i>
                                    <p><spring:message code="label.menu.reward" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/discipline/show.htm">
                                    <i class="pe-7s-hammer"></i>
                                    <p><spring:message code="label.menu.discipline" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/account.htm">
                                    <i class="pe-7s-id"></i>
                                    <p><spring:message code="label.menu.account" /></p>
                                </a>
                            </li>
                        </c:when>    
                            
                        <c:when test="${webName.equals('Reward')}" >
                            <li>
                                <a href="${root}/home.htm">
                                    <i class="pe-7s-graph"></i>
                                    <p><spring:message code="label.menu.dashboard" /></p>
                                </a>
                            </li>
                            <li>
                                <a href="${root}/employee/show.htm">
                                    <i class="pe-7s-user"></i>
                                    <p><spring:message code="label.menu.employee" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/department/show.htm">
                                    <i class="pe-7s-users"></i>
                                    <p><spring:message code="label.menu.department" /></p>
                                </a>
                            </li>

                            <li  class="active">
                                <a href="${root}/reward/show.htm">
                                    <i class="pe-7s-medal"></i>
                                    <p><spring:message code="label.menu.reward" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/discipline//show.htm">
                                    <i class="pe-7s-hammer"></i>
                                    <p><spring:message code="label.menu.discipline" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/account.htm">
                                    <i class="pe-7s-id"></i>
                                    <p><spring:message code="label.menu.account" /></p>
                                </a>
                            </li>
                        </c:when>
                            
                        <c:when test="${webName.equals('Discipline')}" >
                            <li>
                                <a href="${root}/home.htm">
                                    <i class="pe-7s-graph"></i>
                                    <p><spring:message code="label.menu.dashboard" /></p>
                                </a>
                            </li>
                            <li>
                                <a href="${root}/employee/show.htm">
                                    <i class="pe-7s-user"></i>
                                    <p><spring:message code="label.menu.employee" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/department/show.htm">
                                    <i class="pe-7s-users"></i>
                                    <p><spring:message code="label.menu.department" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/reward/show.htm">
                                    <i class="pe-7s-medal"></i>
                                    <p><spring:message code="label.menu.reward" /></p>
                                </a>
                            </li>

                            <li class="active">
                                <a href="${root}/discipline/show.htm">
                                    <i class="pe-7s-hammer"></i>
                                    <p><spring:message code="label.menu.discipline" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/account.htm">
                                    <i class="pe-7s-id"></i>
                                    <p><spring:message code="label.menu.account" /></p>
                                </a>
                            </li>
                        </c:when>    
                            
                        <c:when test="${webName.equals('Account')}" >
                            <li>
                                <a href="${root}/home.htm">
                                    <i class="pe-7s-graph"></i>
                                    <p><spring:message code="label.menu.dashboard" /></p>
                                </a>
                            </li>
                            <li>
                                <a href="${root}/employee/show.htm">
                                    <i class="pe-7s-user"></i>
                                    <p><spring:message code="label.menu.employee" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/department/show.htm">
                                    <i class="pe-7s-users"></i>
                                    <p><spring:message code="label.menu.department" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/reward/show.htm">
                                    <i class="pe-7s-medal"></i>
                                    <p><spring:message code="label.menu.reward" /></p>
                                </a>
                            </li>

                            <li>
                                <a href="${root}/discipline/show.htm">
                                    <i class="pe-7s-hammer"></i>
                                    <p><spring:message code="label.menu.discipline" /></p>
                                </a>
                            </li>

                            <li  class="active">
                                <a href="${root}/account.htm">
                                    <i class="pe-7s-id"></i>
                                    <p><spring:message code="label.menu.account" /></p>
                                </a>
                            </li>
                        </c:when>    
                            
                            
                    </c:choose> 
                </ul>

            </div>
        </div>
    </body>
</html>
