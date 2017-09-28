<%-- 
    Document   : oglasSortiranje
    Created on : Jul 6, 2017, 7:07:16 PM
    Author     : NenadIvana
--%>
<%@page import="Dao.OglasDao"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Oglas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="back6">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oglasi</title>
        <link rel="stylesheet" type="text/css" href="Css/MojiOglasiStilizacija.css">
        <link rel="stylesheet" type="text/css" href="Css/navBarStilizacija.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="JS/JsPocetna.js" ></script>
         <script>function login() { alert("Kako bi ste dodali oglas morate se ulogovati!!");} </script>
    </head>
    <body>
           <div class='fadein'>      
            <div class="scrollmenu">
                <a href="index.html">Pocetna</a>    
                <a href="Oglasi.jsp">Oglasi</a>
                <a href="#" onclick="login()">+dodaj oglas</a>      
            <a href="#" id="login">Ulogujte se</a>
            </div>
              <div id="avatar" style="display: none;">
                <form name="forma" method="post" action="PocetnaServlet">
                    <table class="table1">
                        <tr>
                            <td><input type="text" name="korime" placeholder="Unesite korisnicko ime" required></td>
                        </tr>
                        <tr>
                            <td><input type="password" name="sifra" placeholder="Unesite sifru" required></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" value="Prijava"></td>
                        </tr>
                    </table>
                </form>
            </div>    
        <h3 align="center">Oglasi u ponudi:</h3>
            <div align="center">
                <form action="oglasSortiranje.jsp" method="get">
                    <select name="vrednost" required>
                        <option value="">--Sortiraj--</option> 
                        <option value="1">po ceni opadajuce </option>
                        <option value="2">po ceni rastuce </option>
                        <option value="3">po proizvodjacu </option>
                    </select>
                    <input type="submit" value="sortiraj">
                </form>
            </div>
            <%
                if (Integer.parseInt(request.getParameter("vrednost")) == 1) {
                    List<Oglas> oglass = OglasDao.selektujPoCeniOpadajuce();
                    for (Oglas oglasi : oglass) {%>
            <form action="oglasInformacije.jsp" method="post">
                <div id="oglas" align="center">        
                    <p><img src="<%=oglasi.getSlika()%>" height="120px" width="200px" align="left" /><br/>
                        <b> Proizvodjac: </b> <%=oglasi.getProizvodjac()%><br/>
                        <b> Model:</b> <%=oglasi.getModel()%><br/>
                        <b>Godiste:</b> <%=oglasi.getGodinaProizvodnje()%><br/>
                        <b>Cena vozila:</b> <%=oglasi.getCena()%> Evra<br/>
                        <input type="hidden" value="<%=oglasi.getOglasId()%>" name="id">
                        <input type="submit" value="Detaljnije..." ></p>
                </div>
            </form>
            <%}%> 
            <%}%>
            <%
                if (Integer.parseInt(request.getParameter("vrednost")) == 2) {
                    List<Oglas> oglas = OglasDao.selektujPoCeniRastuce();
                    for (Oglas oglasi : oglas) {%>
            <form action="oglasInformacije.jsp" method="post">
                <div id="oglas" align="center">        
                    <p><img src="<%=oglasi.getSlika()%>" height="120px" width="200px" align="left" /><br/>
                        <b> Proizvodjac: </b> <%=oglasi.getProizvodjac()%><br/>
                        <b> Model:</b> <%=oglasi.getModel()%><br/>
                        <b>Godiste:</b> <%=oglasi.getGodinaProizvodnje()%><br/>
                        <b>Cena vozila:</b> <%=oglasi.getCena()%> Evra<br/>
                        <input type="hidden" value="<%=oglasi.getOglasId()%>" name="id">
                        <input type="submit" value="Detaljnije..." ></p>
                </div>
            </form>
            <%}%> 
            <%}%>
            <%
                if (Integer.parseInt(request.getParameter("vrednost")) == 3) {
                    List<Oglas> oglases = OglasDao.selektujPoNazivu();
                    for (Oglas oglasi : oglases) {%>
            <form action="oglasInformacije.jsp" method="post">
                <div id="oglas" align="center">        
                    <p><img src="<%=oglasi.getSlika()%>" height="120px" width="200px" align="left" /><br/>
                        <b> Proizvodjac: </b> <%=oglasi.getProizvodjac()%><br/>
                        <b> Model:</b> <%=oglasi.getModel()%><br/>
                        <b>Godiste:</b> <%=oglasi.getGodinaProizvodnje()%><br/>
                        <b>Cena vozila:</b> <%=oglasi.getCena()%> Evra<br/>
                        <input type="hidden" value="<%=oglasi.getOglasId()%>" name="id">
                        <input type="submit" value="Detaljnije..." ></p>
                </div>
            </form>
            <%}%> 
            <%}%>
        </div>
    </body>
</html>

