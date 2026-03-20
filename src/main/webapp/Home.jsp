<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ToDo Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="p-4">
<jsp:include page="header.jsp"></jsp:include>

<%
if(request.getParameter("t")!=null)
{%>
 
 <div class="container">
    
    <div class="alert alert-success" role="alert">
      ✅ Your action was completed successfully!
    </div>

  </div>
<%}

%>

</body>
</html>