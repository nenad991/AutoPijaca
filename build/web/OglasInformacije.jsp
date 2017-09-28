<%-- 
    Document   : OglasInformacije
    Created on : Jun 27, 2017, 7:17:47 PM
    Author     : NenadIvana
--%>
<%@page import="Dao.OglasDao"%>
<%@page import="Entity.Oglas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="back6">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detaljni oglas</title>
        <link rel="stylesheet" type="text/css" href="Css/OglasiInformacijeStilizacija.css">
        <link rel="stylesheet" type="text/css" href="Css/navBarStilizacija.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="JS/JsPocetna.js" ></script>
        <script>
            function uvecano(x) {
                x.style.height = "600px";
                x.style.width = "800px";
            }
            function normalno(x) {
                x.style.height = "400px";
                x.style.width = "600px";
            }
            function login()
            { 
                alert("Kako bi ste dodali oglas morate se ulogovati!!");
            }
        </script>
    </head>
    <body>
         <div class='fadein'>      
            <div class="scrollmenu">
                <a href="index.html">Pocetna</a>    
                <a href="Oglasi.jsp">Oglasi</a>  
                <a href="#" onclick="login()" >+dodaj oglas</a> 
                <a href="#" id="login" align="right">Ulogujte se</a>
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
             <br/> <br/><br/> <br/><br/> <br/>
        <h3 align="center">Detaljne informacije o trenutnom oglasu:</h3>
        <%
            List<Oglas> oglass = OglasDao.selektujOglasId(Integer.parseInt(request.getParameter("id")));
            for (Oglas oglasi : oglass) {%>
        <div id="oglas" align="center">  
            <p>  <img src="<%=oglasi.getSlika()%>" onmouseover="uvecano(this)" onmouseout="normalno(this)" align="left" /><br/>
                <b>Proizvodjac:</b> <%=oglasi.getProizvodjac()%><br/>
                <b>Model:</b> <%=oglasi.getModel()%><br/>
                <b>Godiste:</b> <%=oglasi.getGodinaProizvodnje()%><br/>
                <b>Karoserija:</b> <%=oglasi.getKaroserija()%><br/>
                <b>Kubikaza:</b> <%=oglasi.getKubikaza()%><br/>
                <b>Gorivo:</b> <%=oglasi.getGorivo()%><br/>
                <b> Snaga:</b> <%=oglasi.getSnagaKs()%><br/>
                <b>Kilometraza:</b> <%=oglasi.getKilometraza()%><br/>
                <b>Emisiona klasa:</b> <%=oglasi.getEmisionaKlasaMotora()%><br/>
                <b>Pogon:</b> <%=oglasi.getPogon()%><br/>
                <b>Menjac:</b> <%=oglasi.getMenjac()%><br/>
                <b>Broj vrata:</b> <%=oglasi.getBrojVrata()%><br/>
                <b>Broj sedista:</b> <%=oglasi.getBrojSedista()%><br/>
                <b>Strana volana:</b> <%=oglasi.getStranaVolana()%><br/>
                <b>Klima:</b> <%=oglasi.getKlima()%><br/>
                <b>Boja vozila:</b> <%=oglasi.getBoja()%><br/>
                <b>Registrovan:</b> <%=oglasi.getRegistrovanDo()%><br/>
                <b>Ostecenje:</b> <%=oglasi.getOstecenje()%><br/>
                <b>Poreklo vozila:</b> <%=oglasi.getPorekloVozila()%><br/>
                <b>Telefon prodavca:</b> <%=oglasi.getTelefonProdavca()%><br/>
                <b>Cena vozila:</b> <%=oglasi.getCena()%> Evra</p>
        </div>
        <%}%>
        </div>
    </body>
</html>
