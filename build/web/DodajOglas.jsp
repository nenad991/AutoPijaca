<%@page import="Entity.PorekloVozila"%>
<%@page import="Entity.Ostecenje"%>
<%@page import="Entity.RegistrovanDo"%>
<%@page import="Entity.Boja"%>
<%@page import="Entity.Klima"%>
<%@page import="Entity.StranaVolana"%>
<%@page import="Entity.BrojSedista"%>
<%@page import="Entity.BrojVrata"%>
<%@page import="Entity.Menjac"%>
<%@page import="Entity.Pogon"%>
<%@page import="Entity.EmisionaKlasaMotora"%>
<%@page import="Entity.Kilometraza"%>
<%@page import="Entity.SnagaKs"%>
<%@page import="Entity.Gorivo"%>
<%@page import="Entity.Kubikaza"%>
<%@page import="Entity.Karoserija"%>
<%@page import="Dao.MetodeTabelaDao"%>
<%@page import="Entity.GodinaProizvodnje"%>
<%@page import="Dao.ProizvodjacDao"%>
<%@page import="Entity.Proizvodjac"%>
<%@page import="Entity.Oglas"%>
<%@page import="Dao.OglasDao"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="back5">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oglas</title>
        <link rel="stylesheet" type="text/css" href="Css/DodajOglasStilizacija.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="JS/JsDodajOglas.js" ></script>
        <link rel="stylesheet" type="text/css" href="Css/navBarStilizacija.css">
        <script src="JS/JsPocetna.js" ></script>
    </head>
    <body onload="vreme()" >
        <div class='fadein'>
            <div id="log"> <h4>Ulogovani kao:<%=session.getAttribute("koris")%>.<div id="sat"></div></h4>  </div>         
            <div class="scrollmenu">
                <a href="Pocetna.jsp">Pocetna</a>
                <a href="KorisnikInformacije.jsp">Korisnicke informacije</a>
                <a href="oglasUlogovan.jsp">Oglasi</a>
                <a href="DodajOglas.jsp">+dodaj oglas</a>
                <a href="MojiOglasi.jsp">Moji oglasi</a>
            </div>
            <br/>        
            <div id="dodajOglas" align="center">
                <h2>Kako bi ste dodali oglas popunite podatke:</h2>
                <form name="oglas" method="post"  enctype="multipart/form-data" action="DodajOglasServlet">
                    <% List<Korisnik> koris = (List<Korisnik>) session.getAttribute("koris");%>  
                    <% for (Korisnik kor : koris) {%>
                    <input type="hidden" name="userId" value="<%=kor.getKorisnikId()%>">
                    <%}%>
                    <%
                        List<Proizvodjac> proizvodjac = ProizvodjacDao.selektujProizvodjaca();
                        List<GodinaProizvodnje> godina = MetodeTabelaDao.selektujGodProizvodnje();
                        List<Karoserija> karoserijas = MetodeTabelaDao.selektujKaroseriju();
                        List<Kubikaza> kubikazas = MetodeTabelaDao.selektujKubikazu();
                        List<Gorivo> gorivos = MetodeTabelaDao.selektujGorivo();
                        List<SnagaKs> snagaKses = MetodeTabelaDao.selektujSnaga();
                        List<Kilometraza> kilometrazas = MetodeTabelaDao.selektujKilometrazu();
                        List<EmisionaKlasaMotora> emisionaKlasaMotoras = MetodeTabelaDao.selektujEMS();
                        List<Pogon> pogons = MetodeTabelaDao.selektujPogon();
                        List<Menjac> menjacs = MetodeTabelaDao.selektujMenjac();
                        List<BrojVrata> brojVratas = MetodeTabelaDao.selektujVrata();
                        List<BrojSedista> brojSedistas = MetodeTabelaDao.selektujSedista();
                        List<StranaVolana> stranaVolanas = MetodeTabelaDao.selektujVolan();
                        List<Klima> klimas = MetodeTabelaDao.selektujKlimu();
                        List<Boja> bojas = MetodeTabelaDao.selektujBoju();
                        List<RegistrovanDo> registrovanDos = MetodeTabelaDao.selektujRegistraciju();
                        List<Ostecenje> ostecenjes = MetodeTabelaDao.selektujOstecenje();
                        List<PorekloVozila> porekloVozilas = MetodeTabelaDao.selektujPoreklo();
                    %>
                    <table border="1px">
                        <tr><td><select  id="marka" name="marka" requred>
                                    <option value="">--Izaberi marku--</option>
                                    <% for (Proizvodjac pro : proizvodjac) {%>
                                    <option value="<%=pro.getProizvodjacId()%>"><%=pro.getProizvodjacIme()%> </option><%}%>
                                </select> </td>
                            <td><select id="model" name="model" required></select></td></tr>
                        <tr><td> <select name="proizvodnja" required>
                                    <option value="">--Izaberi godiste--</option> 
                                    <% for (GodinaProizvodnje god : godina) {%>
                                    <option value="<%=god.getGodinaProizvodnjeId()%>"><%=god.getGodinaProizvodnje()%>
                                    </option>
                                    <%}%>
                                </select></td>
                            <td><select name="karoserija" required>
                                    <option value="">--Izaberi karoseriju--</option>
                                    <% for (Karoserija karos : karoserijas) {%>
                                    <option value="<%=karos.getKaroserijaId()%>"><%=karos.getKaroserija()%></option>
                                    <%}%>
                                </select></td></tr>
                        <tr><td><select name="kubikaza" required>
                                    <option value="">--Izaberi kubikazu--</option>
                                    <% for (Kubikaza kubi : kubikazas) {%>
                                    <option value="<%=kubi.getKubikazaId()%>"><%=kubi.getKubikaza()%></option>
                                    <%}%>
                                </select></td>
                            <td> <select name="gorivo" required>
                                    <option value="">--Izaberi gorivo--</option>
                                    <% for (Gorivo gor : gorivos) {%>
                                    <option value="<%=gor.getGorivoId()%>"><%=gor.getGorivo()%></option>
                                    <%}%>
                                </select></td></tr>
                        <tr><td><select name="snaga" required>
                                    <option value="">--Izaberi snagu--</option>
                                    <% for (SnagaKs ks : snagaKses) {%>
                                    <option value="<%=ks.getSnagaKsId()%>"><%=ks.getSnagaKs()%></option>
                                    <%}%>
                                </select></td>
                            <td><select name="kilometraza" required>
                                    <option value="">--Izaberi kilometrazu--</option>
                                    <% for (Kilometraza km : kilometrazas) {%>
                                    <option value="<%=km.getKilometrazaId()%>"><%=km.getKilometraza()%></option>
                                    <%}%>
                                </select></td></tr>
                        <tr><td><select name="ems" required>
                                    <option value="">--Izaberi emisiju motora--</option>
                                    <% for (EmisionaKlasaMotora ems : emisionaKlasaMotoras) {%>
                                    <option value="<%=ems.getEmisionaKlasaMotoraId()%>"><%=ems.getEmisionaKlasaMotora()%></option>
                                    <%}%>
                                </select></td>
                            <td> <select name="pogon" required>
                                    <option value="">--Izaberi pogon--</option>
                                    <% for (Pogon pog : pogons) {%>
                                    <option value="<%=pog.getPogonId()%>"><%=pog.getPogon()%></option>
                                    <%}%>
                                </select></td></tr>
                        <tr><td><select name="menjac" required>
                                    <option value="">--Izaberi menjac--</option>
                                    <% for (Menjac menj : menjacs) {%>
                                    <option value="<%=menj.getMenjacId()%>"><%=menj.getMenjac()%></option>
                                    <%}%>
                                </select></td>
                            <td><select name="vrata" required>
                                    <option value="">--Izaberi broj vrata--</option>
                                    <% for (BrojVrata vrata : brojVratas) {%>
                                    <option value="<%=vrata.getBrojVrataId()%>"><%=vrata.getBrojVrata()%></option>
                                    <%}%>
                                </select></td></tr>
                        <tr><td><select name="sedista" required>
                                    <option value="">--Izaberi broj sedista--</option>
                                    <% for (BrojSedista sed : brojSedistas) {%>
                                    <option value="<%=sed.getBrojSedistaId()%>"><%=sed.getBrojSedista()%></option>
                                    <%}%>
                                </select></td>
                            <td><select name="volan" required>
                                    <option value="">--Izaberi stranu volana--</option>
                                    <% for (StranaVolana sv : stranaVolanas) {%>
                                    <option value="<%=sv.getStranaVolanaId()%>"><%=sv.getStranaVolana()%></option>
                                    <%}%>               
                                </select></td></tr>
                        <tr><td><select name="klima" required>
                                    <option value="">--Izaberi klimu--</option>
                                    <% for (Klima klima : klimas) {%>
                                    <option value="<%=klima.getKlimaId()%>"><%=klima.getKlima()%></option>
                                    <%}%> 
                                </select></td>
                            <td><select name="boja" required>
                                    <option value="">--Izaberi boju--</option>
                                    <% for (Boja boja : bojas) {%>
                                    <option value="<%=boja.getBojaId()%>"><%=boja.getBoja()%></option>
                                    <%}%> 
                                </select></td></tr>
                        <tr><td><select name="registrovan" required>
                                    <option value="">--Izaberi registrovan do--</option>
                                    <% for (RegistrovanDo reg : registrovanDos) {%>
                                    <option value="<%=reg.getRegistrovanDoId()%>"><%=reg.getRegistrovanDo()%></option>
                                    <%}%>
                                </select></td>
                            <td><select name="ostecenje" required>
                                    <option value="">--Izaberi ostecenje--</option>
                                    <% for (Ostecenje ost : ostecenjes) {%>
                                    <option value="<%=ost.getOstecenjeId()%>"><%=ost.getOstecenje()%></option>
                                    <%}%>
                                </select></td></tr>
                        <tr><td><select name="poreklo" required>
                                    <option value="">--Izaberi poreklo--</option>
                                    <% for (PorekloVozila por : porekloVozilas) {%>
                                    <option value="<%=por.getPorekloVozilaId()%>"><%=por.getPorekloVozila()%></option>
                                    <%}%>
                                </select></td>
                            <td> <input type="text" name="telefon" placeholder="--Unesite telefon--" required></td></tr>
                        <tr> <td> <input type="text" name="cena" placeholder="--Unesite cenu--" required></td>
                            <td><input type="file" name="file" id="file" /></td></tr> <br/>
                        <input type="hidden" value="C:\Users\NenadIvana\Documents\NetBeansProjects\AutoPijaca\web\PijacaSlike/" name="destination"/>
                    </table>
                    <br/>
                    <pre><input type="submit" value="Postavi oglas">        <input type="reset" value="Obrisi podatke"></pre>
                </form>
                <br/>
            </div>
        </div>
    </body>
</html>
