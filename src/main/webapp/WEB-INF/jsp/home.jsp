<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <title>Hospital Info</title>
        <%@include file="head.jsp"%>
    </head>

    <body>
        <div class="bw">
            <div class="dh container">

                <!-- navigation -->
                <%@include file="navbar.jsp"%>

                <!-- Body Part -->
                <div class="et brf">
                    <div class="bqn">
                        <div class="bqo">
                            <h6 class="bqq">Dashboards</h6>
                        </div>
                    </div>

                    <div class="bop ayg">
                        <div class="boq bor">
                            <div class="axm bpy">
                                <input type="text" class="form-control bsx"
                                       placeholder="Search orders"> <span class="bv bhw"></span>
                            </div>
                        </div>
                        <div class="boq">
                            <div class="ol">
                                <button type="button" class="ce nr">
                                    <span class="bv bji"></span>
                                </button>
                                <button type="button" class="ce nr">
                                    <span class="bv bei"></span>
                                </button>
                            </div>
                        </div>
                    </div>

                    <div>
                        <h4>${message}</h4>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
        <%@include file="footer.jsp"%>
    </body>
</html>