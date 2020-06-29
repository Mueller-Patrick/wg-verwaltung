<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../assets/Templates/Imports/Global.jsp" %>
    <%@include file="../../assets/Templates/Imports/Fonts.jsp" %>
    <%@include file="../../assets/Templates/Imports/Bootstrap.jsp" %>

    <title>Finanzielles</title>

    <link rel="stylesheet" type="text/css" href="./assets/Styles/Main.css">
    <link rel="stylesheet" type="text/css" href="./assets/Styles/Financial.css">
    <link rel="stylesheet" type="text/css" href="./assets/Styles/Sidebar.css">
</head>
<body onload="validDate()">
<%@include file="../../assets/Templates/Components/Sidebar.jsp" %>
<%@include file="../../assets/Templates/Modal/createFinancial.jsp" %>
<%@include file="../../assets/Templates/Modal/removeFinancial.jsp" %>

<%@include file="../../assets/Contents/Financial.jsp" %>

<script><%@include file="../../assets/Scripts/Sidebar.js" %></script>
<script><%@include file="../../assets/Scripts/Financial.js" %></script>
</body>
</html>
