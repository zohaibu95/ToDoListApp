<%-- 
    Document   : note
    Created on : Jul 11, 2018, 5:40:53 PM
    Author     : zohai
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Note</title>
    </head>
    <body>
         <form method="POST" action="NoteServlet" name="formAddNote">
            Note ID : <input type="text" readonly="readonly" name="noteID"
                value="<c:out value="${note.noteID}" />" /> <br /> 
            Subject : <input
                type="text" name="NOTE_SUBJECT"
                value="<c:out value="${note.NOTE_SUBJECT}" />" /> <br /> 
            Description : <input
                type="text" name="NOTE_DESCRIPTION"
                value="<c:out value="${note.NOTE_DESCRIPTION}" />" /> <br /> 
            <br /> 
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
