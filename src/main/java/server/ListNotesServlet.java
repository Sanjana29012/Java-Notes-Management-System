package server;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import dao.DBConnect;

@WebServlet("/ListNotesServlet")
public class ListNotesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<String[]> notes = new ArrayList<>();

        try {
            DBConnect d = new DBConnect();

            HttpSession session = request.getSession();
String email = (String) session.getAttribute("uemail");

PreparedStatement ps = d.cn.prepareStatement(
    "SELECT * FROM notes WHERE uploadbyemail=?"
);

ps.setString(1, email);

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
            request.getRequestDispatcher("listNotes.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
