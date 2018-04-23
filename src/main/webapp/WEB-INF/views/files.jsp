<%@ page language="java" contentType="text/html;
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Files</title>
        <style type="text/css">

            legend {
                font-size: 20px;
            }

            .resultTable {
                width: 50%;
            }

            .resultTable td, .resltTable th {
                border: 1px solid #565454;
            }

        </style>
    </head>

    <body>

        <fieldset>
            <legend>Files List</legend>
            <table class="resultTable">
                <tr>
                    <th>ID</th>
                    <th>File name</th>
                </tr>
                <c:forEach items="${files}" var="file">
                    <tr>
                        <td>${file.fileId}</td>
                        <td><a href = "<s:url value = "details/${file.fileId}"/>">${file.fileName}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>


    </body>
</html>