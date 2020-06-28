<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../assets/Templates/Imports/Global.jsp" %>
    <%@include file="../../assets/Templates/Imports/Fonts.jsp" %>
    <%@include file="../../assets/Templates/Imports/Bootstrap.jsp" %>

    <title>Einkaufsliste</title>
    
    <link rel="stylesheet" type="text/css" href="./assets/Styles/Main.css">
    <link rel="stylesheet" type="text/css" href="./assets/Styles/Shopping.css">
    <link rel="stylesheet" type="text/css" href="./assets/Styles/Sidebar.css">
</head>
<body onload="validDate()">
<%@include file="../../assets/Templates/Components/Sidebar.jsp" %>
<%@include file="../../assets/Templates/Modal/createShopping.jsp" %>
<%@include file="../../assets/Templates/Modal/doneShopping.jsp" %>
<%@include file="../../assets/Templates/Modal/removeShopping.jsp" %>

<%@include file="../../assets/Contents/Shopping.jsp" %>

<script><%@include file="../../assets/Scripts/Sidebar.js" %></script>
<script><%@include file="../../assets/Scripts/Modal.js" %></script>
<script><%@include file="../../assets/Scripts/Shopping.js" %></script>
</body>
</html>
