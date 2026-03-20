<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<title>List Notes</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">
<jsp:include page="header.jsp"></jsp:include>

<div class="container mt-4">

<h3>Notes List</h3>

<table class="table table-bordered">
<tr>
<th>ID</th>
<th>Title</th>
<th>Description</th>
<th>File</th>
<th>Upload By</th>
<th>Upload Date</th>
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
<td><%=note[4]%></td>
<td><%=note[5]%></td>
<td>
<a href="./DownloadFileServlet?file=<%=note[3]%>" class="btn btn-success btn-sm">
Download
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


