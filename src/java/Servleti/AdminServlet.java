package Servleti;
import Dao.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author NenadIvana
 * Servlet se koristi za dodavanje nove boje ,godista i registracije i podatci 
 * se vide u padajucim listama u DodajOglas.jsp .Na osnovu stavke koja se dodaje 
 * if uslovi prikazuju poruke sa uspesnim promenama.
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>AdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (request.getParameter("boja") != null) {
                AdminDao.dodajBoju(request.getParameter("boja"));
                out.println("<h2>Nova boja je dodata!</h2>");
                out.println("<a href=\"AdminStranica.jsp\">Vrati se na pocetnu stranicu</a>");
            }
            if (request.getParameter("god") != null) {
                AdminDao.dodajGodiste(request.getParameter("god"));
                out.println("<h2>Novo godiste je dodato u bazu!</h2>");
                out.println("<a href=\"AdminStranica.jsp\">Vrati se na pocetnu stranicu</a>");
            }
            if (request.getParameter("reg") != null) {
                AdminDao.dodajRegistraciju(request.getParameter("reg"));
                out.println("<h2>Novo trajanje registracije je dodato!</h2>");
                out.println("<a href=\"AdminStranica.jsp\">Vrati se na pocetnu stranicu</a>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
