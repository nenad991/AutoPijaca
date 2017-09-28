package Servleti;
import Dao.KorisnikDao;
import Entity.Korisnik;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author NenadIvana
 *
 * Servlet se koristi za dodavanje novog korisnika u bazu. servlet proverava da
 * li je zauzeto korisnicko ime ili email adresa ukoliko jeste prikazuje poruku
 * da je jedno od navedenih zauzeto,ukoliko nije salje poruku o uspesnoj
 * registraciji i nudi vam da odete na index.html gde se mozete ulogovati.
 */
@WebServlet(name = "RegistarServlet", urlPatterns = {"/RegistarServlet"})
public class RegistarServlet extends HttpServlet {
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
            List<Korisnik> kor = KorisnikDao.selektuj();
            String user = request.getParameter("korime");
            String mail = request.getParameter("email");
            String us = null;
            String mai = null;
            for (Korisnik k : kor) {
                if (user.equals(k.getKorisnickoIme())) {
                    out.print("<h1>Korisnicko ime je zauzeto.</h1>");
                    us = k.getKorisnickoIme();
                }
                if (mail.equals(k.getEmail())) {
                    out.print("<h1>Email je zauzet.</h1>");
                    mai = k.getEmail();
                }
            }
            if (!user.equals(us) && !mail.equals(mai)) {
                KorisnikDao.ubaciKorisnika(request.getParameter("ime"), request.getParameter("prezime"), request.getParameter("datum"),
                        request.getParameter("pol"), request.getParameter("zemlja"), request.getParameter("korime"),
                        request.getParameter("sifra"), request.getParameter("email"), request.getParameter("telefon"));
                out.print("<h1>Registracija uspesna!</h1>");
            }
            out.println("<a href=\"index.html\">Vrati se na pocetnu stranicu</a>");
            out.println("<br/>");
            out.println("<a href=\"Register.jsp\">Vrati se na registraciju</a>");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
