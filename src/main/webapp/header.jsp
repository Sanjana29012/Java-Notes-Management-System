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
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">

        <!-- Brand -->
        <a class="navbar-brand" href="#">Centralized College Notes Sharing Platform</a>

        <!-- Toggle Button (Mobile View) -->
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar Links -->
        <div class="collapse navbar-collapse" id="navbarNav">
            
            <!-- Left Side Links -->
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="./ListAllNotesServlet">List all Notes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="createNotes.jsp">Create Note</a>
                </li>
               
                <li class="nav-item">
                    <a class="nav-link" href="./ListNotesServlet">Delete Notes</a>
                </li>
            </ul>

            <!-- Right Side Logout -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link btn btn-danger text-white px-3" href="logout.jsp">Logout</a>
                </li>
            </ul>

        </div>
    </div>
</nav>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<h2> Welcome <%= session.getAttribute("uname") %></h2>
</body>
</html>