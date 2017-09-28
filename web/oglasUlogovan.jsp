<%-- 
    Document   : oglasUlogovan
    Created on : Jul 4, 2017, 7:16:58 PM
    Author     : NenadIvana
--%>
<%@page import="Dao.ProizvodjacDao"%>
<%@page import="Entity.Proizvodjac"%>
<%@page import="Dao.MetodeTabelaDao"%>
<%@page import="Dao.OglasDao"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Oglas"%>
<%@page import="Entity.GodinaProizvodnje"%>
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
         <script src="JS/JsDodajOglas.js" ></script>
    </head>
    <body onload="vreme()">
        <div class='fadein'>
            <div id="log"> <h4>Ulogovani kao:<%=session.getAttribute("koris")%>.<div id="sat"></div></h4> </div>         
            <div class="scrollmenu">
                <a href="Pocetna.jsp">Pocetna</a>
                <a href="KorisnikInformacije.jsp">Korisnicke informacije</a>
                <a href="oglasUlogovan.jsp">Oglasi</a>
                <a href="DodajOglas.jsp">+dodaj oglas</a>
                <a href="MojiOglasi.jsp">Moji oglasi</a>
            </div>
            <br/>   
             <h3 align="center">Oglasi u ponudi:</h3>
            <% List<GodinaProizvodnje> godina = MetodeTabelaDao.selektujGodProizvodnje();
            List<Proizvodjac> proizvodjac = ProizvodjacDao.selektujProizvodjaca();
            %>
            <form action="oglasPretragaUlogovan.jsp" method="post">
                <select  id="marka" name="marka" requred>
                                    <option value="">--Izaberi marku--</option>
                                    <% for (Proizvodjac pro : proizvodjac) {%>
                                    <option value="<%=pro.getProizvodjacId()%>"><%=pro.getProizvodjacIme()%> </option><%}%>
                                </select>
                                <br/>  
                           <select id="model" name="model" required></select>
                           <br/>  
                <select name="proizvodnja" required>
                    <option value="">--Izaberi godiste--</option> 
                    <% for (GodinaProizvodnje god : godina) {%>
                    <option value="<%=god.getGodinaProizvodnjeId()%>"><%=god.getGodinaProizvodnje()%>
                    </option>
                    <%}%>
                </select>
                 <br/> <br/>
                <input type="submit" value="Pretrazi detaljnije">
            </form>
            <div align="center">
                <form action="oglasSortiranjeUlogovan.jsp" method="get">
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
                List<Oglas> oglas = OglasDao.selektujOglase();
                for (Oglas oglasi : oglas) {%>
            <form action="oglasInformacijeUlogovan.jsp" method="post">
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
        </div>
    </body>
</html>