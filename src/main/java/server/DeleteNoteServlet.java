package server;

import java.io.IOException;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import dao.DBConnect;

@WebServlet("/DeleteNoteServlet")
public class DeleteNoteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            DBConnect d = new DBConnect();

            PreparedStatement ps = d.cn.prepareStatement(
                "DELETE FROM notes WHERE noteid=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            response.sendRedirect("ListNotesServlet");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}