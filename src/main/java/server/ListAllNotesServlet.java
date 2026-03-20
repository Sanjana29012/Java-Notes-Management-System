package server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.DBConnect;

/**
  Servlet implementation class ListAllNotesServlet
 */
@WebServlet("/ListAllNotesServlet")
public class ListAllNotesServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /** @see HttpServlet#HttpServlet()
  */
 public ListAllNotesServlet() {
  super();
  // TODO Auto-generated constructor stub
 }

 /* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
  *      response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

  ArrayList<String[]> notes = new ArrayList<>();

  try {
   
   DBConnect d = new DBConnect();

   PreparedStatement ps = d.cn.prepareStatement(
     "SELECT * FROM notes ");
   ResultSet rs = ps.executeQuery();

   while (rs.next()) {
    String[] note = new String[6];
    note[0] = rs.getString("noteid");
    note[1] = rs.getString("notename");
    note[2] = rs.getString("notedesc");
    note[3] = rs.getString("notefilename");
    note[4] = rs.getString("uploadbyemail");
    note[5] = rs.getString("uploaddate");
    notes.add(note);
   }

   request.setAttribute("notes", notes);
   request.getRequestDispatcher("ListAllNotes.jsp").forward(request, response);

  } catch (Exception e) {
   e.printStackTrace();
  }
 }

 /*
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
       response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  // TODO Auto-generated method stub
  doGet(request, response);
 }

}