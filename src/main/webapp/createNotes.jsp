<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Note</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>


<body class="bg-light">



<!-- Edit Note Form -->
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow">
                <div class="card-header bg-warning">
                    <h4 class="mb-0">New Note</h4>
                </div>

                <div class="card-body">
                    <form action="./SaveNoteServlet" 
                    method="post" enctype="multipart/form-data">

                        <!-- Note Title -->
                        <div class="mb-3">
                            <label class="form-label">Note Title</label>
                            <input type="text" name="title" class="form-control" value="Sample Note Title" required>
                        </div>

                        <!-- Description -->
                        <div class="mb-3">
                            <label class="form-label">Description</label>
                            <textarea name="description" class="form-control" rows="4" required>
Sample description of the note
                            </textarea>
                        </div>

                        <!-- File Upload -->
                        <div class="mb-3">
                            <label class="form-label">Upload File</label>
                            <input type="file" name="file" class="form-control">
                        </div>

                        <!-- Buttons -->
                        <div class="d-flex justify-content-between">
                            <a href="Home.jsp" class="btn btn-secondary">Cancel</a>
                            <button type="submit" class="btn btn-success">Upload Note</button>
                        </div>

                    </form>
                </div>

            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>