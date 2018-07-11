<%-- 
    Document   : index
    Created on : Jul 11, 2018, 5:07:30 PM
    Author     : zohai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome To-Do List Application</title>
    </head>
    <body>
      <jsp:forward page="/NoteServlet?action=listNote" />
    </body>
</html>
