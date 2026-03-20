package server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Part;

import dao.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveNoteServlet
 */
@WebServlet("/SaveNoteServlet")
@MultipartConfig
public class SaveNoteServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  
  String title = request.getParameter("title");
        String description = request.getParameter("description");

        // Get uploaded file
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        // Upload directory path
//        String uploadPath = "C:\\Users\\vueservice\\web3\\web1\\src\\main\\webapp\\uploads\\";

        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

        
        
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Save file
        File file = new File(uploadPath, fileName);

        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath());
        }

        try {
         HttpSession session = request.getSession();
         DBConnect d = new DBConnect();
         d.QueryExecuter(
        "insert into notes(notename,notedesc,notefilename,uploadbyemail) values('"
         +title+"','"+description+"','"+fileName+"','"+ session.getAttribute("uemail")+"') ");
        
          response.sendRedirect("Home.jsp?t=1");
        }
        
        
        catch(Exception e)
        {
         //out.println(e);
        }
        

        // Redirect after save
       
 
 
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  doGet(request, response);
 }

}