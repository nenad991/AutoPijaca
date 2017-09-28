package Servleti;
import Dao.KorisnikDao;
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
 * Servlet se koristi za promenu lozinke na zahtev korisnika i prikazuje 
 * poruku da je sifra uspesno promenjena.
 */
@WebServlet(name = "PromenaServlet", urlPatterns = {"/PromenaServlet"})
public class PromenaServlet extends HttpServlet {
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
       // processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            KorisnikDao.promeniLozinku(request.getParameter("pass"), Integer.parseInt(request.getParameter("userId")));     
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PromenaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Lozinka je promenjena!</h2>");
            out.println("<a href=\"Pocetna.jsp\">Vrati se na pocetnu stranicu</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
