<%@ page language="java" contentType="text/html;
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Details</title>
        <style type="text/css">

            legend {
                font-size: 20px;
            }

            .resultTable {
                width: 50%;
            }

            .resultTable td, .resultTable th {
                border: 1px solid #565454;
            }


        </style>
    </head>
    <body>

        <fieldset>
        <legend>File Details</legend>
            <table class="resultTable">
                <tr>
                    <th>Line ID</th>
                    <th>Line length</th>
                    <th>Average word length</th>
                    <th>Shortest word</th>
                    <th>Longest word</th>
                </tr>
                <c:forEach items="${details}" var="det">
                    <tr>
                        <td>${det.lineId}</td>
                        <td>${det.lineLength}</td>
                        <td>${det.averageWordLength}</td>
                        <td>${det.shortestWord}</td>
                        <td>${det.longestWord}</td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>

    </body>
</html>