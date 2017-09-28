package Servleti;

import Dao.KorisnikDao;
import Entity.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author NenadIvana
 *
 * Servlet se koristi za proveru login forme tako da korisnicko ime i sifra
 * korisnika mora da se poklapa da bi servlet prebacio na stranicu Pocetna.jsp u
 * suprotnom servlet prikazuje da ste uneli pogresne podatke takodje ima obradu
 * ukoliko se administrator loguje sa svojim podatcima servlet ga prebacuje na
 * AdminStranica.jsp
 */
@WebServlet(name = "PocetnaServlet", urlPatterns = {"/PocetnaServlet"})
public class PocetnaServlet extends HttpServlet {
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
            RequestDispatcher rd = null;
            HttpSession sesija = request.getSession(true);
            List<Korisnik> koris = KorisnikDao.selektujInfo(request.getParameter("korime"));
            List<Korisnik> kor = KorisnikDao.selektuj();
            for (Korisnik k : kor) {
                if (request.getParameter("korime").equals(k.getKorisnickoIme())
                        && (request.getParameter("sifra").equals(k.getSifra()))) {
                    sesija.setAttribute("koris", koris);
                    rd = request.getRequestDispatcher("/Pocetna.jsp");
                    rd.forward(request, response);
                    break;
                }
                else if (request.getParameter("korime").equals("admin")
                        && (request.getParameter("sifra").equals("admin"))) {
                    sesija.setAttribute("koris", koris);
                    rd = request.getRequestDispatcher("/AdminStranica.jsp");
                    rd.forward(request, response);
                    break;
                }
            }
            out.print("<h1><i> Pogresno korisnicko ime ili sifra.</i></h1>");
             out.println("<a href=\"index.html\">Vrati se na pocetnu stranicu</a>");
            out.println("<br/>");
            out.println("<a href=\"Oglasi.jsp\">Idi na oglase</a>");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
