<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>List Notes</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<jsp:include page="header.jsp"></jsp:include>



<body class="bg-light">

<div class="container mt-4">

<h3>Notes List</h3>

<table class="table table-bordered">
<tr>
<th>ID</th>
<th>Title</th>
<th>Description</th>
<th>File</th>
<th>Action</th>
</tr>

<%
ArrayList<String[]> notes = (ArrayList<String[]>) request.getAttribute("notes");

if(notes != null){
for(String[] note : notes){
%>

<tr>
<td><%=note[0]%></td>
<td><%=note[1]%></td>
<td><%=note[2]%></td>
<td><%=note[3]%></td>

<td>
<a href="DeleteNoteServlet?id=<%=note[0]%>" class="btn btn-danger btn-sm">
Delete
</a>
</td>

</tr>

<%
}
}
%>

</table>

</div>

</body>
</html>


