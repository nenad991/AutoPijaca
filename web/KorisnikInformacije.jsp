<%@page import="java.util.List"%>
<%@page import="Entity.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="back4">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacije</title>
        <link rel="stylesheet" type="text/css" href="Css/InformacijeStilizacija.css">
        <link rel="stylesheet" type="text/css" href="Css/navBarStilizacija.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="JS/JsPocetna.js" ></script>
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
            <% List<Korisnik> koris = (List<Korisnik>) session.getAttribute("koris");%>  
            <% for (Korisnik kor : koris) {%>
            <div id="info">
                <h3 align="center">Informacije o korisniku:</h3>
                <table  border="1px white" align="center">
                    <tr><td>Ime:</td><td><%=kor.getIme()%></td></tr>
                    <tr><td>Prezime:</td><td><%=kor.getPrezime()%></td></tr>
                    <tr><td>Datum rodjenja:</td><td><%=kor.getDatumRodjenja()%></td></tr>
                    <tr><td>Pol:</td><td><%=kor.getPol()%></td></tr>
                    <tr><td>Zemlja:</td><td><%=kor.getZemlja()%></td></tr>
                    <tr><td>Korisnicko ime:</td><td><%=kor.getKorisnickoIme()%></td></tr>                   
                    <tr><td>Email:</td><td><%=kor.getEmail()%></td></tr>
                    <tr><td>Telefon:</td><td><%=kor.getTelefon()%></td></tr>
                </table>
                <%}%>
               <br/>
                <table border="1px white" align="center">
                    <tr><td align="center">Promenite lozinku:</td></tr>
               <tr><td> <form method="post" action="PromenaServlet" >  
                    <input type="password" name="pass" required placeholder="Unesite novu lozinku">
                    <% for (Korisnik kor : koris) {%>
                    <input type="hidden" name="userId" value="<%=kor.getKorisnikId()%>">
                    <%}%>                  
                     <input type="submit" value="Promenite lozinku">
                </form></td></tr>
                </table>
            </div>
        </div>
    </body>
</html>
