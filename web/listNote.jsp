<%-- 
    Document   : listNote
    Created on : Jul 11, 2018, 5:40:42 PM
    Author     : zohai
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>To-DO list application</title>
    </head>
    <body>
        <h1>Welcome to TO-DO list application </h1> <br/> <br/>
        <table border=1 >
            <thead>
                <tr>
                    <th>Note ID</th>
                    <th>Note Subject</th>
                    <th>Note Description</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${notes}" var="note">
                    <tr>
                        <td><c:out value="${note.noteID}" /></td>
                        <td><c:out value="${note.NOTE_SUBJECT}" /></td>
                        <td><c:out value="${note.NOTE_DESCRIPTION}" /></td>
                        <td><a href="NoteServlet?action=edit&noteID=<c:out value="${note.noteID}"/>">Update</a></td>
                        <td><a href="NoteServlet?action=delete&noteID=<c:out value="${note.noteID}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="NoteServlet?action=insert">Add Note</a></p>
        <p><a href="NoteServlet?action=deleteAllNotes">Delete all notes</a></p>
        <br> <br>
        <h6>&COPY; Developed by Zohaib Ahmed</h6>
    </body>
</html>
