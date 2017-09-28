package Servleti;
import Dao.OglasDao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 * @author NenadIvana
 *
 * Servlet se koristi za dodavanje novog oglasa u bazu. Servlet uzima podatke iz
 * dodajOglas.jsp i prosledjuje ih servletu gde on podatke posalje i upise u
 * bazu. Upload sliku posalje u folder PijacaSlike a putanju do slike upise u
 * bazu. Dodati oglas se onda moze pogledati u MojiOglasi.jsp ili Oglasi.jsp
 */
@WebServlet(name = "DodajOglasServlet", urlPatterns = {"/DodajOglasServlet"})
@MultipartConfig(maxFileSize = 16177215) //Upload velicine do 16 MB
public class DodajOglasServlet extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(DodajOglasServlet.class.getCanonicalName());
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
            String path = request.getParameter("destination");
            Part filePart = request.getPart("file");
            String fileName = getFileName(filePart);
            String putanja = "PijacaSlike/".concat(fileName);

            OutputStream outS = new FileOutputStream(new File(path + File.separator + fileName));
            InputStream filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                outS.write(bytes, 0, read);
            }

            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                    new Object[]{fileName, path});

            int kor = Integer.parseInt(request.getParameter("userId"));
            int marka = Integer.parseInt(request.getParameter("marka"));
            int model = Integer.parseInt(request.getParameter("model"));
            int godiste = Integer.parseInt(request.getParameter("proizvodnja"));
            int karos = Integer.parseInt(request.getParameter("karoserija"));
            int kub = Integer.parseInt(request.getParameter("kubikaza"));
            int gorivo = Integer.parseInt(request.getParameter("gorivo"));
            int snaga = Integer.parseInt(request.getParameter("snaga"));
            int km = Integer.parseInt(request.getParameter("kilometraza"));
            int ems = Integer.parseInt(request.getParameter("ems"));
            int pogon = Integer.parseInt(request.getParameter("pogon"));
            int menjac = Integer.parseInt(request.getParameter("menjac"));
            int vrata = Integer.parseInt(request.getParameter("vrata"));
            int sedista = Integer.parseInt(request.getParameter("sedista"));
            int volan = Integer.parseInt(request.getParameter("volan"));
            int klima = Integer.parseInt(request.getParameter("klima"));
            int boja = Integer.parseInt(request.getParameter("boja"));
            int regist = Integer.parseInt(request.getParameter("registrovan"));
            int ostecenje = Integer.parseInt(request.getParameter("ostecenje"));
            int poreklo = Integer.parseInt(request.getParameter("poreklo"));
            String fon = request.getParameter("telefon");
            int cena = Integer.parseInt(request.getParameter("cena"));

            OglasDao.ubaciOglas(kor, marka, model, godiste, karos, kub, gorivo, snaga, km, ems, pogon,
                    menjac, vrata, sedista, volan, klima, boja, regist, ostecenje, poreklo, fon, cena, putanja);

            RequestDispatcher rd = request.getRequestDispatcher("/Pocetna.jsp");
            rd.forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
