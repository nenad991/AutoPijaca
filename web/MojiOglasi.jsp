<%-- 
    Document   : MojiOglasi
    Created on : Jun 15, 2017, 5:03:48 PM
    Author     : NenadIvana
--%>
<%@page import="Entity.Oglas"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="back6">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Moji oglasi</title>
        <link rel="stylesheet" type="text/css" href="Css/MojiOglasiStilizacija.css">
        <link rel="stylesheet" type="text/css" href="Css/navBarStilizacija.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="JS/JsPocetna.js" ></script>
    </head>
     <body onload="vreme()">
        <div class='fadein'>
            <div id="log"> <h4>Ulogovani kao:<%=session.getAttribute("koris")%>.<div id="sat"></div></h4></div>         
            <div class="scrollmenu">
                <a href="Pocetna.jsp">Pocetna</a>
                <a href="KorisnikInformacije.jsp">Korisnicke informacije</a>
                <a href="oglasUlogovan.jsp">Oglasi</a>
                <a href="DodajOglas.jsp">+dodaj oglas</a>
                <a href="MojiOglasi.jsp">Moji oglasi</a>
            </div>
            <br/>          
            <h3 align="center"><i>Moji oglasi:</i></h3>
            <% List<Korisnik> koris = (List<Korisnik>) session.getAttribute("koris");%>  
            <% for (Korisnik kor : koris) {
                    Set<Oglas> oglas = kor.getOglases();
                    for (Oglas oglasi : oglas) {%>  
            <form action="oglasInformacijeUlogovan.jsp" method="post">
                <div id="oglas" align="center">        
                    <p> 
                        <img src="<%=oglasi.getSlika()%>" height="120px" width="200px" align="left" /><br/>
                        <b>Proizvodjac:</b> <%=oglasi.getProizvodjac()%><br/>
                        <b> Model:</b> <%=oglasi.getModel()%><br/>
                        <b>Godiste:</b> <%=oglasi.getGodinaProizvodnje()%><br/>
                        <b>Cena vozila:</b> <%=oglasi.getCena()%> Evra<br/>
                        <input type="hidden" value="<%=oglasi.getOglasId()%>" name="id">
                        <input type="submit" value="Detaljnije...">
                    </p>
                </div>
            </form>
              <%}%>
           <%}%>
        </div>
    </body>
</html>
