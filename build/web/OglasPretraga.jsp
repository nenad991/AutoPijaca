<%-- 
    Document   : OglasPretraga
    Created on : Jun 29, 2017, 5:26:56 PM
    Author     : NenadIvana
--%>
<%@page import="Dao.ProizvodjacDao"%>
<%@page import="Entity.Proizvodjac"%>
<%@page import="Dao.MetodeTabelaDao"%>
<%@page import="Entity.GodinaProizvodnje"%>
<%@page import="Entity.GodinaProizvodnje"%>
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
         <script src="JS/JsDodajOglas.js" ></script>
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
         <% List<GodinaProizvodnje> godina = MetodeTabelaDao.selektujGodProizvodnje();
            List<Proizvodjac> proizvodjac = ProizvodjacDao.selektujProizvodjaca();
            %>
            <form action="OglasPretraga.jsp" method="post">
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
        <%
            List<Oglas> oglas =  OglasDao.pretraga(
                 Integer.parseInt(request.getParameter("marka")),Integer.parseInt(request.getParameter("model")),
                                        Integer.parseInt(request.getParameter("proizvodnja")));
            for (Oglas oglasi : oglas) {%>
        <form action="OglasInformacije.jsp" method="post">
            <div id="oglas" align="center">        
                <p> <img src="<%=oglasi.getSlika()%>" height="120px" width="200px" align="left" /><br/>
                    <b> Proizvodjac: </b> <%=oglasi.getProizvodjac()%><br/>
                    <b> Model:</b> <%=oglasi.getModel()%><br/>
                    <b>Godiste:</b> <%=oglasi.getGodinaProizvodnje()%><br/>
                    <b>Cena vozila:</b> <%=oglasi.getCena()%> Evra<br/>
                    <input type="hidden" value="<%=oglasi.getOglasId()%>" name="id">
                    <input type="submit" value="Detaljnije..." >
                </p>
            </div>
        </form>
        <%}%>
        </div>
    </body>
</html>
